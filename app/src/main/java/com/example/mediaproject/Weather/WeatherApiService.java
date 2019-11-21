package com.example.mediaproject.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService
{
    @GET("weather?appid=bd3300ca7f92612e5e25d1f6b6b425c0")
    Call<WeatherApi> getWeather(
            @Query("lat") double latitude,
            @Query("lon") double longitude
    );
}
