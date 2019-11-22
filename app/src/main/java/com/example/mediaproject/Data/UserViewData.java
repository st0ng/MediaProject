package com.example.mediaproject.Data;

public class UserViewData {
   public String Image;
   public String Name;

   public UserViewData(String Image , String Name){
       this.Image = Image;
       this.Name = Name;
   }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
