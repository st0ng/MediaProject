package com.example.mediaproject.StationApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface StationApiService {
    @GET("getMsrstnList?serviceKey=4gPP%2F8LigQhx%2FTWh0hw%2BiwdD3MrRHixuFq6XOEPlqAEZBqeJv6FlBtPG3TkSm6KlCNDi0kW%2BbmLbXR7smidcow%3D%3D&_returnType=json")
    Call<StationApi> getStation(
            @Query("numOfRows") int numofRows,
            @Query("pageNo") int pageNo,
            @Query("addr") String address

    );
}
