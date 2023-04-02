package com.example.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.quiz.databinding.FragmentResultsDialogTimeBinding;


public class ResultsDialogTimeFragment extends DialogFragment {

    private FragmentResultsDialogTimeBinding binding = null;

    private TextView mNumCorrectAnswersTextView;
    private Button mStartAgainButton;
    private Button mMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentResultsDialogTimeBinding.inflate(inflater, container, false);

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
                Navigation.findNavController(requireActivity(), R.id.fragmentContainerView).navigate(R.id.time);
            }
        });

        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                requireActivity().onBackPressed();
            }
        });

        return binding.getRoot();
    }
}