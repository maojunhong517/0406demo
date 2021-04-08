package com.example.demo.entity;

public class User {
    private String id;
    private String userName;
    private String passWord;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
