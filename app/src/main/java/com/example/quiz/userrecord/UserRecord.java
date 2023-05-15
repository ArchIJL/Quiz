package com.example.quiz.userrecord;

public class UserRecord {
    private final String nickname;
    private final int score;

    public UserRecord(String nickname, int score) {
        this.nickname = nickname;
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }

    public int getScore() {
        return score;
    }
}
