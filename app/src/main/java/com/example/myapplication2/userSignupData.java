package com.example.myapplication2;

public class userSignupData extends userData {
    userSignupData(){};
    String signupUserName , signupNumber , signupPsswd;

    public String getSignupUserName() {
        return signupUserName;
    }

    public void setSignupUserName(String signupUserName) {
        this.signupUserName = signupUserName;
    }

    public String getSignupNumber() {
        return signupNumber;
    }

    public void setSignupNumber(String signupNumber) {
        this.signupNumber = signupNumber;
    }

    public String getSignupPsswd() {
        return signupPsswd;
    }

    public void setSignupPsswd(String signupPsswd) {
        this.signupPsswd = signupPsswd;
    }

    public userSignupData(String signupUserName, String signupNumber, String signupPsswd) {
        this.signupUserName = signupUserName;
        this.signupNumber = signupNumber;
        this.signupPsswd = signupPsswd ;
    }
}
