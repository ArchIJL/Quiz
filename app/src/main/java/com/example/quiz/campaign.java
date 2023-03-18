package com.example.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.quiz.databinding.FragmentCampaignBinding;


public class campaign extends Fragment {

    private FragmentCampaignBinding binding = null;

    public campaign() {
        // Required empty public constructor
    }


    public static campaign newInstance() {
        campaign fragment = new campaign();
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
        binding = FragmentCampaignBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Navigation.findNavController(view1)
                        .navigate(R.id.action_campaign_to_main_fragment);
            }
        });
        binding.buttonLevelGeography.setOnClickListener(view2 -> Navigation.findNavController(view2)
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
                .navigate(R.id.action_campaign_to_food_level));
        }
}