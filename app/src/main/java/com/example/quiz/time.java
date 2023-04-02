package com.example.quiz;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
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
import com.example.quiz.model.SettingsViewModel;

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
    private int mNumAnswers;

    private CountDownTimer mCountDownTimer;
    private static final long COUNTDOWN_INTERVAL = 1000; // 1 секунда
    private static final long COUNTDOWN_TIME = 5 * 60 * 1000; // 5 минут

    private SettingsViewModel settingsViewModel;


    public static time newInstance() {
        time fragment = new time();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settingsViewModel = new ViewModelProvider(requireActivity()).get(SettingsViewModel.class);

        // Создание списка вопросов
        mQuestions = QuestionBank.getQuestions();

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
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    public static class QuestionBank {

        public static List<Question> getQuestions() {
            List<Question> mQuestions = new ArrayList<>();
            mQuestions.add(new Question("Название столицы Франции?", "Париж", "Мадрид", "Берлин", "Рим"));
            mQuestions.add(new Question("Какая самая большая планета солнечной системы?", "Юпитер", "Сатурн", "Нептун", "Уран"));
            mQuestions.add(new Question("Как называется самый большой океан на Земле?", "Тихий", "Индийский", "Атлантический", "Арктический"));
            mQuestions.add(new Question("Кто является основателем корпорации Microsoft?", "Билл Гейтс", "Стив Джобс", "Марк Цукерберг", "Илон Маск"));
            mQuestions.add(new Question("Какая страна выиграла чемпионат мира по футболу в 2018 году?", "Франция", "Бразилия", "Германия", "Испания"));
            mQuestions.add(new Question("Как называется самая высокая гора в мире?", "гора Эверест", "Гора Килиманджаро", "Гора МакКинли", "Гора Аконкагуа"));
            mQuestions.add(new Question("Какой ученый разработал теорию относительности?", "Альберт Эйнштейн", "Галилео Галилей", "Чарльз Дарвин", "Исаак Ньютон"));
            mQuestions.add(new Question("Какой химический символ у золота?", "Au", "Ge", "Gd", "Ag"));
            mQuestions.add(new Question("В каком году первый человек ступил на Луну?", "1969 г.", "1972 г.", "1968 г.", "1965 г."));
            mQuestions.add(new Question("Какая столица Бразилии?", "Бразилиа", "Рио де Жанейро", "Сан-Паулу", "Буэнос айрес"));
            mQuestions.add(new Question("Кто сыграл Гарри Поттера в сериале?", "Дэниел Рэдклифф", "Руперт Гринт", "Том Фелтон", "Эмма Ватсон"));
            mQuestions.add(new Question("Какая самая маленькая единица жизни?", "Клетка", "Атом", "Молекула", "Орган"));
            mQuestions.add(new Question("Какая река самая длинная в мире?", "Река Нил", "Река Амазонка", "Река Янцзы", "Река Миссисипи"));
            mQuestions.add(new Question("Как называется самая высокая гора в Африке?", "Гора Килиманджаро", "Гора Эверест", "Гора МакКинли", "Гора Аконкагуа"));
            mQuestions.add(new Question("Как называется самая большая пустыня в мире?", "Сахара", "Гоби", "Калахари", "Антарктическая"));
            mQuestions.add(new Question("Какое животное самое большое в мире?", "Кит", "Слон", "Бегемот", "Носорог"));
            mQuestions.add(new Question("Какой химический символ у воды?", "Н2О", "СО2", "NaCl", "О2"));
            mQuestions.add(new Question("Какая страна является крупнейшим производителем кофе в мире?", "Бразилия", "Колумбия", "Эфиопия", "Вьетнам"));
            mQuestions.add(new Question("Как зовут известного футболиста, выступавшего за «Барселону» и Аргентину?", "Лионель Месси", "Криштиану Роналду", "Килиан Мбаппе", "Неймар"));
            mQuestions.add(new Question("Какая планета известна как «Красная планета»?", "Марс", "Юпитер", "Венера", "Сатурн"));
            mQuestions.add(new Question("Кто написал знаменитую картину «Звездная ночь»?", "Винсент Ван Гог", "Леонардо да Винчи", "Пабло Пикассо", "Клод Моне"));
            mQuestions.add(new Question(" Кто был первым человеком, ступившим на Луну?", "Нил Армстронг", "Базз Олдрин", "Майкл Коллинз", "Юрий Гагарин"));
            mQuestions.add(new Question("Как зовут известного английского драматурга, написавшего «Ромео и Джульетту»?", "Вильям Шекспир", "Оскар Уайлд", "Джордж Бернард Шоу", "Сэмюэл Беккет"));
            mQuestions.add(new Question("Какая страна самая большая по площади?", "Россия", "Канада", "Китай", "Соединенные Штаты"));
            mQuestions.add(new Question("Как зовут известного итальянского астронома, открывшего четыре спутника Юпитера?", "Галилео Галилей", "Исаак Ньютон", "Иоганн Кеплер", "Николай Коперник"));
            return mQuestions;
        }
    }
}