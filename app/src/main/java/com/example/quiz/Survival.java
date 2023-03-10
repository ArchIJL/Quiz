package com.example.quiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.quiz.databinding.FragmentSurvivalBinding;

public class Survival extends Fragment {

    private FragmentSurvivalBinding binding = null;

    public Survival() {

    }


    public static Survival newInstance() {
        Survival fragment = new Survival();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSurvivalBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}