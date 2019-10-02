package com.example.mediaproject.AirApi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AirDataRES {

    @SerializedName("list")
    @Expose
    public java.util.List<com.example.mediaproject.AirApi.model.List> list = null;
    @SerializedName("Parm")
    @Expose
    public Parm parm;
    @SerializedName("CtprvnMesureLIstVo")
    @Expose
    public CtprvnMesureLIstVo ctprvnMesureLIstVo;
    @SerializedName("CtprvnMesureLIstVo2")
    @Expose
    public CtprvnMesureLIstVo2 ctprvnMesureLIstVo2;
    @SerializedName("totalCount")
    @Expose
    public Integer totalCount;


    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public Parm getParm() {
        return parm;
    }

    public void setParm(Parm parm) {
        this.parm = parm;
    }

    public CtprvnMesureLIstVo getCtprvnMesureLIstVo() {
        return ctprvnMesureLIstVo;
    }

    public void setCtprvnMesureLIstVo(CtprvnMesureLIstVo ctprvnMesureLIstVo) {
        this.ctprvnMesureLIstVo = ctprvnMesureLIstVo;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public CtprvnMesureLIstVo2 getCtprvnMesureLIstVo2() {
        return ctprvnMesureLIstVo2;
    }

    public void setCtprvnMesureLIstVo2(CtprvnMesureLIstVo2 ctprvnMesureLIstVo2) {
        this.ctprvnMesureLIstVo2 = ctprvnMesureLIstVo2;
    }
}
