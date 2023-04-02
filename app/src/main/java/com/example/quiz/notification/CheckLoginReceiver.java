package com.example.quiz.notification;

import static android.content.Context.MODE_PRIVATE;

import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.quiz.MainActivity;
import com.example.quiz.R;
import com.example.quiz.model.SettingsViewModel;

public class CheckLoginReceiver extends BroadcastReceiver {

    public static final String ACTION_CHECK_LOGIN = "com.example.quiz.ACTION_CHECK_LOGIN";
    public static final String CHANNEL_ID = "my_notification_channel";
    private static final int NOTIFICATION_ID = 12345;
    private SettingsViewModel settingsViewModel;


    @Override
    public void onReceive(Context context, Intent intent) {
        settingsViewModel = new ViewModelProvider.AndroidViewModelFactory((Application) context.getApplicationContext())
                .create(SettingsViewModel.class);
        boolean showNotification = settingsViewModel.isNotificationEnabled();
        if (showNotification) {
            if (shouldShowNotification(context)) {
                showNotification(context);
            }
        }
    }

    private boolean shouldShowNotification(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("MyAppPreferences", MODE_PRIVATE);
        long lastLoginTimeMillis = preferences.getLong("lastLoginTimeMillis", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long weekInMillis = 7 * 24 * 60 * 60 * 1000; // 1 неделя в миллисекундах
        return (currentTimeMillis - lastLoginTimeMillis) >= weekInMillis;
    }

    private void showNotification(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        // Создание уведомления с помощью NotificationCompat.Builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24) // Поменять картинку на картинку приложения
                .setContentTitle("Тебя не было целую неделю")
                .setContentText("Скорее заходи обратно")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        // Показать уведомление с помощью NotificationManagerCompat
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
