package com.example.mediaproject.TourApi;

import com.example.mediaproject.TourApi.Model.TourDataRES;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TourApiService {


    //지역 검색 조회
    @GET("areaBasedList?ServiceKey=xDpckfjsb8NUE5fOrIOhEu12RNJ2PRdFyomXA4a3lzRwEWQFqPvTSDM2ZU16JOGrKd73%2BlZfWUVCVmhtC6iZ6Q%3D%3D&MobileOS=AND&MobileApp=AppTest&_type=json")
    Call<TourDataRES> getareaBasedList(@Query("listYN") String listYN,
                                       @Query("arrange") String arrange,
                                       @Query("contentTypeId") int contentTypeId,
                                       @Query("areaCode") int areaCode,
                                       @Query("numOfRows") int numOfRows,
                                       @Query("pageNo") int pageNo);

    @GET("areaBasedList?ServiceKey=xDpckfjsb8NUE5fOrIOhEu12RNJ2PRdFyomXA4a3lzRwEWQFqPvTSDM2ZU16JOGrKd73%2BlZfWUVCVmhtC6iZ6Q%3D%3D&MobileOS=AND&MobileApp=AppTest&_type=json")
    Call<TourDataRES> getareaBasedList(@Query("listYN") String listYN,
                                       @Query("arrange") String arrange,
                                       @Query("contentTypeId") int contentTypeId,
                                       @Query("areaCode") int areaCode,
                                       @Query("cat1") String cat1,
                                       @Query("numOfRows") int numOfRows,
                                       @Query("pageNo") int pageNo);

    @GET("areaBasedList?ServiceKey=xDpckfjsb8NUE5fOrIOhEu12RNJ2PRdFyomXA4a3lzRwEWQFqPvTSDM2ZU16JOGrKd73%2BlZfWUVCVmhtC6iZ6Q%3D%3D&MobileOS=AND&MobileApp=AppTest&_type=json")
    Call<TourDataRES> getareaBasedList(@Query("listYN") String listYN,
                                       @Query("arrange") String arrange,
                                       @Query("contentTypeId") int contentTypeId,
                                       @Query("areaCode") int areaCode,
                                       @Query("cat1") String cat1,
                                       @Query("cat2") String cat2,
                                       @Query("numOfRows") int numOfRows,
                                       @Query("pageNo") int pageNo);

    @GET("areaBasedList?ServiceKey=xDpckfjsb8NUE5fOrIOhEu12RNJ2PRdFyomXA4a3lzRwEWQFqPvTSDM2ZU16JOGrKd73%2BlZfWUVCVmhtC6iZ6Q%3D%3D&MobileOS=AND&MobileApp=AppTest&_type=json")
    Call<TourDataRES> getareaBasedList(@Query("listYN") String listYN,
                                       @Query("arrange") String arrange,
                                       @Query("contentTypeId") int contentTypeId,
                                       @Query("areaCode") int areaCode,
                                       @Query("sigunguCode") int sigunguCode,
                                       @Query("cat1") String cat1,
                                       @Query("cat2") String cat2,
                                       @Query("cat3") String cat3,
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

    //공통정보 조회
    @GET("detailCommon?serviceKey=Wbxwtl8WwgmVKhpp9KzLIfEFqOJnJAOHysiyOKV9uVKu6wmZlE3Tf4h94V6%2Fg48FQmWRN2uVR2RLziOZi5vnnA%3D%3D&MobileOS=ETC&MobileApp=AppTest&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&_type=json")
    Call<TourDataRES> getDetailCommon(@Query("contentId") int contentid,
                                      @Query("numOfRows") int numOfRows,
                                      @Query("pageNo") int pageNo);
}
