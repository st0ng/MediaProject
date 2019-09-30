package com.example.mediaproject.TourApi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("booktour")
    @Expose
    private Integer booktour;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rnum")
    @Expose
    private Integer rnum;
    @SerializedName("addr1")
    @Expose
    private String addr1;
    @SerializedName("addr2")
    @Expose
    private String addr2;
    @SerializedName("areacode")
    @Expose
    private Integer areacode;
    @SerializedName("cat1")
    @Expose
    private String cat1;
    @SerializedName("cat2")
    @Expose
    private String cat2;
    @SerializedName("cat3")
    @Expose
    private String cat3;
    @SerializedName("contentid")
    @Expose
    private Integer contentid;
    @SerializedName("contenttypeid")
    @Expose
    private Integer contenttypeid;
    @SerializedName("createdtime")
    @Expose
    private Long createdtime;
    @SerializedName("firstimage")
    @Expose
    private String firstimage;
    @SerializedName("firstimage2")
    @Expose
    private String firstimage2;
    @SerializedName("homepage")
    @Expose
    private String homepage;
    @SerializedName("mapx")
    @Expose
    private Double mapx;
    @SerializedName("mapy")
    @Expose
    private Double mapy;
    @SerializedName("mlevel")
    @Expose
    private Integer mlevel;
    @SerializedName("modifiedtime")
    @Expose
    private Long modifiedtime;
    @SerializedName("tel")
    @Expose
    private String tel;
    @SerializedName("telname")
    @Expose
    private String telname;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("readcount")
    @Expose
    private Integer readcount;
    @SerializedName("sigungucode")
    @Expose
    private Integer sigungucode;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("dist")
    @Expose
    private Integer dist;
    @SerializedName("originimgurl")
    @Expose
    private String originimgurl;
    @SerializedName("smallimageurl")
    @Expose
    private String smallimageurl;
    @SerializedName("imgname")
    @Expose
    private String imgname;
    @SerializedName("fldgubun")
    @Expose
    public Long fldgubun;
    @SerializedName("infoname")
    @Expose
    public String infoname;
    @SerializedName("infotext")
    @Expose
    public String infotext;
    @SerializedName("serialnum")
    @Expose
    public String serialnum;
    @SerializedName("chkbabycarriage")
    @Expose
    public String chkbabycarriage;
    @SerializedName("chkcreditcard")
    @Expose
    public String chkcreditcard;
    @SerializedName("chkpet")
    @Expose
    public String chkpet;
    @SerializedName("expguide")
    @Expose
    public String expguide;
    @SerializedName("heritage1")
    @Expose
    public Integer heritage1;
    @SerializedName("heritage2")
    @Expose
    public Integer heritage2;
    @SerializedName("heritage3")
    @Expose
    public Integer heritage3;
    @SerializedName("infocenter")
    @Expose
    public String infocenter;
    @SerializedName("parking")
    @Expose
    public String parking;
    @SerializedName("usetime")
    @Expose
    public String usetime;
    @SerializedName("agelimit")
    @Expose
    public String agelimit;
    @SerializedName("bookingplace")
    @Expose
    public String bookingplace;
    @SerializedName("discountinfofestival")
    @Expose
    public String discountinfofestival;
    @SerializedName("eventenddate")
    @Expose
    public Integer eventenddate;
    @SerializedName("eventplace")
    @Expose
    public String eventplace;
    @SerializedName("eventstartdate")
    @Expose
    public Integer eventstartdate;
    @SerializedName("placeinfo")
    @Expose
    public String placeinfo;
    @SerializedName("playtime")
    @Expose
    public String playtime;
    @SerializedName("program")
    @Expose
    public String program;
    @SerializedName("spendtimefestival")
    @Expose
    public String spendtimefestival;
    @SerializedName("sponsor1")
    @Expose
    public String sponsor1;
    @SerializedName("sponsor1tel")
    @Expose
    public String sponsor1tel;
    @SerializedName("sponsor2")
    @Expose
    public String sponsor2;
    @SerializedName("sponsor2tel")
    @Expose
    public String sponsor2tel;
    @SerializedName("subevent")
    @Expose
    public String subevent;
    @SerializedName("usetimefestival")
    @Expose
    public String usetimefestival;


    public String getAgelimit() {
        return agelimit;
    }

    public void setAgelimit(String agelimit) {
        this.agelimit = agelimit;
    }

    public String getBookingplace() {
        return bookingplace;
    }

    public void setBookingplace(String bookingplace) {
        this.bookingplace = bookingplace;
    }

    public String getDiscountinfofestival() {
        return discountinfofestival;
    }

    public void setDiscountinfofestival(String discountinfofestival) {
        this.discountinfofestival = discountinfofestival;
    }

    public Integer getEventenddate() {
        return eventenddate;
    }

    public void setEventenddate(Integer eventenddate) {
        this.eventenddate = eventenddate;
    }

    public String getEventplace() {
        return eventplace;
    }

    public void setEventplace(String eventplace) {
        this.eventplace = eventplace;
    }

    public Integer getEventstartdate() {
        return eventstartdate;
    }

    public void setEventstartdate(Integer eventstartdate) {
        this.eventstartdate = eventstartdate;
    }

    public String getPlaceinfo() {
        return placeinfo;
    }

    public void setPlaceinfo(String placeinfo) {
        this.placeinfo = placeinfo;
    }

    public String getPlaytime() {
        return playtime;
    }

    public void setPlaytime(String playtime) {
        this.playtime = playtime;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getSpendtimefestival() {
        return spendtimefestival;
    }

    public void setSpendtimefestival(String spendtimefestival) {
        this.spendtimefestival = spendtimefestival;
    }

    public String getSponsor1() {
        return sponsor1;
    }

    public void setSponsor1(String sponsor1) {
        this.sponsor1 = sponsor1;
    }

    public String getSponsor1tel() {
        return sponsor1tel;
    }

    public void setSponsor1tel(String sponsor1tel) {
        this.sponsor1tel = sponsor1tel;
    }

    public String getSponsor2() {
        return sponsor2;
    }

    public void setSponsor2(String sponsor2) {
        this.sponsor2 = sponsor2;
    }

    public String getSponsor2tel() {
        return sponsor2tel;
    }

    public void setSponsor2tel(String sponsor2tel) {
        this.sponsor2tel = sponsor2tel;
    }

    public String getSubevent() {
        return subevent;
    }

    public void setSubevent(String subevent) {
        this.subevent = subevent;
    }

    public String getUsetimefestival() {
        return usetimefestival;
    }

    public void setUsetimefestival(String usetimefestival) {
        this.usetimefestival = usetimefestival;
    }

    public String getChkbabycarriage() {
        return chkbabycarriage;
    }

    public void setChkbabycarriage(String chkbabycarriage) {
        this.chkbabycarriage = chkbabycarriage;
    }

    public String getChkcreditcard() {
        return chkcreditcard;
    }

    public void setChkcreditcard(String chkcreditcard) {
        this.chkcreditcard = chkcreditcard;
    }

    public String getChkpet() {
        return chkpet;
    }

    public void setChkpet(String chkpet) {
        this.chkpet = chkpet;
    }

    public String getExpguide() {
        return expguide;
    }

    public void setExpguide(String expguide) {
        this.expguide = expguide;
    }

    public Integer getHeritage1() {
        return heritage1;
    }

    public void setHeritage1(Integer heritage1) {
        this.heritage1 = heritage1;
    }

    public Integer getHeritage2() {
        return heritage2;
    }

    public void setHeritage2(Integer heritage2) {
        this.heritage2 = heritage2;
    }

    public Integer getHeritage3() {
        return heritage3;
    }

    public void setHeritage3(Integer heritage3) {
        this.heritage3 = heritage3;
    }

    public String getInfocenter() {
        return infocenter;
    }

    public void setInfocenter(String infocenter) {
        this.infocenter = infocenter;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }

    public Integer getBooktour() {
        return booktour;
    }

    public void setBooktour(Integer booktour) {
        this.booktour = booktour;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRnum() {
        return rnum;
    }

    public void setRnum(Integer rnum) {
        this.rnum = rnum;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public Integer getAreacode() {
        return areacode;
    }

    public void setAreacode(Integer areacode) {
        this.areacode = areacode;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public String getCat3() {
        return cat3;
    }

    public void setCat3(String cat3) {
        this.cat3 = cat3;
    }

    public Integer getContentid() {
        return contentid;
    }

    public void setContentid(Integer contentid) {
        this.contentid = contentid;
    }

    public Integer getContenttypeid() {
        return contenttypeid;
    }

    public void setContenttypeid(Integer contenttypeid) {
        this.contenttypeid = contenttypeid;
    }

    public Long getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Long createdtime) {
        this.createdtime = createdtime;
    }

    public String getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(String firstimage) {
        this.firstimage = firstimage;
    }

    public String getFirstimage2() {
        return firstimage2;
    }

    public void setFirstimage2(String firstimage2) {
        this.firstimage2 = firstimage2;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Double getMapx() {
        return mapx;
    }

    public void setMapx(Double mapx) {
        this.mapx = mapx;
    }

    public Double getMapy() {
        return mapy;
    }

    public void setMapy(Double mapy) {
        this.mapy = mapy;
    }

    public Integer getMlevel() {
        return mlevel;
    }

    public void setMlevel(Integer mlevel) {
        this.mlevel = mlevel;
    }

    public Long getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Long modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTelname() {
        return telname;
    }

    public void setTelname(String telname) {
        this.telname = telname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getReadcount() {
        return readcount;
    }

    public void setReadcount(Integer readcount) {
        this.readcount = readcount;
    }

    public Integer getSigungucode() {
        return sigungucode;
    }

    public void setSigungucode(Integer sigungucode) {
        this.sigungucode = sigungucode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getDist() {
        return dist;
    }

    public void setDist(Integer dist) {
        this.dist = dist;
    }

    public String getOriginimgurl() {
        return originimgurl;
    }

    public void setOriginimgurl(String originimgurl) {
        this.originimgurl = originimgurl;
    }

    public String getSmallimageurl() {
        return smallimageurl;
    }

    public void setSmallimageurl(String smallimageurl) {
        this.smallimageurl = smallimageurl;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public Long getFldgubun() {
        return fldgubun;
    }

    public void setFldgubun(Long fldgubun) {
        this.fldgubun = fldgubun;
    }

    public String getInfoname() {
        return infoname;
    }

    public void setInfoname(String infoname) {
        this.infoname = infoname;
    }

    public String getInfotext() {
        return infotext;
    }

    public void setInfotext(String infotext) {
        this.infotext = infotext;
    }

    public String getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(String serialnum) {
        this.serialnum = serialnum;
    }
}