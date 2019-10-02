package com.example.mediaproject.TourApi.Model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Items {

    @SerializedName("item")
    @JsonAdapter(AlwaysListTypeAdapterFactory.class)
    private List<Item> item = null;

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    /*
     배열 받을때
    * */
//    @SerializedName("item")
//    @Expose
//    private List<Item> item = null;
//
//    public List<Item> getItem() {
//        return item;
//    }
//
//    public void setItem(List<Item> item) {
//        this.item = item;
//    }

}
