package com.example.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.quiz.databinding.FragmentSetLevelBinding;
import com.example.quiz.model.MyViewModel;


public class set_level extends Fragment {

    private FragmentSetLevelBinding binding = null;

    private MyViewModel viewModel;

    public static set_level newInstance(String param1, String param2) {
        set_level fragment = new set_level();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

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
        toolbar.setNavigationOnClickListener(view1 -> set_level.this.requireActivity().onBackPressed());
        int categoryId = viewModel.getCategoryId();
        switch (categoryId){
            case 1:
                toolbar.setTitle("География");
                break;
            case 2:
                toolbar.setTitle("Логотипы");
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

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int categoryId = viewModel.getCategoryId();
        switch (categoryId){
            case 1:
                binding.setLevel1.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(1);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel2.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(2);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel3.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(3);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel4.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(4);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel5.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(5);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel6.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(6);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel7.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(7);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel8.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(8);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel9.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(9);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel10.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(10);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel11.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(11);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel12.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(12);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel13.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(13);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel14.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(14);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel15.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(15);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel16.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(16);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel17.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(17);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel18.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(18);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel19.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(19);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel20.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(20);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                break;

            case 2:
                binding.setLevel1.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(1);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel2.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(2);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel3.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(3);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel4.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(4);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel5.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(5);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel6.setOnClickListener(v -> {
                    viewModel.setCategoryId(1);
                    viewModel.setLevelId(6);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel7.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(7);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel8.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(8);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel9.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(9);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel10.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(10);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel11.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(11);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel12.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(12);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel13.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(13);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel14.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(14);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel15.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(15);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel16.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(16);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel17.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(17);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel18.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(18);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel19.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(19);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel20.setOnClickListener(v -> {
                    viewModel.setCategoryId(2);
                    viewModel.setLevelId(20);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                break;

            case 3:
                binding.setLevel1.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(1);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel2.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(2);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel3.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(3);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel4.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(4);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel5.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(5);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel6.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(6);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel7.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(7);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel8.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(8);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel9.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(9);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel10.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(10);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel11.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(11);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel12.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(12);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel13.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(13);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel14.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(14);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel15.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(15);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel16.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(16);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel17.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(17);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel18.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(18);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel19.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(19);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel20.setOnClickListener(v -> {
                    viewModel.setCategoryId(3);
                    viewModel.setLevelId(20);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                break;

            case 4:
                binding.setLevel1.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(1);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel2.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(2);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel3.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(3);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel4.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(4);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel5.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(5);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel6.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(6);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel7.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(7);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel8.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(8);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel9.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(9);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel10.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(10);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel11.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(11);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel12.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(12);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel13.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(13);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel14.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(14);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel15.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(15);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel16.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(16);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel17.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(17);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel18.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(18);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel19.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(19);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel20.setOnClickListener(v -> {
                    viewModel.setCategoryId(4);
                    viewModel.setLevelId(20);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                break;

            case 5:
                binding.setLevel1.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(1);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel2.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(2);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel3.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(3);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel4.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(4);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel5.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(5);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel6.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(6);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel7.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(7);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel8.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(8);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel9.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(9);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel10.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(10);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel11.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(11);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel12.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(12);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel13.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(13);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel14.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(14);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel15.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(15);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel16.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(16);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel17.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(17);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel18.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(18);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel19.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(19);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel20.setOnClickListener(v -> {
                    viewModel.setCategoryId(5);
                    viewModel.setLevelId(20);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                break;

            case 6:
                binding.setLevel1.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(1);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel2.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(2);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel3.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(3);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel4.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(4);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel5.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(5);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel6.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(6);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel7.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(7);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel8.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(8);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel9.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(9);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel10.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(10);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel11.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(11);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel12.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(12);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel13.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(13);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel14.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(14);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel15.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(15);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel16.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(16);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel17.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(17);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel18.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(18);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel19.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(19);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel20.setOnClickListener(v -> {
                    viewModel.setCategoryId(6);
                    viewModel.setLevelId(20);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                break;

            case 7:
                binding.setLevel1.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(1);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel2.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(2);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel3.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(3);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel4.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(4);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel5.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(5);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel6.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(6);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel7.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(7);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel8.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(8);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel9.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(9);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel10.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(10);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel11.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(11);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel12.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(12);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel13.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(13);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel14.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(14);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel15.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(15);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel16.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(16);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel17.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(17);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel18.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(18);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel19.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(19);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                binding.setLevel20.setOnClickListener(v -> {
                    viewModel.setCategoryId(7);
                    viewModel.setLevelId(20);
                    Navigation.findNavController(view).navigate(R.id.action_set_level_to_level);
                });

                break;
        }


        /*binding.foodLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setLevelId(1);
                Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
            }
        });

        binding.foodLevel2.setOnClickListener(v -> {
            viewModel.setLevelId(2);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel3.setOnClickListener(v -> {
            viewModel.setLevelId(3);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel4.setOnClickListener(v -> {
            viewModel.setLevelId(4);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel5.setOnClickListener(v -> {
            viewModel.setLevelId(5);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel6.setOnClickListener(v -> {
            viewModel.setLevelId(6);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel7.setOnClickListener(v -> {
            viewModel.setLevelId(7);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel8.setOnClickListener(v -> {
            viewModel.setLevelId(8);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel9.setOnClickListener(v -> {
            viewModel.setLevelId(9);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel10.setOnClickListener(v -> {
            viewModel.setLevelId(10);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel11.setOnClickListener(v -> {
            viewModel.setLevelId(11);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel12.setOnClickListener(v -> {
            viewModel.setLevelId(12);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel13.setOnClickListener(v -> {
            viewModel.setLevelId(13);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel14.setOnClickListener(v -> {
            viewModel.setLevelId(14);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel15.setOnClickListener(v -> {
            viewModel.setLevelId(15);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel16.setOnClickListener(v -> {
            viewModel.setLevelId(16);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel17.setOnClickListener(v -> {
            viewModel.setLevelId(17);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel18.setOnClickListener(v -> {
            viewModel.setLevelId(18);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel19.setOnClickListener(v -> {
            viewModel.setLevelId(19);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });

        binding.foodLevel20.setOnClickListener(v -> {
            viewModel.setLevelId(20);
            Navigation.findNavController(view).navigate(R.id.action_food_level_to_level);
        });*/


    }
}