package com.example.quiz;


import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.quiz.model.MyViewModel;
import com.example.quiz.model.QuestionsTaSViewModel;
import com.example.quiz.model.SettingsViewModel;
import com.example.quiz.notification.CheckLoginReceiver;
import com.example.quiz.sound.SoundService;

public class MainActivity extends AppCompatActivity {

    private MyViewModel viewModel;
    private SettingsViewModel settingsViewModel;
    private QuestionsTaSViewModel TaSViewModel;

    private static final int NOTIFICATION_ID = 12345;

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_main);

        // Проверка на разрешение для отправки уведомлений
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, NOTIFICATION_ID);
        }


        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        TaSViewModel = new ViewModelProvider(this).get(QuestionsTaSViewModel.class);
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