package com.example.mediaproject.Data;

import java.util.HashMap;
import java.util.Map;

public class TourInfoData {
    public String TourTitle;
    public int evaluationCount = 0;
    public int starCount = 0;
    public Map<String, Double> evaluation = new HashMap<>();
    public Map<String, Boolean> stars = new HashMap<>();

    public TourInfoData(){

    }

    public TourInfoData(String TourTitle, int evaluationCount, int starCount, Map<String, Double> evaluation, Map<String, Boolean> stars) {
        this.TourTitle = TourTitle;
        this.starCount = starCount;
        this.evaluationCount = evaluationCount;
        this.stars = stars;
        this.evaluation = evaluation;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("TourTitle", TourTitle);
        result.put("evaluationCount", evaluationCount);
        result.put("starCount", starCount);
        result.put("evaluation", evaluation);
        result.put("stars", stars);
        return result;
    }


    public String getTourTitle() {
        return TourTitle;
    }

    public void setTourTitle(String tourTitle) {
        TourTitle = tourTitle;
    }

    public int getEvaluationCount() {
        return evaluationCount;
    }

    public void setEvaluationCount(int evaluationCount) {
        this.evaluationCount = evaluationCount;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public Map<String, Double> getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Map<String, Double> evaluation) {
        this.evaluation = evaluation;
    }

    public Map<String, Boolean> getStars() {
        return stars;
    }

    public void setStars(Map<String, Boolean> stars) {
        this.stars = stars;
    }
}




