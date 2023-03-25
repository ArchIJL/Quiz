package com.example.quiz;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import com.example.quiz.databinding.FragmentMainFragmentBinding;

public class main_fragment extends Fragment {

    public final String TAG = "main";

    private FragmentMainFragmentBinding binding = null;


    public static main_fragment newInstance() {
        main_fragment fragment = new main_fragment();
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
                .navigate(R.id.action_main_fragment_to_options));

    }


}