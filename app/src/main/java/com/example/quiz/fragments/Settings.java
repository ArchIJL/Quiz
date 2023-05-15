package com.example.quiz.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quiz.R;
import com.example.quiz.databinding.FragmentSettingsBinding;
import com.example.quiz.dialogfragments.AuthenticationGoogle;
import com.example.quiz.dialogfragments.DialogNickname;
import com.example.quiz.dialogfragments.ScoreUsersSurvival;
import com.example.quiz.dialogfragments.ScoreUsersTime;
import com.example.quiz.model.MyViewModel;
import com.example.quiz.model.SettingsViewModel;
import com.example.quiz.sound.SoundService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;


public class Settings extends Fragment {

    private FragmentSettingsBinding binding = null;

    private SettingsViewModel settingsViewModel;
    private MyViewModel myViewModel;

    private SwitchCompat soundSwitch;
    private SwitchCompat vibrationSwitch;
    private SwitchCompat notificationSwitch;
    private TextView mProgressCampaign;
    private TextView mProgressTime;
    private TextView mProgressSurvival;
    private LinearLayout mScoreTime;
    private LinearLayout mScoreSurvival;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingsViewModel = new ViewModelProvider(requireActivity()).get(SettingsViewModel.class);
        myViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        Toolbar toolbar = binding.toolbar;
        toolbar.setTitle("Опции");
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view1 -> requireActivity().onBackPressed());

        mProgressCampaign = binding.progressCampaign;
        mProgressTime = binding.progressTime;
        mProgressSurvival = binding.progressSurvival;

        int progressCampaign = 0;
        int progressTime = settingsViewModel.getHighestScoreTime().getValue();
        int progressSurvival = settingsViewModel.getHighestScoreSurvival().getValue();

        for (int i = 1; i <=7; i++){
            for (int j = 1; j <= 20; j++){
                if (myViewModel.getCompleted(i, j)){
                    progressCampaign++;
                }
            }
        }

        mProgressCampaign.setText(getString(R.string.num_campaign_settings, progressCampaign));
        mProgressTime.setText(getString(R.string.num_score_settings, progressTime));
        mProgressSurvival.setText(getString(R.string.num_score_settings, progressSurvival));

        mScoreTime = binding.scoreTime;
        mScoreSurvival = binding.scoreSurvival;

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if (user != null){
            String uid = user.getUid();
            DocumentReference userRef = FirebaseFirestore.getInstance().collection("users").document(uid);
            userRef.get().addOnSuccessListener(documentSnapshot -> {
                if (documentSnapshot.exists() && documentSnapshot.contains("nickname")){
                    userRef.update("ScoreSurvival", progressSurvival);
                    userRef.update("ScoreTime", progressTime);
                }
            });
        }

        mScoreTime.setOnClickListener(v -> {
            if (user != null) {
                List<? extends UserInfo> providerData = user.getProviderData();
                for (UserInfo info : providerData) {
                    if (info.getProviderId().equals("google.com")) {
                        String uid = user.getUid();
                        DocumentReference userRef = FirebaseFirestore.getInstance().collection("users").document(uid);
                        userRef.get().addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot != null && documentSnapshot.exists() && documentSnapshot.contains("nickname")) {
                                DialogFragment scoreUsers = new ScoreUsersTime();
                                scoreUsers.show(getParentFragmentManager(), "ScoreUsers");
                                Log.d("Firestore Nickname", "Such document");
                            } else {
                                DialogFragment nicknameUser = new DialogNickname();
                                nicknameUser.show(getParentFragmentManager(), "nicknameUser");
                                Log.d("Firestore Nickname", "No such document");
                            }
                        }).addOnFailureListener(e -> Log.e("Firestore", "Error getting document: " + e));
                    }
                }
            } else {
                // Пользователь не авторизован
                DialogFragment authentication = new AuthenticationGoogle();
                authentication.show(getParentFragmentManager(), "AuthenticationGoogle");
            }
        });

        mScoreSurvival.setOnClickListener(v -> {
            if (user != null){
                List<? extends UserInfo> providerData = user.getProviderData();
                for (UserInfo info : providerData) {
                    if (info.getProviderId().equals("google.com")) {
                        // Пользователь авторизован

                        DialogFragment scoreUsers = new ScoreUsersSurvival();
                        scoreUsers.show(getParentFragmentManager(), "ScoreUsers");
                        break;
                    }
                }
            } else {
                // Пользователь не авторизован
                DialogFragment authentication = new AuthenticationGoogle();
                authentication.show(getParentFragmentManager(), "AuthenticationGoogle");
            }
        });

        soundSwitch = binding.soundSwitch;
        vibrationSwitch = binding.vibrationSwitch;
        notificationSwitch = binding.notificationSwitch;

        soundSwitch.setChecked(settingsViewModel.isSoundEnabled());
        vibrationSwitch.setChecked(settingsViewModel.isVibrationEnabled());
        notificationSwitch.setChecked(settingsViewModel.isNotificationEnabled());


        soundSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsViewModel.setSoundEnabled(isChecked);
            settingsViewModel.saveSettings(requireContext());
            if (isChecked){
                getActivity().startService(new Intent(getActivity(), SoundService.class));
            } else {
                getActivity().stopService(new Intent(getActivity(), SoundService.class));
            }
        });

        vibrationSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsViewModel.setVibrationEnabled(isChecked);
            settingsViewModel.saveSettings(requireContext());
        });

        notificationSwitch.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            settingsViewModel.setNotificationEnabled(isChecked);
            settingsViewModel.saveSettings(requireContext());
        }));

        return binding.getRoot();
    }
}