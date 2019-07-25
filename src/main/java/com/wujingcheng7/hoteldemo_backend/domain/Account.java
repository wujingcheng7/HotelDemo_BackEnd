package com.wujingcheng7.hoteldemo_backend.domain;

public class Account {
    private String id;
    private String name;//姓名
    private String sex;//性别
    private String telphone;//电话
    private String bankcard;//银行卡
    private String password;//密码

    public Account(){
    }

    public Account(String id, String name, String sex, String telphone, String bankcard, String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.telphone = telphone;
        this.bankcard = bankcard;
        this.password = password;
    }

    //getter方法
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getTelphone() {
        return telphone;
    }

    public String getBankcard() {
        return bankcard;
    }

    public String getPassword() {
        return password;
    }
    //setter方法

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
