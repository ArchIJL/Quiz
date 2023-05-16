package com.example.quiz.model;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.ViewModel;

import com.example.quiz.questions.Question;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

public class QuestionsTaSViewModel extends ViewModel {

    public List<Question> mQuestions;


    public List<Question> getQuestions() {
        return mQuestions;
    }

    public void setQuestions(List<Question> questions) {
        mQuestions = questions;
    }

    public void saveQuestionsToPrefs(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(mQuestions);
        prefs.edit().putString("Questions", json).apply();
    }

    public void loadQuestionsFromPrefs(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("Questions", "");
        Type type = new TypeToken<List<Question>>() {}.getType();
        mQuestions = gson.fromJson(json, type);
    }

}
