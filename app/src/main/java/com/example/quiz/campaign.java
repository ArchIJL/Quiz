package com.example.quiz;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.quiz.databinding.FragmentCampaignBinding;
import com.example.quiz.model.MyViewModel;


public class campaign extends Fragment {

    public final String TAG = "campaign";

    private FragmentCampaignBinding binding = null;

    private MyViewModel viewModel;


    public static campaign newInstance() {
        campaign fragment = new campaign();
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
        binding = FragmentCampaignBinding.inflate(inflater, container, false);
        Toolbar toolbar = binding.toolbar1;
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view1 -> requireActivity().onBackPressed());
        toolbar.setTitle("Кампания");

        FragmentManager fragmentManager = getParentFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        Log.d(TAG, "Number of fragments on back stack: " + backStackEntryCount);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binding.buttonLevelGeography.setOnClickListener(v -> {
            viewModel.setCategoryId(1);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.buttonLevelLogo.setOnClickListener(v -> {
            viewModel.setCategoryId(2);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.buttonLevelHistory.setOnClickListener(v -> {
            viewModel.setCategoryId(3);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.buttonLevelSports.setOnClickListener(v -> {
            viewModel.setCategoryId(4);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.buttonLevelMovies.setOnClickListener(v -> {
            viewModel.setCategoryId(5);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.buttonLevelGames.setOnClickListener(v -> {
            viewModel.setCategoryId(6);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.buttonLevelFood.setOnClickListener(v -> {
            viewModel.setCategoryId(7);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });







        /*binding.buttonLevelGeography.setOnClickListener(view2 -> Navigation.findNavController(view2)
                .navigate(R.id.action_campaign_to_geography_level));
        binding.buttonLevelLogo.setOnClickListener(view3 -> Navigation.findNavController(view3)
                .navigate(R.id.action_campaign_to_logo_level));
        binding.buttonLevelHistory.setOnClickListener(view4 -> Navigation.findNavController(view4)
                .navigate(R.id.action_campaign_to_history_level));
        binding.buttonLevelSports.setOnClickListener(view5 -> Navigation.findNavController(view5)
                .navigate(R.id.action_campaign_to_sports_level));
        binding.buttonLevelMovies.setOnClickListener(view6 -> Navigation.findNavController(view6)
                .navigate(R.id.action_campaign_to_movies_level));
        binding.buttonLevelGames.setOnClickListener(view7 -> Navigation.findNavController(view7)
                .navigate(R.id.action_campaign_to_games_level));
        binding.buttonLevelFood.setOnClickListener(view8 -> Navigation.findNavController(view8)
                .navigate(R.id.action_campaign_to_food_level));*/
    }
}