package com.example.mediaproject.Data;

public class UserInfo {
    String UserName;
    String PassWord;
    String UserImage;

    public UserInfo (String UserName, String PassWord, String UserImage){
        this.UserName = UserName;
        this.PassWord = PassWord;
        this.UserImage = UserImage;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getUserImage() {
        return UserImage;
    }

    public void setUserImage(String userImage) {
        UserImage = userImage;
    }
}
