package com.wujingcheng7.hoteldemo_backend.domain;

public class UserQuestion {
    private String user_tel;
    private String user_question;
    private String user_answer;

    public UserQuestion() {
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_question() {
        return user_question;
    }

    public void setUser_question(String user_question) {
        this.user_question = user_question;
    }

    public String getUser_answer() {
        return user_answer;
    }

    public void setUser_answer(String user_answer) {
        this.user_answer = user_answer;
    }
}
