package com.example.mediaproject.TourApi;

import com.example.mediaproject.TourApi.Model.DataRES;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TourApiService {

    @GET("areaBasedList?ServiceKey=dZG7nCSzDhjEw0H%2FwKfxC1cnZ6UdSxMjTtLk9ZqOlyKK1Od86VWupWtl%2F4rROiDmPdii81fNaI1WZSfn9twUhA%3D%3D&contentTypeId=15&areaCode=4&sigunguCode=4&MobileOS=AND&MobileApp=AppTest&_type=json")
    Call<DataRES> getareaBasedList();

    @GET("areaBasedList?ServiceKey=dZG7nCSzDhjEw0H%2FwKfxC1cnZ6UdSxMjTtLk9ZqOlyKK1Od86VWupWtl%2F4rROiDmPdii81fNaI1WZSfn9twUhA%3D%3D&MobileOS=AND&MobileApp=AppTest&_type=json&listYN=Y&arrange=B")
    Call<DataRES> getareaBasedList(@Query("listYN") String listYN,
                                   @Query("arrange") String arrange,
                                   @Query("contentTypeId") int contentTypeId,
                                   @Query("areaCode") int areaCode,
                                   @Query("numOfRows") int numOfRows,
                                   @Query("pageNo") int pageNo);


}
