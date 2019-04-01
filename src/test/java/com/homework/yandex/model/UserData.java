package com.homework.yandex.model;

public class UserData {

    private String username;
    private String password;


    public UserData withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserData withPassword(String password) {
        this.password = password;
        return this;
    }


    public UserData() {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

