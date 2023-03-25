package com.example.quiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.quiz.databinding.FragmentTimeBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class time extends Fragment{

    private FragmentTimeBinding binding = null;

    private TextView mQuestionTextView;
    private Button mOption1Button;
    private Button mOption2Button;
    private Button mOption3Button;
    private Button mOption4Button;
    private TextView mTimerTextView;

    private List<Question> mQuestions;
    private int mCurrentQuestionIndex;
    private int mNumCorrectAnswers;

    private CountDownTimer mCountDownTimer;
    private static final long COUNTDOWN_INTERVAL = 1000; // 1 секунда
    private static final long COUNTDOWN_TIME = 5 * 60 * 1000; // 5 минут


    public static time newInstance() {
        time fragment = new time();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Создание списка вопросов
        mQuestions = new ArrayList<>();
        mQuestions.add(new Question("Название столицы Франции?", "Париж", "Мадрид", "Берлин", "Рим"));
        mQuestions.add(new Question("Какая самая большая планета солнечной системы?", "Юпитер", "Сатурн", "Нептун", "Уран"));
        // Добавить новые вопросы...

        // Перемешать вопросы в случайном порядке
        Random random = new Random();
        for (int i = 0; i < mQuestions.size(); i++) {
            int j = random.nextInt(mQuestions.size());
            Question temp = mQuestions.get(i);
            mQuestions.set(i, mQuestions.get(j));
            mQuestions.set(j, temp);
        }

        // Запуск таймера
        mCountDownTimer = new CountDownTimer(COUNTDOWN_TIME, COUNTDOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsUntilFinished = millisUntilFinished / 1000;
                mTimerTextView.setText(String.format("%02d:%02d", secondsUntilFinished / 60, secondsUntilFinished % 60));
            }

            @Override
            public void onFinish() {
                // Показать диалоговое окно результатов
                DialogFragment resultsDialog = new ResultsDialogFragment();
                Bundle args = new Bundle();
                args.putInt("numCorrectAnswers", mNumCorrectAnswers);
                resultsDialog.setArguments(args);
                resultsDialog.show(getParentFragmentManager(), "ResultsDialogFragment");
            }
        }.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTimeBinding.inflate(inflater, container, false);

        mTimerTextView = binding.timerTextView;
        mQuestionTextView = binding.questionTextView;
        mOption1Button = binding.answerButton1;
        mOption2Button = binding.answerButton2;
        mOption3Button = binding.answerButton3;
        mOption4Button = binding.answerButton4;


        mCurrentQuestionIndex = 0;
        setQuestion(mQuestions.get(mCurrentQuestionIndex));

        mOption1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(mOption1Button);
            }
        });
        mOption2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(mOption2Button);
            }
        });
        mOption3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(mOption3Button);
            }
        });
        mOption4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(mOption4Button);
            }
        });

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
        if (selectedButton.getText().toString().equals(currentQuestion.getCorrectOption())) {
            // Если ответ правильный, установить цвет фона кнопки на зелёный
            selectedButton.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_correct));
            mNumCorrectAnswers++;
        } else {
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
                    // Показать диалог результатов
                    DialogFragment resultsDialog = new ResultsDialogFragment();
                    Bundle args = new Bundle();
                    args.putInt("numCorrectAnswers", mNumCorrectAnswers);
                    resultsDialog.setArguments(args);
                    resultsDialog.show(getParentFragmentManager(), "ResultsDialogFragment");
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

    private static class Question {

        private String mText;
        private List<String> mOptions;
        private String mCorrectOption;

        public Question(String text, String option1, String option2, String option3, String option4) {
            mText = text;
            mOptions = new ArrayList<>();
            mOptions.add(option1);
            mOptions.add(option2);
            mOptions.add(option3);
            mOptions.add(option4);
            mCorrectOption = option1;
        }

        public String getText() {
            return mText;
        }

        public List<String> getOptions() {
            return mOptions;
        }

        public String getCorrectOption() {
            return mCorrectOption;
        }
    }

}