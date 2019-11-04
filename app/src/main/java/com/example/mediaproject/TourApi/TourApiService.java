package com.example.mediaproject.TourApi;

import com.example.mediaproject.TourApi.Model.TourDataRES;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TourApiService {


    //지역 검색 조회
    @GET("areaBasedList?ServiceKey=xDpckfjsb8NUE5fOrIOhEu12RNJ2PRdFyomXA4a3lzRwEWQFqPvTSDM2ZU16JOGrKd73%2BlZfWUVCVmhtC6iZ6Q%3D%3D&MobileOS=AND&MobileApp=AppTest&_type=json&listYN=Y&arrange=B")
    Call<TourDataRES> getareaBasedList(@Query("listYN") String listYN,
                                       @Query("arrange") String arrange,
                                       @Query("contentTypeId") int contentTypeId,
                                       @Query("areaCode") int areaCode,
                                       @Query("numOfRows") int numOfRows,
                                       @Query("pageNo") int pageNo);

    //위치 기반 조회
    @GET("locationBasedList?serviceKey=xDpckfjsb8NUE5fOrIOhEu12RNJ2PRdFyomXA4a3lzRwEWQFqPvTSDM2ZU16JOGrKd73%2BlZfWUVCVmhtC6iZ6Q%3D%3D&MobileApp=AppTest&MobileOS=AND&_type=json")
    Call<TourDataRES> getLocationBasedList(@Query("listYN") String listYN,
                                       @Query("arrange") String arrange,
                                       @Query("numOfRows") int numOfRows,
                                       @Query("pageNo") int pageNo,
                                       @Query("mapX") double mapX,
                                       @Query("mapY") double mapY,
                                       @Query("radius") int radius);


    //키워드 검색 조회
    @GET("searchKeyword?ServiceKey=xDpckfjsb8NUE5fOrIOhEu12RNJ2PRdFyomXA4a3lzRwEWQFqPvTSDM2ZU16JOGrKd73%2BlZfWUVCVmhtC6iZ6Q%3D%3D&MobileOS=AND&MobileApp=AppTest&_type=json")
    Call<TourDataRES> getsearchKeyword(@Query("listYN") String listYN,
                                       @Query("arrange") String arrange,
                                       @Query("contentTypeId") int contentTypeId,
                                       @Query("keyword") String keyword,
                                       @Query("numOfRows") int numOfRows,
                                       @Query("pageNo") int pageNo);
}
