package com.example.mediaproject.Data;

import java.util.HashMap;
import java.util.Map;

public class TourInfoData {
    public String TourTitle;
    public String TourImage;
    public String TourAddr;
    public int TourContentId = 0;
    public int starCount = 0;
    public int EvaluationCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();
    public Object Evaluations;

    public TourInfoData() {

    }

    public TourInfoData(String TourTitle, String TourImage, String TourAddr,
                        int TourContentId, int starCount, int EvaluationCount, Map<String, Boolean> stars,
                        Object Evaluations) {
        this.TourTitle = TourTitle;
        this.TourImage = TourImage;
        this.TourAddr = TourAddr;
        this.TourContentId = TourContentId;
        this.starCount = starCount;
        this.EvaluationCount = EvaluationCount;
        this.stars = stars;
        this.Evaluations = Evaluations;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("TourTitle", TourTitle);
        result.put("TourImage", TourImage);
        result.put("TourAddr", TourAddr);
        result.put("TourContentId", TourContentId);

        result.put("starCount", starCount);
        result.put("EvaluationCount", EvaluationCount);

        result.put("stars", stars);
        result.put("Evaluations", Evaluations);
        return result;
    }

    public String getTourTitle() {
        return TourTitle;
    }

    public void setTourTitle(String tourTitle) {
        TourTitle = tourTitle;
    }

    public String getTourImage() {
        return TourImage;
    }

    public void setTourImage(String tourImage) {
        TourImage = tourImage;
    }

    public String getTourAddr() {
        return TourAddr;
    }

    public void setTourAddr(String tourAddr) {
        TourAddr = tourAddr;
    }

    public int getTourContentId() {
        return TourContentId;
    }

    public void setTourContentId(int tourContentId) {
        TourContentId = tourContentId;
    }


    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }


    public Map<String, Boolean> getStars() {
        return stars;
    }

    public void setStars(Map<String, Boolean> stars) {
        this.stars = stars;
    }

    public Object getEvaluations() {
        return Evaluations;
    }

    public void setEvaluations(Object evaluations) {
        Evaluations = evaluations;
    }
}




