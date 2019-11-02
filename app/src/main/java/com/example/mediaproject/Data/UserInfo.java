package com.example.mediaproject.Data;

import java.util.HashMap;
import java.util.Map;

public class UserInfo {
    String Uid;
    String UserEmail;
    String UserProviderId;
    String UserDisplayName;

    public UserInfo(String Uid, String UserEmail, String UserProviderId, String UserDisplayName) {
        this.Uid = Uid;
        this.UserEmail = UserEmail;
        this.UserProviderId = UserProviderId;
        this.UserDisplayName = UserDisplayName;


    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Uid", Uid);
        result.put("UserEmail", UserEmail);
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
}
