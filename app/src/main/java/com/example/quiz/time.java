package com.example.quiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.quiz.databinding.FragmentTimeBinding;


public class time extends Fragment {

    private FragmentTimeBinding binding = null;

    public time() {

    }


    public static time newInstance() {
        time fragment = new time();
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
        binding = FragmentTimeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}