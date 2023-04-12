package com.example.quiz.model;

import androidx.lifecycle.ViewModel;

import com.example.quiz.MainActivity;

import java.util.List;

public class QuestionsTaSViewModel extends ViewModel {

    private List<MainActivity.Question> mQuestions;

    public List<MainActivity.Question> getQuestions() {
        return mQuestions;
    }

    public void setQuestions(List<MainActivity.Question> questions) {
        mQuestions = questions;
    }
}
