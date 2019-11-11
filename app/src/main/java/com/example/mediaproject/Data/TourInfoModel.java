package com.example.mediaproject.Data;

import java.util.HashMap;
import java.util.Map;

public class TourInfoModel {
    public String TourTitle;
    public int evaluationCount = 0;
    public int starCount = 0;
    public Map<String, Double> evaluation = new HashMap<>();
    public Map<String, Boolean> stars = new HashMap<>();

    public TourInfoModel(){

    }

    public TourInfoModel(String TourTitle, int evaluationCount, int starCount, Map<String, Double> evaluation, Map<String, Boolean> stars) {
        this.TourTitle = TourTitle;
        this.starCount = starCount;
        this.evaluationCount = evaluationCount;
        this.stars = stars;
        this.evaluation = evaluation;
    }
}
