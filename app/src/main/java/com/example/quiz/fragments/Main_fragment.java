package com.example.quiz.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.quiz.R;
import com.example.quiz.databinding.FragmentMainFragmentBinding;
import com.example.quiz.model.MyViewModel;
import com.example.quiz.model.QuestionsTaSViewModel;

public class Main_fragment extends Fragment {

    public final String TAG = "main";

    private MyViewModel viewModel;
    private QuestionsTaSViewModel TaSViewModel;
    private FragmentMainFragmentBinding binding = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        TaSViewModel = new ViewModelProvider(this).get(QuestionsTaSViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainFragmentBinding.inflate(inflater, container, false);

        FragmentManager fragmentManager = getParentFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        Log.d(TAG, "Number of fragments on back stack: " + backStackEntryCount);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binding.button1.setOnClickListener(v1 -> Navigation.findNavController(v1)
                .navigate(R.id.action_main_fragment_to_campaign));
        binding.button2.setOnClickListener(v2 -> Navigation.findNavController(v2)
                .navigate(R.id.action_main_fragment_to_time));
        binding.button3.setOnClickListener(v3 -> Navigation.findNavController(v3)
                .navigate(R.id.action_main_fragment_to_survival));
        binding.button4.setOnClickListener(v4 -> Navigation.findNavController(v4)
                .navigate(R.id.action_main_fragment_to_settings));
    }
}