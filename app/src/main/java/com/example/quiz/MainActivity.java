package com.example.quiz;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.quiz.model.MyViewModel;
import com.example.quiz.model.SettingsViewModel;
import com.example.quiz.notification.CheckLoginReceiver;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyViewModel viewModel;
    private SettingsViewModel settingsViewModel;

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_main);

        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        scheduleCheckLogin();

        settingsViewModel.loadSettings(this);
        viewModel.loadData(this);
        viewModel.loadButtonData(this);

        boolean isSoundEnabled = settingsViewModel.isSoundEnabled();
        if (isSoundEnabled){
            startService(new Intent(this, SoundService.class));
        }
    }

    private void scheduleCheckLogin() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, CheckLoginReceiver.class);
        intent.setAction(CheckLoginReceiver.ACTION_CHECK_LOGIN);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        long intervalMillis = 24 * 60 * 60 * 1000; // 1 день в миллисекундах
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + intervalMillis, intervalMillis, pendingIntent);
    }

    private void saveLastLoginTime() {
        SharedPreferences preferences = getSharedPreferences("MyAppPreferences", MODE_PRIVATE);
        long currentTimeMillis = System.currentTimeMillis();
        preferences.edit().putLong("lastLoginTimeMillis", currentTimeMillis).apply();
        Log.d("CheckLoginService", "lastLoginTimeMillis = " + currentTimeMillis);
    }

    public static class Question {

        private final String mText;
        private final List<String> mOptions;
        private final String mCorrectOption;

        public Question(String text, String option1, String option2, String option3, String option4) {
            mText = text;
            mOptions = new ArrayList<>();
            mOptions.add(option1);
            mOptions.add(option2);
            mOptions.add(option3);
            mOptions.add(option4);
            mCorrectOption = option1;
        }

        public String getText() {
            return mText;
        }

        public List<String> getOptions() {
            return mOptions;
        }

        public String getCorrectOption() {
            return mCorrectOption;
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        saveLastLoginTime();

        boolean isSoundEnabled = settingsViewModel.isSoundEnabled();
        if (isSoundEnabled){
            startService(new Intent(this, SoundService.class));
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        saveLastLoginTime();
        settingsViewModel.saveSettings(this);
        viewModel.saveData(this);
        viewModel.saveButtonData(this);

        stopService(new Intent(this, SoundService.class));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        saveLastLoginTime();
        settingsViewModel.saveSettings(this);
        viewModel.saveData(this);
        viewModel.saveButtonData(this);

        stopService(new Intent(this, SoundService.class));
    }
}