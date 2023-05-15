package com.example.quiz.questions;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private final String mText;
    private final List<String> mOptions;
    private final String mCorrectOption;

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
