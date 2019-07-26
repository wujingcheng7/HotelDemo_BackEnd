package com.wujingcheng7.hoteldemo_backend.domain;

public class Account {

    private String user_tel;
    private String user_name;
    private String user_sex;//"男"或者"女"
    private String user_password;
    private String user_bankcard;

    public Account(String user_tel, String user_password) {
        this.user_tel = user_tel;
        this.user_password = user_password;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_bankcard() {
        return user_bankcard;
    }

    public void setUser_bankcard(String user_bankcard) {
        this.user_bankcard = user_bankcard;
    }
}
