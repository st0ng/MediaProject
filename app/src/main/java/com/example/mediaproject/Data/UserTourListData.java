package com.example.mediaproject.Data;

public class UserTourListData {
        public String Uid;
        public String UserEmail;
        public String ImageUri;
        public String description;
        public String CreateDate;


    public UserTourListData(){

    }

    public UserTourListData(String Uid , String UserEmail , String ImageUri , String description , String CreateDate){
        this.Uid = Uid;
        this.UserEmail = UserEmail;
        this.ImageUri = ImageUri;
        this.description = description;
        this.CreateDate = CreateDate;
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
