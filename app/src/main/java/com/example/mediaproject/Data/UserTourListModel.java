package com.example.mediaproject.Data;

import java.util.HashMap;
import java.util.Map;

public class UserTourListModel {
    public String Uid;
    public String UserEmail;
    public String ImageUri;
    public String ImageName;
    public String description;
    public String CreateDate;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();


    public UserTourListModel() {

    }

    public UserTourListModel(String Uid, String UserEmail, String ImageUri, String description, String CreateDate,
                              int starCount , Map<String , Boolean> stars) {
        this.Uid = Uid;
        this.UserEmail = UserEmail;
        this.ImageUri = ImageUri;
        this.description = description;
        this.CreateDate = CreateDate;
        this.starCount = starCount;
        this.stars = stars;
    }
}
