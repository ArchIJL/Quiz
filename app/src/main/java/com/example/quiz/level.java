package com.example.quiz;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
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

import com.example.quiz.databinding.FragmentLevelsBinding;

import java.util.ArrayList;


public class level extends Fragment implements View.OnClickListener {

    private TextView questionTextView;
    private EditText answerEditText;
    private String correctAnswer;
    private ArrayList<Button> answerButtons;

    private int levelId;

    private FragmentLevelsBinding binding = null;


    public static level newInstance() {
        level fragment = new level();
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
        binding = FragmentLevelsBinding.inflate(inflater, container, false);
        Toolbar toolbar = binding.toolbar;
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view1 -> requireActivity().onBackPressed());

        questionTextView = binding.textQuestions;
        answerEditText = binding.editText;
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

        for (Button button : answerButtons) {
            button.setOnClickListener(this);
        }

        levelId = getArguments().getInt("levelId");

        switch (levelId) {
            case 1:
                toolbar.setTitle("Уровень 1");
                questionTextView.setText("Кто президент Франции?");
                correctAnswer = "Макрон";
                binding.button1.setText("М");
                binding.button2.setText("Н");
                binding.button3.setText("Р");
                binding.button4.setText("Б");
                binding.button5.setText("И");
                binding.button6.setText("А");
                binding.button7.setText("Й");
                binding.button8.setText("К");
                binding.button9.setText("О");
                binding.button10.setText("С");
                break;
            case 2:
                toolbar.setTitle("Уровень 2");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 3:
                toolbar.setTitle("Уровень 3");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 4:
                toolbar.setTitle("Уровень 4");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 5:
                toolbar.setTitle("Уровень 5");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 6:
                toolbar.setTitle("Уровень 6");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 7:
                toolbar.setTitle("Уровень 7");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 8:
                toolbar.setTitle("Уровень 8");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 9:
                toolbar.setTitle("Уровень 9");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 10:
                toolbar.setTitle("Уровень 10");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 11:
                toolbar.setTitle("Уровень 11");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 12:
                toolbar.setTitle("Уровень 12");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 13:
                toolbar.setTitle("Уровень 13");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 14:
                toolbar.setTitle("Уровень 14");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 15:
                toolbar.setTitle("Уровень 15");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 16:
                toolbar.setTitle("Уровень 16");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 17:
                toolbar.setTitle("Уровень 17");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 18:
                toolbar.setTitle("Уровень 18");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 19:
                toolbar.setTitle("Уровень 19");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
            case 20:
                toolbar.setTitle("Уровень 20");
                questionTextView.setText("");
                correctAnswer = "";
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
                break;
        }


        answerEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(correctAnswer.length())});
        answerEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String currentAnswer = answerEditText.getText().toString();
                if (currentAnswer.length() == correctAnswer.length()) {
                    if (currentAnswer.equalsIgnoreCase(correctAnswer)) {
                        answerEditText.setEnabled(false);
                        for (Button button : answerButtons) {
                            button.setEnabled(false);
                        }
                        Toast.makeText(getContext(), "Правильно!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Не правильно!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        if (view instanceof Button) {
            String buttonText = ((Button) view).getText().toString();
            String currentAnswer = answerEditText.getText().toString();

            if (currentAnswer.length() < correctAnswer.length()){
                answerEditText.setText(currentAnswer + buttonText);
            }
        }
    }
}


