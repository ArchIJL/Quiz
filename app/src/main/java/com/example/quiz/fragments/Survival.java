package com.example.quiz.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quiz.questions.Question;
import com.example.quiz.R;
import com.example.quiz.databinding.FragmentSurvivalBinding;
import com.example.quiz.dialogfragments.ResultsDialogSurvivalFragment;
import com.example.quiz.model.QuestionsTaSViewModel;
import com.example.quiz.model.SettingsViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Survival extends Fragment {

    public final String TAG = "survival";

    private FragmentSurvivalBinding binding = null;

    private TextView mQuestionTextView;
    private Button mOption1Button;
    private Button mOption2Button;
    private Button mOption3Button;
    private Button mOption4Button;

    private int mCurrentQuestionIndex;
    private int mNumCorrectAnswers;
    private int mNumAnswers;
    private List<Question> mQuestions;
    private int mLives = 3;

    private SettingsViewModel settingsViewModel;
    private QuestionsTaSViewModel questionsTaSViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settingsViewModel = new ViewModelProvider(requireActivity()).get(SettingsViewModel.class);
        questionsTaSViewModel = new ViewModelProvider(requireActivity()).get(QuestionsTaSViewModel.class);

        // Создание списка вопросов
        mQuestions = new ArrayList<>();
        questionsTaSViewModel.loadQuestionsFromPrefs(getContext());
        mQuestions = questionsTaSViewModel.getQuestions();


        Log.d("firebaseSurvival", String.valueOf(mQuestions));

        // Перемешать вопросы в случайном порядке
        Collections.shuffle(mQuestions);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSurvivalBinding.inflate(inflater, container, false);
        Toolbar toolbar = binding.toolbar;
        toolbar.setTitle("Выживание");
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view1 -> requireActivity().onBackPressed());


        mQuestionTextView = binding.questionTextView;
        mOption1Button = binding.answerButton1;
        mOption2Button = binding.answerButton2;
        mOption3Button = binding.answerButton3;
        mOption4Button = binding.answerButton4;

        mOption1Button.setOnClickListener(v -> checkAnswer(mOption1Button));
        mOption2Button.setOnClickListener(v -> checkAnswer(mOption2Button));
        mOption3Button.setOnClickListener(v -> checkAnswer(mOption3Button));
        mOption4Button.setOnClickListener(v -> checkAnswer(mOption4Button));

        setQuestion(mQuestions.get(0));

        return binding.getRoot();
    }

    private void setQuestion(Question question) {
        mQuestionTextView.setText(question.getText());
        Collections.shuffle(question.getOptions());
        mOption1Button.setText(question.getOptions().get(0));
        mOption2Button.setText(question.getOptions().get(1));
        mOption3Button.setText(question.getOptions().get(2));
        mOption4Button.setText(question.getOptions().get(3));
    }

    private void checkAnswer(Button selectedButton) {
        Question currentQuestion = mQuestions.get(mCurrentQuestionIndex);
        mNumAnswers++;
        if (selectedButton.getText().toString().equals(currentQuestion.getCorrectOption())) {
            // Если ответ правильный, установить цвет фона кнопки на зелёный
            selectedButton.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_correct));
            mNumCorrectAnswers++;
        } else {
            // Если ответ неверный, установить цвет фона кнопки на красный
            selectedButton.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_incorrect));
            mLives--;
            Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            VibrationEffect vibrationEffect = settingsViewModel.getVibrationEffect();
            if (mLives == 0){
                int numCorrectAnswers = settingsViewModel.getHighestScoreSurvival().getValue();
                if (mNumCorrectAnswers > numCorrectAnswers){
                    settingsViewModel.setHighestScoreSurvival(mNumCorrectAnswers);
                }
                binding.heart1.setVisibility(View.GONE);
                if (vibrationEffect != null && vibrator != null) {
                    vibrator.vibrate(vibrationEffect);
                }
                DialogFragment resultsDialog = new ResultsDialogSurvivalFragment();
                Bundle args = new Bundle();
                args.putInt("numCorrectAnswers", mNumCorrectAnswers);
                args.putInt("numAnswers", mNumAnswers);
                resultsDialog.setArguments(args);
                resultsDialog.show(getParentFragmentManager(), "ResultsDialogSurvivalFragment");
            } else if (mLives == 2){
                if (vibrationEffect != null && vibrator != null) {
                    vibrator.vibrate(vibrationEffect);
                }
                binding.heart3.setVisibility(View.GONE);
            } else if (mLives == 1){
                if (vibrationEffect != null && vibrator != null) {
                    vibrator.vibrate(vibrationEffect);
                }
                binding.heart2.setVisibility(View.GONE);
            }
        }

        mOption1Button.setEnabled(false);
        mOption2Button.setEnabled(false);
        mOption3Button.setEnabled(false);
        mOption4Button.setEnabled(false);

        // Время для того, чтобы пользователь увидел изменение кнопки
        new Handler().postDelayed(() -> {
            // Перейти к следующему вопросу или завершить тест
            mCurrentQuestionIndex++;
            if (mCurrentQuestionIndex < mQuestions.size()) {
                setQuestion(mQuestions.get(mCurrentQuestionIndex));
            } else {
                int numCorrectAnswers = settingsViewModel.getHighestScoreSurvival().getValue();
                if (mNumCorrectAnswers > numCorrectAnswers){
                    settingsViewModel.setHighestScoreSurvival(mNumCorrectAnswers);
                }
                // Показать диалог результатов
                DialogFragment resultsDialog = new ResultsDialogSurvivalFragment();
                Bundle args = new Bundle();
                args.putInt("numCorrectAnswers", mNumCorrectAnswers);
                args.putInt("numAnswers", mNumAnswers);
                resultsDialog.setArguments(args);
                resultsDialog.show(getParentFragmentManager(), "ResultsDialogSurvivalFragment");
            }

            // Сбросить цвет фона кнопок ответа и включить их
            mOption1Button.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.answer_button_background));
            mOption2Button.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.answer_button_background));
            mOption3Button.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.answer_button_background));
            mOption4Button.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.answer_button_background));
            mOption1Button.setEnabled(true);
            mOption2Button.setEnabled(true);
            mOption3Button.setEnabled(true);
            mOption4Button.setEnabled(true);
        }, 1000); // Подождать 1 секунду, прежде чем перейти к следующему вопросу
    }
}