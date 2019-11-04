package com.example.mediaproject.AirQuality;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface AirApiService {

    @GET("getMsrstnAcctoRltmMesureDnsty?serviceKey=4gPP%2F8LigQhx%2FTWh0hw%2BiwdD3MrRHixuFq6XOEPlqAEZBqeJv6FlBtPG3TkSm6KlCNDi0kW%2BbmLbXR7smidcow%3D%3D&_returnType=json")
    Call<Airapi> getInfo(
            @Query("numOfRows") int numofRows,
            @Query("pageNo") int pageNo,
            @Query("stationName") String stationname,
            @Query("dataTerm") String dataTerm,
            @Query("ver") double ver
    );
}
