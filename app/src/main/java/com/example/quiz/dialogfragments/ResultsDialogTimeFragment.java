package com.example.quiz.dialogfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.example.quiz.R;
import com.example.quiz.databinding.FragmentResultsDialogTimeBinding;
import com.example.quiz.model.SettingsViewModel;


public class ResultsDialogTimeFragment extends DialogFragment {

    private FragmentResultsDialogTimeBinding binding = null;

    private TextView mNumCorrectAnswersTextView;
    private TextView mScoreText;
    private Button mStartAgainButton;
    private Button mMenu;

    private SettingsViewModel settingsViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingsViewModel = new ViewModelProvider(requireActivity()).get(SettingsViewModel.class);
        setCancelable(false);
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentResultsDialogTimeBinding.inflate(inflater, container, false);

        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.custom_dialog);
        }

        mNumCorrectAnswersTextView = binding.numCorrectAnswersTextView;
        mScoreText = binding.timeTextScore;
        mStartAgainButton = binding.startAgainButton;
        mMenu = binding.menu;

        Bundle args = getArguments();
        int numCorrectAnswers = args.getInt("numCorrectAnswers");
        int score = settingsViewModel.getHighestScoreTime().getValue();
        mNumCorrectAnswersTextView.setText(getString(R.string.num_correct_answers_time, numCorrectAnswers));
        mScoreText.setText(getString(R.string.num_score, score));

        mStartAgainButton.setOnClickListener(v -> {
            dismiss();
            NavController navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);
            navController.popBackStack();
            NavOptions navOptions = new NavOptions.Builder()
                    .setEnterAnim(R.anim.slide_in_left)
                    .setExitAnim(R.anim.slide_out_right)
                    .setPopEnterAnim(R.anim.slide_in_left)
                    .setPopExitAnim(R.anim.slide_out_right)
                    .build();
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView).navigate(R.id.time, null, navOptions);
        });

        mMenu.setOnClickListener(v -> {
            dismiss();
            requireActivity().onBackPressed();
        });

        return binding.getRoot();
    }
}