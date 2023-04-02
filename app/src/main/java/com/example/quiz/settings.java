package com.example.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quiz.databinding.FragmentSettingsBinding;
import com.example.quiz.model.SettingsViewModel;


public class settings extends Fragment {

    private FragmentSettingsBinding binding = null;

    private SettingsViewModel settingsViewModel;

    private SwitchCompat soundSwitch;
    private SwitchCompat vibrationSwitch;
    private SwitchCompat notificationSwitch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingsViewModel = new ViewModelProvider(requireActivity()).get(SettingsViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        Toolbar toolbar = binding.toolbar;
        toolbar.setTitle("Опции");
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                requireActivity().onBackPressed();
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