package com.example.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.quiz.databinding.FragmentResultsDialogSurvivalBinding;


public class ResultsDialogSurvivalFragment extends DialogFragment {

    private FragmentResultsDialogSurvivalBinding binding = null;

    private TextView mNumCorrectAnswersTextView;
    private Button mStartAgainButton;
    private Button mMenu;

    public static ResultsDialogSurvivalFragment newInstance(String param1, String param2) {
        ResultsDialogSurvivalFragment fragment = new ResultsDialogSurvivalFragment();
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
        binding = FragmentResultsDialogSurvivalBinding.inflate(inflater, container, false);

        mNumCorrectAnswersTextView = binding.numCorrectAnswersTextView;
        mStartAgainButton = binding.startAgainButton;
        mMenu = binding.menu;

        Bundle args = getArguments();
        int numCorrectAnswers = args.getInt("numCorrectAnswers");
        int numAnswers = args.getInt("numAnswers");
        mNumCorrectAnswersTextView.setText(getString(R.string.num_correct_answers, numCorrectAnswers, numAnswers));

        mStartAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                NavController navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);
                navController.popBackStack();
                Navigation.findNavController(requireActivity(), R.id.fragmentContainerView).navigate(R.id.survival);
            }
        });

        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
                dismiss();
            }
        });

        return binding.getRoot();
    }


}