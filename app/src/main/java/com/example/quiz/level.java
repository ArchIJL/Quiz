package com.example.quiz;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.quiz.databinding.FragmentLevelsBinding;
import com.example.quiz.model.MyViewModel;

import java.util.ArrayList;


public class level extends Fragment implements View.OnClickListener {

    public final String TAG = "level";

    private MyViewModel viewModel;

    private TextView questionTextView;
    private EditText answerEditText;
    private ArrayList<Button> answerButtons;
    private ArrayList<String> originalButtonText;
    private String currentAnswer;
    private int questionNumber;

    private FragmentLevelsBinding binding = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLevelsBinding.inflate(inflater, container, false);
        Toolbar toolbar = binding.toolbar;
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                requireActivity().onBackPressed();
            }
        });

        FragmentManager fragmentManager = getParentFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        Log.d(TAG, "Number of fragments on back stack: " + backStackEntryCount);


        Toolbar toolbar2 = binding.toolbar2;

        questionTextView = binding.textQuestions;
        answerEditText = binding.editText;


        int categoryId = viewModel.getCategoryId();
        int levelId = viewModel.getLevelId();
        Log.v(TAG, String.valueOf(levelId));

        answerButtons = new ArrayList<>();
        answerButtons.add(binding.button1);
        answerButtons.add(binding.button2);
        answerButtons.add(binding.button3);
        answerButtons.add(binding.button4);
        answerButtons.add(binding.button5);
        answerButtons.add(binding.button6);
        answerButtons.add(binding.button7);
        answerButtons.add(binding.button8);
        answerButtons.add(binding.button9);
        answerButtons.add(binding.button10);
        answerButtons.add(binding.button11);
        answerButtons.add(binding.button12);

        switch (categoryId){
            case 1:
                switch (levelId){
                    case 1:
                        toolbar.setTitle("Уровень 1");
                        questionNumber = 1;
                        questionTextView.setText("Какая страна имеет самое большое население в мире?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("А");
                        binding.button2.setText("Ш");
                        binding.button3.setText("К");
                        binding.button4.setText("Е");
                        binding.button5.setText("М");
                        binding.button6.setText("Т");
                        binding.button7.setText("О");
                        binding.button8.setText("Р");
                        binding.button9.setText("И");
                        binding.button10.setText("С");
                        binding.button11.setText("Й");
                        binding.button12.setText("Ч");
                        binding.toolbarLeftArrow.setVisibility(View.GONE);
                        break;
                    case 2:
                        toolbar.setTitle("Уровень 2");
                        questionNumber = 2;
                        questionTextView.setText("Название самой большой пустыни в мире?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Х");
                        binding.button2.setText("А");
                        binding.button3.setText("Э");
                        binding.button4.setText("Ч");
                        binding.button5.setText("А");
                        binding.button6.setText("Ш");
                        binding.button7.setText("С");
                        binding.button8.setText("Д");
                        binding.button9.setText("У");
                        binding.button10.setText("А");
                        binding.button11.setText("М");
                        binding.button12.setText("Р");
                        break;
                    case 3:
                        toolbar.setTitle("Уровень 3");
                        questionNumber = 3;
                        questionTextView.setText("Какая страна самая большая в мире?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Р");
                        binding.button2.setText("В");
                        binding.button3.setText("И");
                        binding.button4.setText("О");
                        binding.button5.setText("Э");
                        binding.button6.setText("Й");
                        binding.button7.setText("Я");
                        binding.button8.setText("А");
                        binding.button9.setText("К");
                        binding.button10.setText("С");
                        binding.button11.setText("И");
                        binding.button12.setText("С");
                        break;
                    case 4:
                        toolbar.setTitle("Уровень 4");
                        questionNumber = 4;
                        questionTextView.setText("Какая страна является родиной Олимпийских игр?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Г");
                        binding.button2.setText("Ц");
                        binding.button3.setText("Т");
                        binding.button4.setText("У");
                        binding.button5.setText("Я");
                        binding.button6.setText("К");
                        binding.button7.setText("Й");
                        binding.button8.setText("Р");
                        binding.button9.setText("Ч");
                        binding.button10.setText("Е");
                        binding.button11.setText("И");
                        binding.button12.setText("О");
                        break;
                    case 5:
                        toolbar.setTitle("Уровень 5");
                        questionNumber = 5;
                        questionTextView.setText("Как называется китайская валюта?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Д");
                        binding.button2.setText("А");
                        binding.button3.setText("У");
                        binding.button4.setText("П");
                        binding.button5.setText("Ь");
                        binding.button6.setText("Н");
                        binding.button7.setText("Б");
                        binding.button8.setText("Ц");
                        binding.button9.setText("Ю");
                        binding.button10.setText("Х");
                        binding.button11.setText("Ж");
                        binding.button12.setText("Г");
                        break;
                    case 6:
                        toolbar.setTitle("Уровень 6");
                        questionNumber = 6;
                        questionTextView.setText("Столицей какой страны является Токио?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Я");
                        binding.button2.setText("О");
                        binding.button3.setText("Л");
                        binding.button4.setText("Й");
                        binding.button5.setText("П");
                        binding.button6.setText("Б");
                        binding.button7.setText("И");
                        binding.button8.setText("Н");
                        binding.button9.setText("Ш");
                        binding.button10.setText("Е");
                        binding.button11.setText("Я");
                        binding.button12.setText("Ч");
                        break;
                    case 7:
                        toolbar.setTitle("Уровень 7");
                        questionNumber = 7;
                        questionTextView.setText("Назовите страну в Западной Европе, которая не имеет столицы");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Ё");
                        binding.button2.setText("В");
                        binding.button3.setText("Я");
                        binding.button4.setText("А");
                        binding.button5.setText("Е");
                        binding.button6.setText("Ш");
                        binding.button7.setText("И");
                        binding.button8.setText("Ф");
                        binding.button9.setText("Й");
                        binding.button10.setText("Ц");
                        binding.button11.setText("Р");
                        binding.button12.setText("Т");
                        break;
                    case 8:
                        toolbar.setTitle("Уровень 8");
                        questionNumber = 8;
                        questionTextView.setText("Какой материк не имеет вулканов?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Ж");
                        binding.button2.setText("И");
                        binding.button3.setText("А");
                        binding.button4.setText("А");
                        binding.button5.setText("Щ");
                        binding.button6.setText("В");
                        binding.button7.setText("Р");
                        binding.button8.setText("Л");
                        binding.button9.setText("С");
                        binding.button10.setText("Я");
                        binding.button11.setText("Т");
                        binding.button12.setText("В");
                        break;
                    case 9:
                        toolbar.setTitle("Уровень 9");
                        questionNumber = 9;
                        questionTextView.setText("Самая длинная река");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Н");
                        binding.button2.setText("З");
                        binding.button3.setText("У");
                        binding.button4.setText("Т");
                        binding.button5.setText("Д");
                        binding.button6.setText("И");
                        binding.button7.setText("Е");
                        binding.button8.setText("М");
                        binding.button9.setText("Л");
                        binding.button10.setText("Й");
                        binding.button11.setText("Ч");
                        binding.button12.setText("С");
                        break;
                    case 10:
                        toolbar.setTitle("Уровень 10");
                        questionNumber = 10;
                        questionTextView.setText("Самый большой материк Земли");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("С");
                        binding.button2.setText("В");
                        binding.button3.setText("Е");
                        binding.button4.setText("Ж");
                        binding.button5.setText("И");
                        binding.button6.setText("Р");
                        binding.button7.setText("Т");
                        binding.button8.setText("А");
                        binding.button9.setText("О");
                        binding.button10.setText("З");
                        binding.button11.setText("Ы");
                        binding.button12.setText("Я");
                        break;
                    case 11:
                        toolbar.setTitle("Уровень 11");
                        questionNumber = 11;
                        questionTextView.setText("Как называется воздушная оболочка Земли?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("М");
                        binding.button2.setText("В");
                        binding.button3.setText("А");
                        binding.button4.setText("Г");
                        binding.button5.setText("О");
                        binding.button6.setText("А");
                        binding.button7.setText("Т");
                        binding.button8.setText("У");
                        binding.button9.setText("С");
                        binding.button10.setText("Е");
                        binding.button11.setText("Ф");
                        binding.button12.setText("Р");
                        break;
                    case 12:
                        toolbar.setTitle("Уровень 12");
                        questionNumber = 12;
                        questionTextView.setText("Самый большой океан?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("И");
                        binding.button2.setText("И");
                        binding.button3.setText("С");
                        binding.button4.setText("Т");
                        binding.button5.setText("В");
                        binding.button6.setText("Ю");
                        binding.button7.setText("Х");
                        binding.button8.setText("Ж");
                        binding.button9.setText("Б");
                        binding.button10.setText("Й");
                        binding.button11.setText("А");
                        binding.button12.setText("У");
                        break;
                    case 13:
                        toolbar.setTitle("Уровень 13");
                        questionNumber = 13;
                        questionTextView.setText("Прибор для определения сторон горизонта?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Х");
                        binding.button2.setText("А");
                        binding.button3.setText("С");
                        binding.button4.setText("Ч");
                        binding.button5.setText("К");
                        binding.button6.setText("З");
                        binding.button7.setText("В");
                        binding.button8.setText("О");
                        binding.button9.setText("П");
                        binding.button10.setText("М");
                        binding.button11.setText("Ъ");
                        binding.button12.setText("Е");
                        break;
                    case 14:
                        toolbar.setTitle("Уровень 14");
                        questionNumber = 14;
                        questionTextView.setText("В какое море не впадает ни одной реки?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Е");
                        binding.button2.setText("Н");
                        binding.button3.setText("В");
                        binding.button4.setText("А");
                        binding.button5.setText("К");
                        binding.button6.setText("Ж");
                        binding.button7.setText("С");
                        binding.button8.setText("Р");
                        binding.button9.setText("Г");
                        binding.button10.setText("О");
                        binding.button11.setText("Т");
                        binding.button12.setText("Я");
                        break;
                    case 15:
                        toolbar.setTitle("Уровень 15");
                        questionNumber = 15;
                        questionTextView.setText("Вращающаяся модель земного шара");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Б");
                        binding.button2.setText("Ы");
                        binding.button3.setText("О");
                        binding.button4.setText("М");
                        binding.button5.setText("Я");
                        binding.button6.setText("Ж");
                        binding.button7.setText("Г");
                        binding.button8.setText("А");
                        binding.button9.setText("Ц");
                        binding.button10.setText("У");
                        binding.button11.setText("С");
                        binding.button12.setText("Л");
                        break;
                    case 16:
                        toolbar.setTitle("Уровень 16");
                        questionNumber = 16;
                        questionTextView.setText("Заход за линию горизонта Солнца?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("М");
                        binding.button2.setText("А");
                        binding.button3.setText("Л");
                        binding.button4.setText("А");
                        binding.button5.setText("Ц");
                        binding.button6.setText("С");
                        binding.button7.setText("О");
                        binding.button8.setText("Т");
                        binding.button9.setText("К");
                        binding.button10.setText("У");
                        binding.button11.setText("Э");
                        binding.button12.setText("З");
                        break;
                    case 17:
                        toolbar.setTitle("Уровень 17");
                        questionNumber = 17;
                        questionTextView.setText("В какой стране находится самое большое водохранилище мира Вольта?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("И");
                        binding.button2.setText("Я");
                        binding.button3.setText("А");
                        binding.button4.setText("Ы");
                        binding.button5.setText("Ш");
                        binding.button6.setText("Н");
                        binding.button7.setText("Р");
                        binding.button8.setText("Т");
                        binding.button9.setText("Ж");
                        binding.button10.setText("Ц");
                        binding.button11.setText("Г");
                        binding.button12.setText("А");
                        break;
                    case 18:
                        toolbar.setTitle("Уровень 18");
                        questionNumber = 18;
                        questionTextView.setText("Какое время года в Южной Америке и в Австралии в июле?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Э");
                        binding.button2.setText("П");
                        binding.button3.setText("Я");
                        binding.button4.setText("Р");
                        binding.button5.setText("Л");
                        binding.button6.setText("И");
                        binding.button7.setText("Х");
                        binding.button8.setText("З");
                        binding.button9.setText("У");
                        binding.button10.setText("А");
                        binding.button11.setText("С");
                        binding.button12.setText("М");
                        break;
                    case 19:
                        toolbar.setTitle("Уровень 19");
                        questionNumber = 19;
                        questionTextView.setText("В какой стране находится гора Эверест?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("А");
                        binding.button2.setText("Е");
                        binding.button3.setText("Ь");
                        binding.button4.setText("К");
                        binding.button5.setText("Л");
                        binding.button6.setText("Н");
                        binding.button7.setText("Э");
                        binding.button8.setText("М");
                        binding.button9.setText("П");
                        binding.button10.setText("Ц");
                        binding.button11.setText("Й");
                        binding.button12.setText("Я");
                        break;
                    case 20:
                        toolbar.setTitle("Уровень 20");
                        questionNumber = 20;
                        questionTextView.setText("Какой город является столицей Испании?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("М");
                        binding.button2.setText("И");
                        binding.button3.setText("Р");
                        binding.button4.setText("В");
                        binding.button5.setText("А");
                        binding.button6.setText("Л");
                        binding.button7.setText("Ф");
                        binding.button8.setText("Ч");
                        binding.button9.setText("Д");
                        binding.button10.setText("Т");
                        binding.button11.setText("Щ");
                        binding.button12.setText("Д");
                        binding.toolbarRightArrow.setVisibility(View.GONE);
                        break;
                }
                break;

            case 2:
                switch (levelId){
                    case 1:
                        toolbar.setTitle("Уровень 1");
                        questionNumber = 21;
                        questionTextView.setText("Ага");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("А");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        binding.toolbarLeftArrow.setVisibility(View.GONE);
                        break;
                    case 2:
                        toolbar.setTitle("Уровень 2");
                        questionNumber = 22;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 3:
                        toolbar.setTitle("Уровень 3");
                        questionNumber = 23;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 4:
                        toolbar.setTitle("Уровень 4");
                        questionNumber = 24;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 5:
                        toolbar.setTitle("Уровень 5");
                        questionNumber = 25;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 6:
                        toolbar.setTitle("Уровень 6");
                        questionNumber = 26;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 7:
                        toolbar.setTitle("Уровень 7");
                        questionNumber = 27;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 8:
                        toolbar.setTitle("Уровень 8");
                        questionNumber = 28;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 9:
                        toolbar.setTitle("Уровень 9");
                        questionNumber = 29;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 10:
                        toolbar.setTitle("Уровень 10");
                        questionNumber = 30;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 11:
                        toolbar.setTitle("Уровень 11");
                        questionNumber = 31;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 12:
                        toolbar.setTitle("Уровень 12");
                        questionNumber = 32;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 13:
                        toolbar.setTitle("Уровень 13");
                        questionNumber = 33;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 14:
                        toolbar.setTitle("Уровень 14");
                        questionNumber = 34;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 15:
                        toolbar.setTitle("Уровень 15");
                        questionNumber = 35;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 16:
                        toolbar.setTitle("Уровень 16");
                        questionNumber = 36;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 17:
                        toolbar.setTitle("Уровень 17");
                        questionNumber = 37;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 18:
                        toolbar.setTitle("Уровень 18");
                        questionNumber = 38;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 19:
                        toolbar.setTitle("Уровень 19");
                        questionNumber = 39;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 20:
                        toolbar.setTitle("Уровень 20");
                        questionNumber = 40;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        binding.toolbarRightArrow.setVisibility(View.GONE);
                        break;
                }
                break;

            case 3:
                switch (levelId){
                    case 1:
                        toolbar.setTitle("Уровень 1");
                        questionNumber = 41;
                        questionTextView.setText("Не");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        binding.toolbarLeftArrow.setVisibility(View.GONE);
                        break;
                    case 2:
                        toolbar.setTitle("Уровень 2");
                        questionNumber = 42;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 3:
                        toolbar.setTitle("Уровень 3");
                        questionNumber = 43;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 4:
                        toolbar.setTitle("Уровень 4");
                        questionNumber = 44;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 5:
                        toolbar.setTitle("Уровень 5");
                        questionNumber = 45;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 6:
                        toolbar.setTitle("Уровень 6");
                        questionNumber = 46;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 7:
                        toolbar.setTitle("Уровень 7");
                        questionNumber = 47;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 8:
                        toolbar.setTitle("Уровень 8");
                        questionNumber = 48;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 9:
                        toolbar.setTitle("Уровень 9");
                        questionNumber = 49;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 10:
                        toolbar.setTitle("Уровень 10");
                        questionNumber = 50;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 11:
                        toolbar.setTitle("Уровень 11");
                        questionNumber = 51;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 12:
                        toolbar.setTitle("Уровень 12");
                        questionNumber = 52;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 13:
                        toolbar.setTitle("Уровень 13");
                        questionNumber = 53;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 14:
                        toolbar.setTitle("Уровень 14");
                        questionNumber = 54;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 15:
                        toolbar.setTitle("Уровень 15");
                        questionNumber = 55;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 16:
                        toolbar.setTitle("Уровень 16");
                        questionNumber = 56;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 17:
                        toolbar.setTitle("Уровень 17");
                        questionNumber = 57;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 18:
                        toolbar.setTitle("Уровень 18");
                        questionNumber = 58;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 19:
                        toolbar.setTitle("Уровень 19");
                        questionNumber = 59;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 20:
                        toolbar.setTitle("Уровень 20");
                        questionNumber = 60;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        binding.toolbarRightArrow.setVisibility(View.GONE);
                        break;
                }
                break;

            case 4:
                switch (levelId){
                    case 1:
                        toolbar.setTitle("Уровень 1");
                        questionNumber = 61;
                        questionTextView.setText("Пап");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        binding.toolbarLeftArrow.setVisibility(View.GONE);
                        break;
                    case 2:
                        toolbar.setTitle("Уровень 2");
                        questionNumber = 62;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 3:
                        toolbar.setTitle("Уровень 3");
                        questionNumber = 63;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 4:
                        toolbar.setTitle("Уровень 4");
                        questionNumber = 64;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 5:
                        toolbar.setTitle("Уровень 5");
                        questionNumber = 65;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 6:
                        toolbar.setTitle("Уровень 6");
                        questionNumber = 66;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 7:
                        toolbar.setTitle("Уровень 7");
                        questionNumber = 67;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 8:
                        toolbar.setTitle("Уровень 8");
                        questionNumber = 68;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 9:
                        toolbar.setTitle("Уровень 9");
                        questionNumber = 69;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 10:
                        toolbar.setTitle("Уровень 10");
                        questionNumber = 70;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 11:
                        toolbar.setTitle("Уровень 11");
                        questionNumber = 71;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 12:
                        toolbar.setTitle("Уровень 12");
                        questionNumber = 72;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 13:
                        toolbar.setTitle("Уровень 13");
                        questionNumber = 73;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 14:
                        toolbar.setTitle("Уровень 14");
                        questionNumber = 74;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 15:
                        toolbar.setTitle("Уровень 15");
                        questionNumber = 75;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 16:
                        toolbar.setTitle("Уровень 16");
                        questionNumber = 76;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 17:
                        toolbar.setTitle("Уровень 17");
                        questionNumber = 77;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 18:
                        toolbar.setTitle("Уровень 18");
                        questionNumber = 78;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 19:
                        toolbar.setTitle("Уровень 19");
                        questionNumber = 79;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 20:
                        toolbar.setTitle("Уровень 20");
                        questionNumber = 80;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        binding.toolbarRightArrow.setVisibility(View.GONE);
                        break;
                }
                break;

            case 5:
                switch (levelId){
                    case 1:
                        toolbar.setTitle("Уровень 1");
                        questionNumber = 81;
                        questionTextView.setText("ИРИ");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        binding.toolbarLeftArrow.setVisibility(View.GONE);
                        break;
                    case 2:
                        toolbar.setTitle("Уровень 2");
                        questionNumber = 82;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 3:
                        toolbar.setTitle("Уровень 3");
                        questionNumber = 83;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 4:
                        toolbar.setTitle("Уровень 4");
                        questionNumber = 84;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 5:
                        toolbar.setTitle("Уровень 5");
                        questionNumber = 85;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 6:
                        toolbar.setTitle("Уровень 6");
                        questionNumber = 86;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 7:
                        toolbar.setTitle("Уровень 7");
                        questionNumber = 87;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 8:
                        toolbar.setTitle("Уровень 8");
                        questionNumber = 88;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 9:
                        toolbar.setTitle("Уровень 9");
                        questionNumber = 89;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 10:
                        toolbar.setTitle("Уровень 10");
                        questionNumber = 90;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 11:
                        toolbar.setTitle("Уровень 11");
                        questionNumber = 91;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 12:
                        toolbar.setTitle("Уровень 12");
                        questionNumber = 92;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 13:
                        toolbar.setTitle("Уровень 13");
                        questionNumber = 93;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 14:
                        toolbar.setTitle("Уровень 14");
                        questionNumber = 94;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 15:
                        toolbar.setTitle("Уровень 15");
                        questionNumber = 95;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 16:
                        toolbar.setTitle("Уровень 16");
                        questionNumber = 96;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 17:
                        toolbar.setTitle("Уровень 17");
                        questionNumber = 97;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 18:
                        toolbar.setTitle("Уровень 18");
                        questionNumber = 98;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 19:
                        toolbar.setTitle("Уровень 19");
                        questionNumber = 99;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 20:
                        toolbar.setTitle("Уровень 20");
                        questionNumber = 100;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        binding.toolbarRightArrow.setVisibility(View.GONE);
                        break;
                }
                break;

            case 6:
                switch (levelId){
                    case 1:
                        toolbar.setTitle("Уровень 1");
                        questionNumber = 101;
                        questionTextView.setText("ФЫФ");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        binding.toolbarLeftArrow.setVisibility(View.GONE);
                        break;
                    case 2:
                        toolbar.setTitle("Уровень 2");
                        questionNumber = 102;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 3:
                        toolbar.setTitle("Уровень 3");
                        questionNumber = 103;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 4:
                        toolbar.setTitle("Уровень 4");
                        questionNumber = 104;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 5:
                        toolbar.setTitle("Уровень 5");
                        questionNumber = 105;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 6:
                        toolbar.setTitle("Уровень 6");
                        questionNumber = 106;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 7:
                        toolbar.setTitle("Уровень 7");
                        questionNumber = 107;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 8:
                        toolbar.setTitle("Уровень 8");
                        questionNumber = 108;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 9:
                        toolbar.setTitle("Уровень 9");
                        questionNumber = 109;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 10:
                        toolbar.setTitle("Уровень 10");
                        questionNumber = 110;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 11:
                        toolbar.setTitle("Уровень 11");
                        questionNumber = 111;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 12:
                        toolbar.setTitle("Уровень 12");
                        questionNumber = 112;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 13:
                        toolbar.setTitle("Уровень 13");
                        questionNumber = 113;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 14:
                        toolbar.setTitle("Уровень 14");
                        questionNumber = 114;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 15:
                        toolbar.setTitle("Уровень 15");
                        questionNumber = 115;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 16:
                        toolbar.setTitle("Уровень 16");
                        questionNumber = 116;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 17:
                        toolbar.setTitle("Уровень 17");
                        questionNumber = 117;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 18:
                        toolbar.setTitle("Уровень 18");
                        questionNumber = 118;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 19:
                        toolbar.setTitle("Уровень 19");
                        questionNumber = 119;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        break;
                    case 20:
                        toolbar.setTitle("Уровень 20");
                        questionNumber = 120;
                        questionTextView.setText("");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("");
                        binding.button2.setText("");
                        binding.button3.setText("");
                        binding.button4.setText("");
                        binding.button5.setText("");
                        binding.button6.setText("");
                        binding.button7.setText("");
                        binding.button8.setText("");
                        binding.button9.setText("");
                        binding.button10.setText("");
                        binding.button11.setText("");
                        binding.button12.setText("");
                        binding.toolbarRightArrow.setVisibility(View.GONE);
                        break;
                }
                break;

            case 7:
                switch (levelId){
                    case 1:
                        toolbar.setTitle("Уровень 1");
                        questionNumber = 121;
                        questionTextView.setText("Какой вид сыра обычно используется в итальянских блюдах?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("П");
                        binding.button2.setText("Н");
                        binding.button3.setText("Р");
                        binding.button4.setText("М");
                        binding.button5.setText("Н");
                        binding.button6.setText("А");
                        binding.button7.setText("Й");
                        binding.button8.setText("К");
                        binding.button9.setText("З");
                        binding.button10.setText("Р");
                        binding.button11.setText("А");
                        binding.button12.setText("Е");
                        binding.toolbarLeftArrow.setVisibility(View.GONE);
                        break;
                    case 2:
                        toolbar.setTitle("Уровень 2");
                        questionNumber = 122;
                        questionTextView.setText("Какой напиток можно приготовить из «арабики»?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("А");
                        binding.button2.setText("Ф");
                        binding.button3.setText("Д");
                        binding.button4.setText("И");
                        binding.button5.setText("Й");
                        binding.button6.setText("К");
                        binding.button7.setText("Ч");
                        binding.button8.setText("Е");
                        binding.button9.setText("Т");
                        binding.button10.setText("Я");
                        binding.button11.setText("О");
                        binding.button12.setText("Ц");
                        break;
                    case 3:
                        toolbar.setTitle("Уровень 3");
                        questionNumber = 123;
                        questionTextView.setText("Как называется одичавшая клубника?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Л");
                        binding.button2.setText("М");
                        binding.button3.setText("З");
                        binding.button4.setText("У");
                        binding.button5.setText("Т");
                        binding.button6.setText("Н");
                        binding.button7.setText("К");
                        binding.button8.setText("Е");
                        binding.button9.setText("А");
                        binding.button10.setText("Я");
                        binding.button11.setText("С");
                        binding.button12.setText("И");
                        break;
                    case 4:
                        toolbar.setTitle("Уровень 4");
                        questionNumber = 124;
                        questionTextView.setText("Как называется блюдо, приготовленное из сырой рыбы?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("А");
                        binding.button2.setText("Р");
                        binding.button3.setText("С");
                        binding.button4.setText("Т");
                        binding.button5.setText("Ю");
                        binding.button6.setText("М");
                        binding.button7.setText("Х");
                        binding.button8.setText("Э");
                        binding.button9.setText("Ж");
                        binding.button10.setText("Ш");
                        binding.button11.setText("И");
                        binding.button12.setText("И");
                        break;
                    case 5:
                        toolbar.setTitle("Уровень 5");
                        questionNumber = 125;
                        questionTextView.setText("Какой острый овощ используется во многих кухнях?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Е");
                        binding.button2.setText("М");
                        binding.button3.setText("С");
                        binding.button4.setText("Е");
                        binding.button5.setText("Т");
                        binding.button6.setText("Р");
                        binding.button7.setText("В");
                        binding.button8.setText("П");
                        binding.button9.setText("Ц");
                        binding.button10.setText("Ф");
                        binding.button11.setText("Ч");
                        binding.button12.setText("Н");
                        break;
                    case 6:
                        toolbar.setTitle("Уровень 6");
                        questionNumber = 126;
                        questionTextView.setText("Какой овощ является основой для борща?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Л");
                        binding.button2.setText("Ч");
                        binding.button3.setText("Б");
                        binding.button4.setText("Х");
                        binding.button5.setText("Е");
                        binding.button6.setText("В");
                        binding.button7.setText("З");
                        binding.button8.setText("Т");
                        binding.button9.setText("К");
                        binding.button10.setText("А");
                        binding.button11.setText("Р");
                        binding.button12.setText("С");
                        break;
                    case 7:
                        toolbar.setTitle("Уровень 7");
                        questionNumber = 127;
                        questionTextView.setText("Как называется соус из помидоров, чеснока и базилика?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Э");
                        binding.button2.setText("Ы");
                        binding.button3.setText("И");
                        binding.button4.setText("Т");
                        binding.button5.setText("О");
                        binding.button6.setText("П");
                        binding.button7.setText("С");
                        binding.button8.setText("Ц");
                        binding.button9.setText("Ч");
                        binding.button10.setText("Е");
                        binding.button11.setText("У");
                        binding.button12.setText("Ь");
                        break;
                    case 8:
                        toolbar.setTitle("Уровень 8");
                        questionNumber = 128;
                        questionTextView.setText("Как называется мясной продукт, который изготавливается из фарша и обычно подается в форме круглых котлет?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("К");
                        binding.button2.setText("Н");
                        binding.button3.setText("Ф");
                        binding.button4.setText("И");
                        binding.button5.setText("Д");
                        binding.button6.setText("Е");
                        binding.button7.setText("Р");
                        binding.button8.setText("К");
                        binding.button9.setText("А");
                        binding.button10.setText("Л");
                        binding.button11.setText("И");
                        binding.button12.setText("Ь");
                        break;
                    case 9:
                        toolbar.setTitle("Уровень 9");
                        questionNumber = 129;
                        questionTextView.setText("Какой напиток изготавливают из молока и шоколада?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("О");
                        binding.button2.setText("Е");
                        binding.button3.setText("А");
                        binding.button4.setText("И");
                        binding.button5.setText("В");
                        binding.button6.setText("Т");
                        binding.button7.setText("К");
                        binding.button8.setText("К");
                        binding.button9.setText("С");
                        binding.button10.setText("А");
                        binding.button11.setText("Д");
                        binding.button12.setText("Ш");
                        break;
                    case 10:
                        toolbar.setTitle("Уровень 10");
                        questionNumber = 130;
                        questionTextView.setText("Какой вид макаронных изделий является национальным блюдом Италии?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("И");
                        binding.button2.setText("С");
                        binding.button3.setText("К");
                        binding.button4.setText("А");
                        binding.button5.setText("Е");
                        binding.button6.setText("Г");
                        binding.button7.setText("Ш");
                        binding.button8.setText("Т");
                        binding.button9.setText("Э");
                        binding.button10.setText("П");
                        binding.button11.setText("Т");
                        binding.button12.setText("А");
                        break;
                    case 11:
                        toolbar.setTitle("Уровень 11");
                        questionNumber = 131;
                        questionTextView.setText("Какой вид рыбы является самым популярным для приготовления суши?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Л");
                        binding.button2.setText("О");
                        binding.button3.setText("Н");
                        binding.button4.setText("Т");
                        binding.button5.setText("О");
                        binding.button6.setText("Р");
                        binding.button7.setText("С");
                        binding.button8.setText("К");
                        binding.button9.setText("А");
                        binding.button10.setText("С");
                        binding.button11.setText("У");
                        binding.button12.setText("Ь");
                        break;
                    case 12:
                        toolbar.setTitle("Уровень 12");
                        questionNumber = 132;
                        questionTextView.setText("Какой ингредиент является основным в блюде суши?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("С");
                        binding.button2.setText("З");
                        binding.button3.setText("М");
                        binding.button4.setText("В");
                        binding.button5.setText("Я");
                        binding.button6.setText("Р");
                        binding.button7.setText("Т");
                        binding.button8.setText("Й");
                        binding.button9.setText("Ю");
                        binding.button10.setText("Ж");
                        binding.button11.setText("Ъ");
                        binding.button12.setText("И");
                        break;
                    case 13:
                        toolbar.setTitle("Уровень 13");
                        questionNumber = 133;
                        questionTextView.setText("Какой напиток используется для приготовления окрошки?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("У");
                        binding.button2.setText("А");
                        binding.button3.setText("Н");
                        binding.button4.setText("С");
                        binding.button5.setText("З");
                        binding.button6.setText("К");
                        binding.button7.setText("В");
                        binding.button8.setText("Г");
                        binding.button9.setText("П");
                        binding.button10.setText("Л");
                        binding.button11.setText("Ч");
                        binding.button12.setText("Э");
                        break;
                    case 14:
                        toolbar.setTitle("Уровень 14");
                        questionNumber = 134;
                        questionTextView.setText("Название какого фрукта в голландском языке буквально означает «яблоко из Китая»?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("О");
                        binding.button2.setText("Е");
                        binding.button3.setText("Л");
                        binding.button4.setText("А");
                        binding.button5.setText("Ь");
                        binding.button6.setText("М");
                        binding.button7.setText("П");
                        binding.button8.setText("Ъ");
                        binding.button9.setText("Б");
                        binding.button10.setText("С");
                        binding.button11.setText("И");
                        binding.button12.setText("Н");
                        break;
                    case 15:
                        toolbar.setTitle("Уровень 15");
                        questionNumber = 135;
                        questionTextView.setText("Сырье для какого напитка бывает черным и зеленым?");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Е");
                        binding.button2.setText("А");
                        binding.button3.setText("Р");
                        binding.button4.setText("Т");
                        binding.button5.setText("О");
                        binding.button6.setText("Г");
                        binding.button7.setText("Ч");
                        binding.button8.setText("И");
                        binding.button9.setText("К");
                        binding.button10.setText("Ш");
                        binding.button11.setText("Й");
                        binding.button12.setText("Б");
                        break;
                    case 16:
                        toolbar.setTitle("Уровень 16");
                        questionNumber = 136;
                        questionTextView.setText("Кулинарное украшение для ушей");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Я");
                        binding.button2.setText("Й");
                        binding.button3.setText("Ш");
                        binding.button4.setText("А");
                        binding.button5.setText("Ж");
                        binding.button6.setText("Л");
                        binding.button7.setText("М");
                        binding.button8.setText("К");
                        binding.button9.setText("З");
                        binding.button10.setText("А");
                        binding.button11.setText("Ч");
                        binding.button12.setText("П");
                        break;
                    case 17:
                        toolbar.setTitle("Уровень 17");
                        questionNumber = 137;
                        questionTextView.setText("Торт императора");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Н");
                        binding.button2.setText("К");
                        binding.button3.setText("П");
                        binding.button4.setText("О");
                        binding.button5.setText("А");
                        binding.button6.setText("У");
                        binding.button7.setText("Н");
                        binding.button8.setText("О");
                        binding.button9.setText("Б");
                        binding.button10.setText("Л");
                        binding.button11.setText("И");
                        binding.button12.setText("Е");
                        break;
                    case 18:
                        toolbar.setTitle("Уровень 18");
                        questionNumber = 138;
                        questionTextView.setText("Сладкий картофель");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Ж");
                        binding.button2.setText("Ф");
                        binding.button3.setText("А");
                        binding.button4.setText("Я");
                        binding.button5.setText("Т");
                        binding.button6.setText("Б");
                        binding.button7.setText("У");
                        binding.button8.setText("Ь");
                        binding.button9.setText("З");
                        binding.button10.setText("А");
                        binding.button11.setText("Х");
                        binding.button12.setText("Т");
                        break;
                    case 19:
                        toolbar.setTitle("Уровень 19");
                        questionNumber = 139;
                        questionTextView.setText("Копченая свинина, важнейший компонент яичницы по-английски");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Ы");
                        binding.button2.setText("О");
                        binding.button3.setText("В");
                        binding.button4.setText("Б");
                        binding.button5.setText("Х");
                        binding.button6.setText("Н");
                        binding.button7.setText("А");
                        binding.button8.setText("Е");
                        binding.button9.setText("И");
                        binding.button10.setText("Ч");
                        binding.button11.setText("Т");
                        binding.button12.setText("К");
                        break;
                    case 20:
                        toolbar.setTitle("Уровень 20");
                        questionNumber = 140;
                        questionTextView.setText("Популярное блюдо американского фастфуда");
                        answerEditText.setText(viewModel.getCorrectAnswer(questionNumber));
                        binding.button1.setText("Г");
                        binding.button2.setText("Е");
                        binding.button3.setText("Ч");
                        binding.button4.setText("Р");
                        binding.button5.setText("В");
                        binding.button6.setText("М");
                        binding.button7.setText("И");
                        binding.button8.setText("Б");
                        binding.button9.setText("А");
                        binding.button10.setText("Ж");
                        binding.button11.setText("У");
                        binding.button12.setText("Р");
                        binding.toolbarRightArrow.setVisibility(View.GONE);
                        break;
                }
                break;
        }

        binding.toolbarLeftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMoveBackQuestion();
            }
        });

        binding.toolbarRightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMoveNextQuestion();
            }
        });
        //
        ArrayList<Pair<String, Boolean>> buttonData = viewModel.getButtonData(categoryId, levelId);
        if (buttonData != null) {
            // restore button text and isEnabled state
            for (int i = 0; i < buttonData.size(); i++) {
                Pair<String, Boolean> pair = buttonData.get(i);
                Button button = answerButtons.get(i);
                button.setText(pair.first);
                button.setEnabled(pair.second);
            }
        } else {
            //
            originalButtonText = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                originalButtonText.add(answerButtons.get(i).getText().toString());
                answerButtons.get(i).setEnabled(true);//
            }
        }//

        for (Button button : answerButtons) {
            button.setOnClickListener(this);
        }

        Button resetButton = binding.resetButton;
        resetButton.setEnabled(viewModel.getResetButtonState(categoryId, levelId));
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Button button : answerButtons) {
                    button.setEnabled(true);
                }
                answerEditText.setText("");
                for (int i = 0; i < 12; i++){
                    answerButtons.get(i).setText(originalButtonText.get(i));
                }
            }
        });

        String correctAnswer = getCorrectAnswerForCurrentQuestion();
        answerEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(correctAnswer.length())});
        answerEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                currentAnswer = answerEditText.getText().toString();
                if (currentAnswer.length() == correctAnswer.length()) {
                    if (currentAnswer.equalsIgnoreCase(correctAnswer)) {
                        viewModel.setCorrectAnswer(questionNumber, correctAnswer);
                        for (Button button : answerButtons) {
                            button.setEnabled(false);
                        }
                        resetButton.setEnabled(false);
                        //
                        ArrayList<Pair<String, Boolean>> buttonData = new ArrayList<>();
                        for (Button button : answerButtons) {
                            buttonData.add(new Pair<>(button.getText().toString(), button.isEnabled()));
                        }
                        viewModel.setResetButtonState(categoryId, levelId, resetButton.isEnabled());
                        viewModel.setButtonData(categoryId, levelId, buttonData);
                        //
                        Toast.makeText(getContext(), "Правильно!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Не правильно!", Toast.LENGTH_SHORT).show();
                        for (Button button : answerButtons) {
                            button.setEnabled(false);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return binding.getRoot();
    }

    private String getCorrectAnswerForCurrentQuestion(){
        int categoryId = viewModel.getCategoryId();
        int levelId = viewModel.getLevelId();
        String correctAnswer = "";
        switch (categoryId){
            case 1:
                switch (levelId){
                    case 1:
                        correctAnswer = "КИТАЙ";
                        break;
                    case 2:
                        correctAnswer = "САХАРА";
                        break;
                    case 3:
                        correctAnswer = "РОССИЯ";
                        break;
                    case 4:
                        correctAnswer = "ГРЕЦИЯ";
                        break;
                    case 5:
                        correctAnswer = "ЮАНЬ";
                        break;
                    case 6:
                        correctAnswer = "ЯПОНИЯ";
                        break;
                    case 7:
                        correctAnswer = "ШВЕЙЦАРИЯ";
                        break;
                    case 8:
                        correctAnswer = "АВСТРАЛИЯ";
                        break;
                    case 9:
                        correctAnswer = "НИЛ";
                        break;
                    case 10:
                        correctAnswer = "ЕВРАЗИЯ";
                        break;
                    case 11:
                        correctAnswer = "АТМОСФЕРА";
                        break;
                    case 12:
                        correctAnswer = "ТИХИЙ";
                        break;
                    case 13:
                        correctAnswer = "КОМПАС";
                        break;
                    case 14:
                        correctAnswer = "КРАСНОЕ";
                        break;
                    case 15:
                        correctAnswer = "ГЛОБУС";
                        break;
                    case 16:
                        correctAnswer = "ЗАКАТ";
                        break;
                    case 17:
                        correctAnswer = "ГАНА";
                        break;
                    case 18:
                        correctAnswer = "ЗИМА";
                        break;
                    case 19:
                        correctAnswer = "НЕПАЛ";
                        break;
                    case 20:
                        correctAnswer = "МАДРИД";
                        break;
                }
                break;

            case 2:
                switch (levelId){
                    case 1:
                        correctAnswer = "А";
                        break;
                    case 2:
                        correctAnswer = "";
                        break;
                    case 3:
                        correctAnswer = "";
                        break;
                    case 4:
                        correctAnswer = "";
                        break;
                    case 5:
                        correctAnswer = "";
                        break;
                    case 6:
                        correctAnswer = "";
                        break;
                    case 7:
                        correctAnswer = "";
                        break;
                    case 8:
                        correctAnswer = "";
                        break;
                    case 9:
                        correctAnswer = "";
                        break;
                    case 10:
                        correctAnswer = "";
                        break;
                    case 11:
                        correctAnswer = "";
                        break;
                    case 12:
                        correctAnswer = "";
                        break;
                    case 13:
                        correctAnswer = "";
                        break;
                    case 14:
                        correctAnswer = "";
                        break;
                    case 15:
                        correctAnswer = "";
                        break;
                    case 16:
                        correctAnswer = "";
                        break;
                    case 17:
                        correctAnswer = "";
                        break;
                    case 18:
                        correctAnswer = "";
                        break;
                    case 19:
                        correctAnswer = "";
                        break;
                    case 20:
                        correctAnswer = "";
                        break;
                }
                break;

            case 3:
                switch (levelId){
                    case 1:
                        correctAnswer = "";
                        break;
                    case 2:
                        correctAnswer = "";
                        break;
                    case 3:
                        correctAnswer = "";
                        break;
                    case 4:
                        correctAnswer = "";
                        break;
                    case 5:
                        correctAnswer = "";
                        break;
                    case 6:
                        correctAnswer = "";
                        break;
                    case 7:
                        correctAnswer = "";
                        break;
                    case 8:
                        correctAnswer = "";
                        break;
                    case 9:
                        correctAnswer = "";
                        break;
                    case 10:
                        correctAnswer = "";
                        break;
                    case 11:
                        correctAnswer = "";
                        break;
                    case 12:
                        correctAnswer = "";
                        break;
                    case 13:
                        correctAnswer = "";
                        break;
                    case 14:
                        correctAnswer = "";
                        break;
                    case 15:
                        correctAnswer = "";
                        break;
                    case 16:
                        correctAnswer = "";
                        break;
                    case 17:
                        correctAnswer = "";
                        break;
                    case 18:
                        correctAnswer = "";
                        break;
                    case 19:
                        correctAnswer = "";
                        break;
                    case 20:
                        correctAnswer = "";
                        break;
                }
                break;

            case 4:
                switch (levelId){
                    case 1:
                        correctAnswer = "";
                        break;
                    case 2:
                        correctAnswer = "";
                        break;
                    case 3:
                        correctAnswer = "";
                        break;
                    case 4:
                        correctAnswer = "";
                        break;
                    case 5:
                        correctAnswer = "";
                        break;
                    case 6:
                        correctAnswer = "";
                        break;
                    case 7:
                        correctAnswer = "";
                        break;
                    case 8:
                        correctAnswer = "";
                        break;
                    case 9:
                        correctAnswer = "";
                        break;
                    case 10:
                        correctAnswer = "";
                        break;
                    case 11:
                        correctAnswer = "";
                        break;
                    case 12:
                        correctAnswer = "";
                        break;
                    case 13:
                        correctAnswer = "";
                        break;
                    case 14:
                        correctAnswer = "";
                        break;
                    case 15:
                        correctAnswer = "";
                        break;
                    case 16:
                        correctAnswer = "";
                        break;
                    case 17:
                        correctAnswer = "";
                        break;
                    case 18:
                        correctAnswer = "";
                        break;
                    case 19:
                        correctAnswer = "";
                        break;
                    case 20:
                        correctAnswer = "";
                        break;
                }
                break;

            case 5:
                switch (levelId){
                    case 1:
                        correctAnswer = "";
                        break;
                    case 2:
                        correctAnswer = "";
                        break;
                    case 3:
                        correctAnswer = "";
                        break;
                    case 4:
                        correctAnswer = "";
                        break;
                    case 5:
                        correctAnswer = "";
                        break;
                    case 6:
                        correctAnswer = "";
                        break;
                    case 7:
                        correctAnswer = "";
                        break;
                    case 8:
                        correctAnswer = "";
                        break;
                    case 9:
                        correctAnswer = "";
                        break;
                    case 10:
                        correctAnswer = "";
                        break;
                    case 11:
                        correctAnswer = "";
                        break;
                    case 12:
                        correctAnswer = "";
                        break;
                    case 13:
                        correctAnswer = "";
                        break;
                    case 14:
                        correctAnswer = "";
                        break;
                    case 15:
                        correctAnswer = "";
                        break;
                    case 16:
                        correctAnswer = "";
                        break;
                    case 17:
                        correctAnswer = "";
                        break;
                    case 18:
                        correctAnswer = "";
                        break;
                    case 19:
                        correctAnswer = "";
                        break;
                    case 20:
                        correctAnswer = "";
                        break;
                }
                break;

            case 6:
                switch (levelId){
                    case 1:
                        correctAnswer = "";
                        break;
                    case 2:
                        correctAnswer = "";
                        break;
                    case 3:
                        correctAnswer = "";
                        break;
                    case 4:
                        correctAnswer = "";
                        break;
                    case 5:
                        correctAnswer = "";
                        break;
                    case 6:
                        correctAnswer = "";
                        break;
                    case 7:
                        correctAnswer = "";
                        break;
                    case 8:
                        correctAnswer = "";
                        break;
                    case 9:
                        correctAnswer = "";
                        break;
                    case 10:
                        correctAnswer = "";
                        break;
                    case 11:
                        correctAnswer = "";
                        break;
                    case 12:
                        correctAnswer = "";
                        break;
                    case 13:
                        correctAnswer = "";
                        break;
                    case 14:
                        correctAnswer = "";
                        break;
                    case 15:
                        correctAnswer = "";
                        break;
                    case 16:
                        correctAnswer = "";
                        break;
                    case 17:
                        correctAnswer = "";
                        break;
                    case 18:
                        correctAnswer = "";
                        break;
                    case 19:
                        correctAnswer = "";
                        break;
                    case 20:
                        correctAnswer = "";
                        break;
                }
                break;

            case 7:
                switch (levelId){
                    case 1:
                        correctAnswer = "ПАРМЕЗАН";
                        break;
                    case 2:
                        correctAnswer = "КОФЕ";
                        break;
                    case 3:
                        correctAnswer = "ЗЕМЛЯНИКА";
                        break;
                    case 4:
                        correctAnswer = "САШИМИ";
                        break;
                    case 5:
                        correctAnswer = "ПЕРЕЦ";
                        break;
                    case 6:
                        correctAnswer = "СВЕКЛА";
                        break;
                    case 7:
                        correctAnswer = "ПЕСТО";
                        break;
                    case 8:
                        correctAnswer = "ФРИКАДЕЛЬКИ";
                        break;
                    case 9:
                        correctAnswer = "КАКАО";
                        break;
                    case 10:
                        correctAnswer = "СПАГЕТТИ";
                        break;
                    case 11:
                        correctAnswer = "ЛОСОСЬ";
                        break;
                    case 12:
                        correctAnswer = "РИС";
                        break;
                    case 13:
                        correctAnswer = "КВАС";
                        break;
                    case 14:
                        correctAnswer = "АПЕЛЬСИН";
                        break;
                    case 15:
                        correctAnswer = "ЧАЙ";
                        break;
                    case 16:
                        correctAnswer = "ЛАПША";
                        break;
                    case 17:
                        correctAnswer = "НАПОЛЕОН";
                        break;
                    case 18:
                        correctAnswer = "БАТАТ";
                        break;
                    case 19:
                        correctAnswer = "БЕКОН";
                        break;
                    case 20:
                        correctAnswer = "БУРГЕР";
                        break;
                }
                break;
        }
        return correctAnswer;
    }

    public void onMoveNextQuestion(){
        int levelId = viewModel.getLevelId();
        viewModel.setLevelId(levelId + 1);
        Navigation.findNavController(getView()).popBackStack();
        Navigation.findNavController(requireActivity(), R.id.fragmentContainerView).navigate(R.id.level);
    }

    public void onMoveBackQuestion(){
        int levelId = viewModel.getLevelId();
        viewModel.setLevelId(levelId - 1);
        Navigation.findNavController(getView()).popBackStack();
        Navigation.findNavController(requireActivity(), R.id.fragmentContainerView).navigate(R.id.level);
    }

    @Override
    public void onClick(View view) {
        if (view instanceof Button) {
            String buttonText = ((Button) view).getText().toString();
            String currentAnswer = answerEditText.getText().toString();
            if (currentAnswer.length() < getCorrectAnswerForCurrentQuestion().length()){

                answerEditText.setText(currentAnswer + buttonText);
            }
            ((Button) view).setText("");
            view.setEnabled(false);
        }
    }


    @Override
    public void onPause(){
        super.onPause();
        viewModel.saveData(requireContext());
        viewModel.saveButtonData(requireContext());
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        viewModel.saveData(requireContext());
        viewModel.saveButtonData(requireContext());
    }






}


