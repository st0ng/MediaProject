package com.example.mediaproject.Data;

public class UserTourListModel {
    public String Uid;
    public String UserEmail;
    public String ImageUri;
    public String description;
    public String CreateDate;


    public UserTourListModel() {

    }

    public UserTourListModel(String Uid, String UserEmail, String ImageUri, String description, String CreateDate) {
        this.Uid = Uid;
        this.UserEmail = UserEmail;
        this.ImageUri = ImageUri;
        this.description = description;
        this.CreateDate = CreateDate;
    }
}
