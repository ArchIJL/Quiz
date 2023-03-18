package com.example.quiz.levels;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.quiz.R;


public class geography_level extends Fragment {


    public geography_level() {
        // Required empty public constructor
    }

    public static geography_level newInstance(String param1, String param2) {
        geography_level fragment = new geography_level();
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

        return inflater.inflate(R.layout.fragment_geography_level, container, false);
    }
}