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

    //지역 검색 조회
    @GET("areaBasedList?serviceKey=xDpckfjsb8NUE5fOrIOhEu12RNJ2PRdFyomXA4a3lzRwEWQFqPvTSDM2ZU16JOGrKd73%2BlZfWUVCVmhtC6iZ6Q%3D%3D&pageNo=1&numOfRows=10&MobileApp=AppTest&MobileOS=ETC&arrange=A&contentTypeId=15&areaCode=4&sigunguCode=4&listYN=Y&_type=json")
    Call<TourDataRES> getareaBasedList();

    //키워드 검색 조회
    @GET("searchKeyword?ServiceKey=xDpckfjsb8NUE5fOrIOhEu12RNJ2PRdFyomXA4a3lzRwEWQFqPvTSDM2ZU16JOGrKd73%2BlZfWUVCVmhtC6iZ6Q%3D%3D&MobileOS=AND&MobileApp=AppTest&_type=json")
    Call<TourDataRES> getsearchKeyword(@Query("listYN") String listYN,
                                       @Query("arrange") String arrange,
                                       @Query("contentTypeId") int contentTypeId,
                                       @Query("keyword") String keyword,
                                       @Query("numOfRows") int numOfRows,
                                       @Query("pageNo") int pageNo);
}
