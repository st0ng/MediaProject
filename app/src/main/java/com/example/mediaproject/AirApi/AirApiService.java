package com.example.mediaproject.AirApi;

import com.example.mediaproject.AirApi.model.AirDataRES;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AirApiService {

    @GET("rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?serviceKey=Wbxwtl8WwgmVKhpp9KzLIfEFqOJnJAOHysiyOKV9uVKu6wmZlE3Tf4h94V6%2Fg48FQmWRN2uVR2RLziOZi5vnnA%3D%3D&numOfRows=10&pageNo=1&itemCode=PM10&dataGubun=HOUR&searchCondition=MONTH&_returnType=json")
    Call<AirDataRES> getCtprvnMesureLIst();
}
