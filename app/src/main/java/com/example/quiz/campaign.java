package com.example.quiz;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

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

        ProgressBar progressBarGeography = binding.progressBarGeography;
        TextView progressTextGeography = binding.counter1;
        int counter1 = 0;
        for (int i = 1; i <= 20; i++){
            if (viewModel.getCompleted(1, i)){
                counter1++;
            }
        }
        Log.v("counter", String.valueOf(counter1));
        int finalCounter1 = counter1;
        progressBarGeography.post(new Runnable() {
            @Override
            public void run() {
                progressBarGeography.setMax(20);
                progressBarGeography.setProgress(finalCounter1);
            }
        });
        progressTextGeography.setText(counter1 + "/20");

        ProgressBar progressBarLogo = binding.progressBarLogo;
        TextView progressTextLogo = binding.counter2;
        int counter2 = 0;
        for (int i = 1; i <= 20; i++){
            if (viewModel.getCompleted(2, i)){
                counter2++;
            }
        }
        Log.v("counter", String.valueOf(counter2));
        int finalCounter2 = counter2;
        progressBarLogo.post(new Runnable() {
            @Override
            public void run() {
                progressBarLogo.setMax(20);
                progressBarLogo.setProgress(finalCounter2);
            }
        });
        progressTextLogo.setText(counter2 + "/20");

        ProgressBar progressBarHistory = binding.progressBarHistory;
        TextView progressTextHistory = binding.counter3;
        int counter3 = 0;
        for (int i = 1; i <= 20; i++){
            if (viewModel.getCompleted(3, i)){
                counter3++;
            }
        }
        Log.v("counter", String.valueOf(counter3));
        int finalCounter3 = counter3;
        progressBarHistory.post(new Runnable() {
            @Override
            public void run() {
                progressBarHistory.setMax(20);
                progressBarHistory.setProgress(finalCounter3);
            }
        });
        progressTextHistory.setText(counter3 + "/20");

        ProgressBar progressBarSports = binding.progressBarSports;
        TextView progressTextSports = binding.counter4;
        int counter4 = 0;
        for (int i = 1; i <= 20; i++){
            if (viewModel.getCompleted(4, i)){
                counter4++;
            }
        }
        Log.v("counter", String.valueOf(counter4));
        int finalCounter4 = counter4;
        progressBarSports.post(new Runnable() {
            @Override
            public void run() {
                progressBarSports.setMax(20);
                progressBarSports.setProgress(finalCounter4);
            }
        });
        progressTextSports.setText(counter4 + "/20");

        ProgressBar progressBarMovies = binding.progressBarMovies;
        TextView progressTextMovies = binding.counter5;
        int counter5 = 0;
        for (int i = 1; i <= 20; i++){
            if (viewModel.getCompleted(5, i)){
                counter5++;
            }
        }
        Log.v("counter", String.valueOf(counter5));
        int finalCounter5 = counter5;
        progressBarMovies.post(new Runnable() {
            @Override
            public void run() {
                progressBarMovies.setMax(20);
                progressBarMovies.setProgress(finalCounter5);
            }
        });
        progressTextMovies.setText(counter5 + "/20");

        ProgressBar progressBarGames = binding.progressBarGames;
        TextView progressTextGames = binding.counter6;
        int counter6 = 0;
        for (int i = 1; i <= 20; i++){
            if (viewModel.getCompleted(6, i)){
                counter6++;
            }
        }
        Log.v("counter", String.valueOf(counter6));
        int finalCounter6 = counter6;
        progressBarGames.post(new Runnable() {
            @Override
            public void run() {
                progressBarGames.setMax(20);
                progressBarGames.setProgress(finalCounter6);
            }
        });
        progressTextGames.setText(counter6 + "/20");

        ProgressBar progressBarFood = binding.progressBarFood;
        TextView progressTextFood = binding.counter7;
        int counter7 = 0;
        for (int i = 1; i <= 20; i++){
            if (viewModel.getCompleted(7, i)){
                counter7++;
            }
        }
        Log.v("counter", String.valueOf(counter7));
        int finalCounter7 = counter7;
        progressBarFood.post(new Runnable() {
            @Override
            public void run() {
                progressBarFood.setMax(20);
                progressBarFood.setProgress(finalCounter7);
            }
        });
        progressTextFood.setText(counter7 + "/20");



        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binding.geography.setOnClickListener(v -> {
            viewModel.setCategoryId(1);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.logo.setOnClickListener(v -> {
            viewModel.setCategoryId(2);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.history.setOnClickListener(v -> {
            viewModel.setCategoryId(3);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.sports.setOnClickListener(v -> {
            viewModel.setCategoryId(4);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.movies.setOnClickListener(v -> {
            viewModel.setCategoryId(5);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.games.setOnClickListener(v -> {
            viewModel.setCategoryId(6);
            Navigation.findNavController(view).navigate(R.id.action_campaign_to_set_level);
        });

        binding.food.setOnClickListener(v -> {
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