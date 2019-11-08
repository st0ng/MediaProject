package com.example.mediaproject.Data;

import java.util.HashMap;
import java.util.Map;

public class UserTourListData {
    public String Uid;
    public String UserEmail;
    public String ImageUri;
    public String ImageName;
    public String description;
    public String CreateDate;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();


    public UserTourListData() {

    }

    public UserTourListData(String Uid, String UserEmail, String ImageUri, String ImageName , String description, String CreateDate,
                              int starCount , Map<String , Boolean> stars) {
        this.Uid = Uid;
        this.UserEmail = UserEmail;
        this.ImageUri = ImageUri;
        this.ImageName = ImageName;
        this.description = description;
        this.CreateDate = CreateDate;
        this.starCount = starCount;
        this.stars = stars;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Uid", Uid);
        result.put("UserEmail", UserEmail);
        result.put("ImageUri", ImageUri);
        result.put("description", description);
        result.put("CreateDate", CreateDate);
        result.put("starCount", starCount);
        result.put("stars", stars);
        return result;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getImageUri() {
        return ImageUri;
    }

    public void setImageUri(String imageUri) {
        ImageUri = imageUri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public Map<String, Boolean> getStars() {
        return stars;
    }

    public void setStars(Map<String, Boolean> stars) {
        this.stars = stars;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }
}
