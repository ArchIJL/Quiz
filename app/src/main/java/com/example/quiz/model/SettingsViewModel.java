package com.example.quiz.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.VibrationEffect;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private MutableLiveData<Boolean> soundEnabled = new MutableLiveData<>(true);
    private MutableLiveData<Boolean> vibrationEnabled = new MutableLiveData<>(true);
    private MutableLiveData<Boolean> notificationEnabled = new MutableLiveData<>(true);

    private boolean isSoundEnabled = true;
    private boolean isVibrationEnabled = true;
    private boolean isNotificationEnabled = true;

    private MutableLiveData<Integer> highestScoreTime = new MutableLiveData<>(0);
    private MutableLiveData<Integer> highestScoreSurvival = new MutableLiveData<>(0);


    public boolean isSoundEnabled() {
        return isSoundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        isSoundEnabled = soundEnabled;
    }

    public boolean isVibrationEnabled() {
        return isVibrationEnabled;
    }

    public void setVibrationEnabled(boolean vibrationEnabled) {
        isVibrationEnabled = vibrationEnabled;
    }

    public boolean isNotificationEnabled(){
        return isNotificationEnabled;
    }

    public void setNotificationEnabled(boolean notificationEnabled){
        isNotificationEnabled = notificationEnabled;
    }

    public MutableLiveData<Integer> getHighestScoreTime() {
        return highestScoreTime;
    }

    public void setHighestScoreTime(int score) {
        if (score > highestScoreTime.getValue()){
            highestScoreTime.setValue(score);
        }
    }

    public MutableLiveData<Integer> getHighestScoreSurvival() {
        return highestScoreSurvival;
    }

    public void setHighestScoreSurvival(int score) {
        if (score > highestScoreSurvival.getValue()){
            highestScoreSurvival.setValue(score);
        }
    }

    public void loadSettings(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsViewModel", Context.MODE_PRIVATE);
        isSoundEnabled = sharedPreferences.getBoolean("sound_enabled", true);
        isVibrationEnabled = sharedPreferences.getBoolean("vibration_enabled", true);
        isNotificationEnabled = sharedPreferences.getBoolean("notification_enabled", true);
        highestScoreTime.setValue(sharedPreferences.getInt("highest_score_time", 0));
        highestScoreSurvival.setValue(sharedPreferences.getInt("highest_score_survival", 0));
    }

    public void saveSettings(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsViewModel", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("sound_enabled", isSoundEnabled);
        editor.putBoolean("vibration_enabled", isVibrationEnabled);
        editor.putBoolean("notification_enabled", isNotificationEnabled);
        editor.putInt("highest_score_time", highestScoreTime.getValue());
        editor.putInt("highest_score_survival", highestScoreSurvival.getValue());
        editor.apply();
    }

    public VibrationEffect getVibrationEffect() {
        if (isVibrationEnabled()) {
            // вернуть желаемый эффект вибрации
            return VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE);
        } else {
            // вернуть ноль, чтобы указать, что вибрация не должна использоваться
            return null;
        }
    }
}
