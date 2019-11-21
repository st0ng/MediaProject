package com.example.mediaproject.Data;

import com.example.mediaproject.Weather.Weather;

import java.util.HashMap;

public class WeatherTypeData

{
    public HashMap<String,String > WeatherType = new HashMap<String, String>();
    public WeatherTypeData()
    {
        WeatherType.put("Thunderstorm","뇌우");
        WeatherType.put("Drizzle","이슬비");
        WeatherType.put("Rain","비");
        WeatherType.put("Snow","눈");
        WeatherType.put("Mist","안개");
        WeatherType.put("Smoke","연기");
        WeatherType.put("Clear","맑음");
        WeatherType.put("Clouds","흐림");
        WeatherType.put("Haze","안개");
        WeatherType.put("Fog","안개");
        WeatherType.put("Squall","돌풍");
    }

}
