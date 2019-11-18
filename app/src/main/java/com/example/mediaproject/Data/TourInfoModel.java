package com.example.mediaproject.Data;

import java.util.HashMap;
import java.util.Map;

public class TourInfoModel {
    public String TourTitle;
    public String TourImage;
    public String TourAddr;
    public int TourContentId;
    public int evaluationCount;
    public int starCount;
    public Map<String, Double> evaluation = new HashMap<>();
    public Map<String, Boolean> stars = new HashMap<>();

    public TourInfoModel() {

    }
}
