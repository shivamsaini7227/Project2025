package com.example.myapplication2;

public class userData {
    String name , phoneNumber , Password ;
    userData(){}

    public userData(String name, String phoneNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        Password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
