package com.example.mediaproject.TourApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadTourApi {
    private static LoadTourApi ourInstance = new LoadTourApi();

    public static LoadTourApi getInstance() {
        return ourInstance;
    }

    private LoadTourApi() {
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.visitkorea.or.kr/openapi/service/rest/KorService/")
            .addConverterFactory(GsonConverterFactory.create()) // 파싱등록
            .build();

    TourApiService service = retrofit.create(TourApiService.class);

    public TourApiService getService() {
        return service;
    }
}



