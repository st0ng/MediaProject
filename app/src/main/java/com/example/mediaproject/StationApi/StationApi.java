package com.example.mediaproject.StationApi;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StationApi {

    @SerializedName("MsrstnInfoInqireSvrVo")
    @Expose
    private MsrstnInfoInqireSvrVo msrstnInfoInqireSvrVo;
    @SerializedName("list")
    @Expose
    private java.util.List<com.example.mediaproject.StationApi.List> list = null;
    @SerializedName("parm")
    @Expose
    private Parm parm;
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;

    public MsrstnInfoInqireSvrVo getMsrstnInfoInqireSvrVo() {
        return msrstnInfoInqireSvrVo;
    }

    public void setMsrstnInfoInqireSvrVo(MsrstnInfoInqireSvrVo msrstnInfoInqireSvrVo) {
        this.msrstnInfoInqireSvrVo = msrstnInfoInqireSvrVo;
    }

    public java.util.List<com.example.mediaproject.StationApi.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.example.mediaproject.StationApi.List> list) {
        this.list = list;
    }

    public Parm getParm() {
        return parm;
    }

    public void setParm(Parm parm) {
        this.parm = parm;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}