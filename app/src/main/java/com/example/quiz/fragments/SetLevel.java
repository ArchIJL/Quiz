package com.example.quiz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.quiz.R;
import com.example.quiz.databinding.FragmentSetLevelBinding;
import com.example.quiz.model.MyViewModel;

import java.util.ArrayList;


public class SetLevel extends Fragment {

    private FragmentSetLevelBinding binding = null;

    private MyViewModel viewModel;

    private ArrayList<Button> levels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSetLevelBinding.inflate(inflater, container, false);

        Toolbar toolbar = binding.toolbar;
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view1 -> SetLevel.this.requireActivity().onBackPressed());
        int categoryId = viewModel.getCategoryId();
        switch (categoryId){
            case 1:
                toolbar.setTitle("География");
                break;
            case 2:
                toolbar.setTitle("Наука");
                break;
            case 3:
                toolbar.setTitle("История");
                break;
            case 4:
                toolbar.setTitle("Спорт");
                break;
            case 5:
                toolbar.setTitle("Кино");
                break;
            case 6:
                toolbar.setTitle("Игры");
                break;
            case 7:
                toolbar.setTitle("Кулинария");
                break;
        }

        levels = new ArrayList<>();
        levels.add(binding.setLevel1);
        levels.add(binding.setLevel2);
        levels.add(binding.setLevel3);
        levels.add(binding.setLevel4);
        levels.add(binding.setLevel5);
        levels.add(binding.setLevel6);
        levels.add(binding.setLevel7);
        levels.add(binding.setLevel8);
        levels.add(binding.setLevel9);
        levels.add(binding.setLevel10);
        levels.add(binding.setLevel11);
        levels.add(binding.setLevel12);
        levels.add(binding.setLevel13);
        levels.add(binding.setLevel14);
        levels.add(binding.setLevel15);
        levels.add(binding.setLevel16);
        levels.add(binding.setLevel17);
        levels.add(binding.setLevel18);
        levels.add(binding.setLevel19);
        levels.add(binding.setLevel20);

        Button b1 = levels.get(0);
        if (viewModel.getCompleted(categoryId, 1)){
            b1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b2 = levels.get(1);
        if (viewModel.getCompleted(categoryId, 2)){
            b2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b3 = levels.get(2);
        if (viewModel.getCompleted(categoryId, 3)){
            b3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b4 = levels.get(3);
        if (viewModel.getCompleted(categoryId, 4)){
            b4.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b5 = levels.get(4);
        if (viewModel.getCompleted(categoryId, 5)){
            b5.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b6 = levels.get(5);
        if (viewModel.getCompleted(categoryId, 6)){
            b6.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b7 = levels.get(6);
        if (viewModel.getCompleted(categoryId, 7)){
            b7.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b8 = levels.get(7);
        if (viewModel.getCompleted(categoryId, 8)){
            b8.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b9 = levels.get(8);
        if (viewModel.getCompleted(categoryId, 9)){
            b9.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b10 = levels.get(9);
        if (viewModel.getCompleted(categoryId, 10)){
            b10.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b11 = levels.get(10);
        if (viewModel.getCompleted(categoryId, 11)){
            b11.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b12 = levels.get(11);
        if (viewModel.getCompleted(categoryId, 12)){
            b12.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b13 = levels.get(12);
        if (viewModel.getCompleted(categoryId, 13)){
            b13.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b14 = levels.get(13);
        if (viewModel.getCompleted(categoryId, 14)){
            b14.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b15 = levels.get(14);
        if (viewModel.getCompleted(categoryId, 15)){
            b15.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b16 = levels.get(15);
        if (viewModel.getCompleted(categoryId, 16)){
            b16.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b17 = levels.get(16);
        if (viewModel.getCompleted(categoryId, 17)){
            b17.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b18 = levels.get(17);
        if (viewModel.getCompleted(categoryId, 18)){
            b18.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b19 = levels.get(18);
        if (viewModel.getCompleted(categoryId, 19)){
            b19.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }
        Button b20 = levels.get(19);
        if (viewModel.getCompleted(categoryId, 20)){
            b20.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_complete));
        }

        return binding.getRoot();
    }

    public void navigation(int levelId){
        viewModel.setLevelId(levelId);
        Navigation.findNavController(getView()).navigate(R.id.action_set_level_to_level);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.setLevel1.setOnClickListener(v -> {
            navigation(1);
        });

        binding.setLevel2.setOnClickListener(v -> {
            navigation(2);
        });

        binding.setLevel3.setOnClickListener(v -> {
            navigation(3);
        });

        binding.setLevel4.setOnClickListener(v -> {
            navigation(4);
        });

        binding.setLevel5.setOnClickListener(v -> {
            navigation(5);
        });

        binding.setLevel6.setOnClickListener(v -> {
            navigation(6);
        });

        binding.setLevel7.setOnClickListener(v -> {
            navigation(7);
        });

        binding.setLevel8.setOnClickListener(v -> {
            navigation(8);
        });

        binding.setLevel9.setOnClickListener(v -> {
            navigation(9);
        });

        binding.setLevel10.setOnClickListener(v -> {
            navigation(10);
        });

        binding.setLevel11.setOnClickListener(v -> {
            navigation(11);
        });

        binding.setLevel12.setOnClickListener(v -> {
            navigation(12);
        });

        binding.setLevel13.setOnClickListener(v -> {
            navigation(13);
        });

        binding.setLevel14.setOnClickListener(v -> {
            navigation(14);
        });

        binding.setLevel15.setOnClickListener(v -> {
            navigation(15);
        });

        binding.setLevel16.setOnClickListener(v -> {
            navigation(16);
        });

        binding.setLevel17.setOnClickListener(v -> {
            navigation(17);
        });

        binding.setLevel18.setOnClickListener(v -> {
            navigation(18);
        });

        binding.setLevel19.setOnClickListener(v -> {
            navigation(19);
        });

        binding.setLevel20.setOnClickListener(v -> {
            navigation(20);
        });
    }
}