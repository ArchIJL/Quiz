package com.example.quiz.questions;

public class QuestionCampaign {

    private final String mText;
    private final int mQuestionNumber;
    private final String mButtonText;
    private final String mCorrectAnswer;
    private final String mInfoAnswer;

    public QuestionCampaign(String text, int questionNumber, String buttonText, String correctAnswer, String infoAnswer) {
        mText = text;
        mQuestionNumber = questionNumber;
        mButtonText = buttonText;
        mCorrectAnswer = correctAnswer;
        mInfoAnswer = infoAnswer;
    }

    public String getmText() {
        return mText;
    }

    public String getmButtonText() {
        return mButtonText;
    }

    public int getmQuestionNumber() {
        return mQuestionNumber;
    }

    public String getmCorrectAnswer() {
        return mCorrectAnswer;
    }

    public String getmInfoAnswer() {
        return mInfoAnswer;
    }
}