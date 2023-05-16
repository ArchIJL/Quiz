package com.example.quiz.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.util.Pair;

import androidx.lifecycle.ViewModel;

import com.example.quiz.questions.QuestionCampaign;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyViewModel extends ViewModel {

    public int categoryId;
    public int levelId;
    public String versionDatabase;
    public Map<Integer, String> correctAnswers = new HashMap<>(140);
    public HashMap<Pair<Integer, Integer>, ArrayList<Pair<String, Boolean>>> buttonData = new HashMap<>();
    public Map<Pair<Integer, Integer>, Boolean> resetButtonStates = new HashMap<>();
    public Map<Integer, Map<Integer, Boolean>> completionStatus = new HashMap<>();
    public Map<String, Map<String, QuestionCampaign>> questionMap = new HashMap<>();


    public void setCategoryId(int categoryId){
        this.categoryId = categoryId;
    }

    public int getCategoryId(){
        return categoryId;
    }

    public void setLevelId(int levelId){
        this.levelId = levelId;
    }

    public int getLevelId(){
        return levelId;
    }

    public String getVersionDatabase() {
        return versionDatabase;
    }

    public void setVersionDatabase(String versionDatabase) {
        this.versionDatabase = versionDatabase;
    }

    public void setCorrectAnswer(int questionNumber, String correctAnswer){
        correctAnswers.put(questionNumber, correctAnswer);
    }

    public String getCorrectAnswer(int questionNumber){
        return correctAnswers.get(questionNumber);
    }

    public void setCompleted(int categoryId, int levelId, boolean value) {
        if (!completionStatus.containsKey(categoryId)) {
            completionStatus.put(categoryId, new HashMap<Integer, Boolean>());
        }
        Map<Integer, Boolean> categoryCompletionStatus = completionStatus.get(categoryId);
        categoryCompletionStatus.put(levelId, value);
    }

    public boolean getCompleted(int categoryId, int levelId) {
        if (!completionStatus.containsKey(categoryId)) {
            return false;
        }
        Map<Integer, Boolean> categoryCompletionStatus = completionStatus.get(categoryId);
        if (!categoryCompletionStatus.containsKey(levelId)) {
            return false;
        }
        return categoryCompletionStatus.get(levelId);
    }

    public void setQuestionMap(Map<String, Map<String, QuestionCampaign>> questionMap) {
        this.questionMap = questionMap;
        Log.v("ViewModelHashMap", String.valueOf(this.questionMap));
    }

    public Map<String, Map<String, QuestionCampaign>> getQuestionMap() {
        return questionMap;
    }

    public void saveQuestionMap(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyQuestion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(questionMap);
        editor.putString("QuestionMap", json);
        editor.apply();
    }

    public void loadQuestionMap(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyQuestion", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("QuestionMap", "");
        if (!json.isEmpty()) {
            questionMap = gson.fromJson(json, new TypeToken<Map<String, Map<String, QuestionCampaign>>>(){}.getType());
        }
    }

    public void saveData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyViewModel", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("dbVersion", versionDatabase);
        editor.putInt("levelId", levelId);
        editor.putInt("categoryId", categoryId);
        editor.putInt("numQuestions", correctAnswers.size());
        for (Map.Entry<Integer, String> entry : correctAnswers.entrySet()) {
            editor.putString("correctAnswer" + entry.getKey(), entry.getValue());
        }

        editor.putInt("numCategories", completionStatus.size());
        int categoryIndex = 0;
        for (Map.Entry<Integer, Map<Integer, Boolean>> categoryEntry : completionStatus.entrySet()) {
            int categoryId = categoryEntry.getKey();
            Map<Integer, Boolean> categoryCompletionStatus = categoryEntry.getValue();
            editor.putInt("categoryId" + categoryIndex, categoryId);
            editor.putInt("numLevels" + categoryIndex, categoryCompletionStatus.size());
            int levelIndex = 0;
            for (Map.Entry<Integer, Boolean> levelEntry : categoryCompletionStatus.entrySet()) {
                int levelId = levelEntry.getKey();
                boolean completed = levelEntry.getValue();
                editor.putInt("levelId" + categoryIndex + "_" + levelIndex, levelId);
                editor.putBoolean("completed" + categoryIndex + "_" + levelIndex, completed);
                levelIndex++;
            }
            categoryIndex++;
        }
        editor.apply();
    }

    public void loadData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyViewModel", Context.MODE_PRIVATE);

        versionDatabase = sharedPreferences.getString("dbVersion", "0");
        levelId = sharedPreferences.getInt("levelId", 0);
        categoryId = sharedPreferences.getInt("categoryId", 0);
        int numQuestions = sharedPreferences.getInt("numQuestions", 0);

        // Initialize all the correct answers to null
        for (int i = 1; i <= 140; i++) {
            if (!correctAnswers.containsKey(i)) {
                correctAnswers.put(i, null);
            }
        }

        // Update the correct answers for the questions that were previously answered
        for (int i = 1; i <= numQuestions; i++) {
            String correctAnswer = sharedPreferences.getString("correctAnswer" + i, null);
            if (correctAnswer != null) {
                correctAnswers.put(i, correctAnswer);
            }
        }

        int numCategories = sharedPreferences.getInt("numCategories", 0);
        for (int i = 0; i < numCategories; i++) {
            int categoryId = sharedPreferences.getInt("categoryId" + i, 0);
            int numLevels = sharedPreferences.getInt("numLevels" + i, 0);
            for (int j = 0; j < numLevels; j++) {
                int levelId = sharedPreferences.getInt("levelId" + i + "_" + j, 0);
                boolean completed = sharedPreferences.getBoolean("completed" + i + "_" + j, false);
                setCompleted(categoryId, levelId, completed);
            }
        }
    }

    // get the button text and isEnabled state for a specific category and level
    public ArrayList<Pair<String, Boolean>> getButtonData(int categoryId, int levelId) {
        return buttonData.get(new Pair<>(categoryId, levelId));
    }

    // set the button text and isEnabled state for a specific category and level
    public void setButtonData(int categoryId, int levelId, ArrayList<Pair<String, Boolean>> data) {
        buttonData.put(new Pair<>(categoryId, levelId), data);
    }

    public boolean getResetButtonState(int categoryId, int levelId) {
        Pair<Integer, Integer> categoryLevelPair = new Pair<>(categoryId, levelId);
        if (resetButtonStates.containsKey(categoryLevelPair)) {
            return resetButtonStates.get(categoryLevelPair);
        } else {
            return true;
        }
    }

    public void setResetButtonState(int categoryId, int levelId, boolean isEnabled) {
        Pair<Integer, Integer> categoryLevelPair = new Pair<>(categoryId, levelId);
        resetButtonStates.put(categoryLevelPair, isEnabled);
    }

    public void saveButtonData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyViewModel", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("buttonDataSize", buttonData.size());
        int i = 0;
        for (Map.Entry<Pair<Integer, Integer>, ArrayList<Pair<String, Boolean>>> entry : buttonData.entrySet()) {
            editor.putInt("buttonData" + i + "categoryId", entry.getKey().first);
            editor.putInt("buttonData" + i + "levelId", entry.getKey().second);
            editor.putInt("buttonData" + i + "size", entry.getValue().size());
            for (int j = 0; j < entry.getValue().size(); j++) {
                editor.putString("buttonData" + i + "text" + j, entry.getValue().get(j).first);
                editor.putBoolean("buttonData" + i + "isEnabled" + j, entry.getValue().get(j).second);
            }
            editor.putBoolean("resetButtonState" + i, resetButtonStates.getOrDefault(entry.getKey(), true));
            i++;
        }
        editor.putInt("numButtonData", i);
        editor.apply();
    }

    public void loadButtonData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyViewModel", Context.MODE_PRIVATE);
        int numButtonData = sharedPreferences.getInt("numButtonData", 0);
        for (int i = 0; i < numButtonData; i++) {
            int categoryId = sharedPreferences.getInt("buttonData" + i + "categoryId", 0);
            int levelId = sharedPreferences.getInt("buttonData" + i + "levelId", 0);
            int size = sharedPreferences.getInt("buttonData" + i + "size", 0);
            ArrayList<Pair<String, Boolean>> data = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                String text = sharedPreferences.getString("buttonData" + i + "text" + j, "");
                boolean isEnabled = sharedPreferences.getBoolean("buttonData" + i + "isEnabled" + j, true);
                data.add(new Pair<>(text, isEnabled));
            }
            buttonData.put(new Pair<>(categoryId, levelId), data);
            resetButtonStates.put(new Pair<>(categoryId, levelId), sharedPreferences.getBoolean("resetButtonState" + i, true));
        }
    }
}
