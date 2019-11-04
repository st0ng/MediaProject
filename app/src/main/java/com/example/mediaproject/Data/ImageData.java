package com.example.mediaproject.Data;

import java.util.HashMap;
import java.util.Map;

public class ImageData {
    public String Uid;
    public String UserEmail;
    public String ImageUri;
    public String description;
    public String CreateDate;


    public ImageData(){

    }

    public ImageData(String Uid , String UserEmail , String ImageUri , String description , String CreateDate){
        this.Uid = Uid;
        this.UserEmail = UserEmail;
        this.ImageUri = ImageUri;
        this.description = description;
        this.CreateDate = CreateDate;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Uid", Uid);
        result.put("UserEmail", UserEmail);
        result.put("ImageUri", ImageUri);
        result.put("description", description);
        result.put("CreateDate", CreateDate);

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
}
