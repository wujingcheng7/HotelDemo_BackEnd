package com.wujingcheng7.hoteldemo_backend.domain;

public class account {
    private long user_tel;
    private String user_name;
    private int    user_sex;//0:male  1:female
    private String user_password;

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    private String user_bankcard;

    public long getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(long user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_bankcard() {
        return user_bankcard;
    }

    public void setUser_bankcard(String user_bankcard) {
        this.user_bankcard = user_bankcard;
    }

}
