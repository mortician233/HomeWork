package com.homework.yandex.Utils;


public class UserData {
    private  String fieldLogIn;
    private  String fieldPassword;


    public String getFieldLogIn() {
        return fieldLogIn;
    }

    public String getFieldPassword() {
        return fieldPassword;
    }

    public UserData(String fieldLogIn, String fieldPassword) {
        this.fieldLogIn = fieldLogIn;
        this.fieldPassword = fieldPassword;
    }
}
