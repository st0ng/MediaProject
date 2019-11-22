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
    public int CommentCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();
    public Object Comments = null;
    public String Cat2;
    public String Cat3;
    public String Addr;
    public  String Title;


    public UserTourListModel() {

    }

}
