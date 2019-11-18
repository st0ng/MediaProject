package com.example.mediaproject.Data;

import java.util.HashMap;
import java.util.Map;

public class UserInfo {
    public String Uid;
    public String UserEmail;
    public String UserImage;
    public String UserSex;
    public String UserPost;
    public String UserProviderId;
    public String UserDisplayName;
    public String UserPassword;

    public UserInfo(String Uid, String UserEmail, String UserImage , String UserSex , String UserPost, String UserProviderId, String UserDisplayName, String UserPassword) {
        this.Uid = Uid;
        this.UserEmail = UserEmail;
        this.UserImage = UserImage;
        this.UserSex = UserSex;
        this.UserPost = UserPost;
        this.UserProviderId = UserProviderId;
        this.UserDisplayName = UserDisplayName;
        this.UserPassword= UserPassword;


    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Uid", Uid);
        result.put("UserEmail", UserEmail);
        result.put("UserImage", UserImage);
        result.put("UserSex", UserSex);
        result.put("UserPost", UserPost);
        result.put("UserProviderId", UserProviderId);
        result.put("UserDisplayName", UserDisplayName);
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

    public String getUserProviderId() {
        return UserProviderId;
    }

    public void setUserProviderId(String userProviderId) {
        UserProviderId = userProviderId;
    }

    public String getUserDisplayName() {
        return UserDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        UserDisplayName = userDisplayName;
    }

    public String getUserImage() {
        return UserImage;
    }

    public void setUserImage(String userImage) {
        UserImage = userImage;
    }

    public String getUserSex() {
        return UserSex;
    }

    public void setUserSex(String userSex) {
        UserSex = userSex;
    }

    public String getUserPost() {
        return UserPost;
    }

    public void setUserPost(String userPost) {
        UserPost = userPost;
    }
}
