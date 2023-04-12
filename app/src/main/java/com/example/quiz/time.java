package com.example.quiz;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
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

import com.example.quiz.databinding.FragmentTimeBinding;
import com.example.quiz.dialogfragments.ResultsDialogTimeFragment;
import com.example.quiz.model.QuestionsTaSViewModel;
import com.example.quiz.model.SettingsViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class time extends Fragment {

    private FragmentTimeBinding binding = null;

    private TextView mQuestionTextView;
    private Button mOption1Button;
    private Button mOption2Button;
    private Button mOption3Button;
    private Button mOption4Button;
    private TextView mTimerTextView;

    private List<MainActivity.Question> mQuestions;
    private int mCurrentQuestionIndex;
    private int mNumCorrectAnswers;
    private int mNumAnswers;

    private CountDownTimer mCountDownTimer;
    private static final long COUNTDOWN_INTERVAL = 1000; // 1 секунда
    private static final long COUNTDOWN_TIME = 5 * 60 * 1000; // 5 минут

    private SettingsViewModel settingsViewModel;
    private QuestionsTaSViewModel questionsTaSViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settingsViewModel = new ViewModelProvider(requireActivity()).get(SettingsViewModel.class);
        questionsTaSViewModel = new ViewModelProvider(requireActivity()).get(QuestionsTaSViewModel.class);

        // Создание списка вопросов
        mQuestions = new ArrayList<>();
        mQuestions = questionsTaSViewModel.getQuestions();

        Log.d("firebaseTime", String.valueOf(mQuestions));

        // Перемешать вопросы в случайном порядке
        Collections.shuffle(mQuestions);

        // Запуск таймера
        mCountDownTimer = new CountDownTimer(COUNTDOWN_TIME, COUNTDOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsUntilFinished = millisUntilFinished / 1000;
                mTimerTextView.setText(String.format("%02d:%02d", secondsUntilFinished / 60, secondsUntilFinished % 60));
            }

            @Override
            public void onFinish() {
                int numCorrectAnswers = settingsViewModel.getHighestScoreTime().getValue();
                if (mNumCorrectAnswers > numCorrectAnswers) {

                    settingsViewModel.setHighestScoreTime(mNumCorrectAnswers);

                }
                // Показать диалоговое окно результатов
                DialogFragment resultsDialog = new ResultsDialogTimeFragment();
                Bundle args = new Bundle();
                args.putInt("numCorrectAnswers", mNumCorrectAnswers);
                resultsDialog.setArguments(args);
                resultsDialog.show(getParentFragmentManager(), "ResultsDialogTimeFragment");
            }
        }.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTimeBinding.inflate(inflater, container, false);
        Toolbar toolbar = binding.toolbar;
        toolbar.setTitle("На время");
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                requireActivity().onBackPressed();
            }
        });

        mTimerTextView = binding.timerTextView;
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

    private void setQuestion(MainActivity.Question question) {
        mQuestionTextView.setText(question.getText());
        Collections.shuffle(question.getOptions());
        mOption1Button.setText(question.getOptions().get(0));
        mOption2Button.setText(question.getOptions().get(1));
        mOption3Button.setText(question.getOptions().get(2));
        mOption4Button.setText(question.getOptions().get(3));
    }

    private void checkAnswer(Button selectedButton) {
        MainActivity.Question currentQuestion = mQuestions.get(mCurrentQuestionIndex);
        mNumAnswers++;
        if (selectedButton.getText().toString().equals(currentQuestion.getCorrectOption())) {
            // Если ответ правильный, установить цвет фона кнопки на зелёный
            selectedButton.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_correct));
            mNumCorrectAnswers++;
        } else {
            Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            VibrationEffect vibrationEffect = settingsViewModel.getVibrationEffect();
            if (vibrationEffect != null && vibrator != null) {
                vibrator.vibrate(vibrationEffect);
            }
            // Если ответ неверный, установить цвет фона кнопки на красный
            selectedButton.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_incorrect));
        }

        mOption1Button.setEnabled(false);
        mOption2Button.setEnabled(false);
        mOption3Button.setEnabled(false);
        mOption4Button.setEnabled(false);

        // Время для того, чтобы пользователь увидел изменение кнопки
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Перейти к следующему вопросу или завершить тест
                mCurrentQuestionIndex++;
                if (mCurrentQuestionIndex < mQuestions.size()) {
                    setQuestion(mQuestions.get(mCurrentQuestionIndex));
                } else {
                    mCountDownTimer.cancel();
                    int numCorrectAnswers = settingsViewModel.getHighestScoreTime().getValue();
                    if (mNumCorrectAnswers > numCorrectAnswers) {
                        settingsViewModel.setHighestScoreTime(mNumCorrectAnswers);
                    }
                    // Показать диалог результатов
                    DialogFragment resultsDialog = new ResultsDialogTimeFragment();
                    Bundle args = new Bundle();
                    args.putInt("numCorrectAnswers", mNumCorrectAnswers);
                    args.putInt("numAnswers", mNumAnswers);
                    resultsDialog.setArguments(args);
                    resultsDialog.show(getParentFragmentManager(), "ResultsDialogTimeFragment");
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
            }
        }, 1000); // Подождать 1 секунду, прежде чем перейти к следующему вопросу
    }
}