package com.example.quiz.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.VibrationEffect;
import android.preference.PreferenceManager;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private MutableLiveData<Boolean> soundEnabled = new MutableLiveData<>(true);
    private MutableLiveData<Boolean> vibrationEnabled = new MutableLiveData<>(true);
    private MutableLiveData<Boolean> notificationEnabled = new MutableLiveData<>(true);

    private boolean isSoundEnabled = true;
    private boolean isVibrationEnabled = true;
    private boolean isNotificationEnabled = true;


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

    public void loadSettings(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        isSoundEnabled = sharedPreferences.getBoolean("sound_enabled", true);
        isVibrationEnabled = sharedPreferences.getBoolean("vibration_enabled", true);
        isNotificationEnabled = sharedPreferences.getBoolean("notification_enabled", true);
    }

    public void saveSettings(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("sound_enabled", isSoundEnabled);
        editor.putBoolean("vibration_enabled", isVibrationEnabled);
        editor.putBoolean("notification_enabled", isNotificationEnabled);
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
