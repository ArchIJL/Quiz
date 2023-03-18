package com.example.quiz.levels;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.Navigation;

import com.example.quiz.R;
import com.example.quiz.databinding.FragmentFoodLevelBinding;


public class food_level extends Fragment {

    private FragmentFoodLevelBinding binding = null;


    public food_level() {
        // Required empty public constructor
    }


    public static food_level newInstance(String param1, String param2) {
        food_level fragment = new food_level();
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
        binding = FragmentFoodLevelBinding.inflate(inflater, container, false);
        Toolbar toolbar = binding.toolbar;
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });
        toolbar.setTitle("Уровни: Еда");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.foodLevel1.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 1);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel2.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 2);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel3.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 3);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel4.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 4);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel5.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 5);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel6.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 6);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel7.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 7);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel8.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 8);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel9.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 9);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel10.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 10);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel11.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 11);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel12.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 12);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel13.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 13);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel14.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 14);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel15.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 15);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel16.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 16);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel17.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 17);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel18.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 18);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel19.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 19);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });

        binding.foodLevel20.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("levelId", 20);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level, args);
        });


    }
}