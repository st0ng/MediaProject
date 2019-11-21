package com.example.mediaproject.Data;

import java.util.HashMap;
import java.util.Map;

public class TourInfoModel {
    public String TourTitle;
    public String TourImage;
    public String TourAddr;
    public int TourContentId = 0;
    public int starCount = 0;
    public int EvaluationCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();
    public Object Evaluations;

    public TourInfoModel() {

    }
}
