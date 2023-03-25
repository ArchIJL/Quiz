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


public class ResultsDialogFragment extends DialogFragment {

    private TextView mNumCorrectAnswersTextView;
    private Button mStartAgainButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results_dialog, container, false);

        mNumCorrectAnswersTextView = view.findViewById(R.id.num_correct_answers_text_view);
        mStartAgainButton = view.findViewById(R.id.start_again_button);

        Bundle args = getArguments();
        int numCorrectAnswers = args.getInt("numCorrectAnswers");
        mNumCorrectAnswersTextView.setText(getString(R.string.num_correct_answers, numCorrectAnswers));

        mStartAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                time quizFragment = new time();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, quizFragment)
                        .commit();
            }
        });

        return view;
    }
}