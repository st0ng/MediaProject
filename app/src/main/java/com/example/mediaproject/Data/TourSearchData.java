package com.example.mediaproject.Data;

public class TourSearchData {
    private int dist;
    private String addr1;
    private String addr2;
    private Integer areacode;
    private Integer booktour;
    private String cat1;
    private String cat2;
    private String cat3;
    private Integer contentid;
    private Integer contenttypeid;
    private Long createdtime;
    private String firstimage;
    private String firstimage2;
    private Double mapx;
    private Double mapy;
    private Integer mlevel;
    private Long modifiedtime;
    private Integer readcount;
    private Integer sigungucode;
    private String tel;
    private String title;
    private String zipcode;
    private Integer rating;
    private Integer count;
    private String id;
    private Integer checkbox;


    public TourSearchData(int dist , String title, String addr1, String addr2, Integer areacode, Integer booktour,
                          String cat1, String cat2, String cat3, Integer contentid, Integer contenttypeid,
                          Long createdtime, String firstimage, String firstimage2, Double mapx, Double mapy,
                          Integer mlevel, Long modifiedtime, Integer readcount, Integer sigungucode, String tel, String zipcode) {

        this.dist = dist;
        this.title = title;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.areacode = areacode;
        this.booktour = booktour;
        this.cat1 = cat1;
        this.cat2 = cat2;
        this.cat3 = cat3;
        this.contentid = contentid;
        this.contenttypeid = contenttypeid;
        this.createdtime = createdtime;
        this.firstimage = firstimage;
        this.firstimage2 = firstimage2;
        this.mapx = mapx;
        this.mapy = mapy;
        this.mlevel = mlevel;
        this.modifiedtime = modifiedtime;
        this.readcount = readcount;
        this.sigungucode = sigungucode;
        this.tel = tel;
        this.zipcode = zipcode;
    }

    public TourSearchData(String title, String addr1, String addr2, Integer areacode, Integer booktour,
                          String cat1, String cat2, String cat3, Integer contentid, Integer contenttypeid,
                          Long createdtime, String firstimage, String firstimage2, Double mapx, Double mapy,
                          Integer mlevel, Long modifiedtime, Integer readcount, Integer sigungucode, String tel, String zipcode) {

        this.title = title;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.areacode = areacode;
        this.booktour = booktour;
        this.cat1 = cat1;
        this.cat2 = cat2;
        this.cat3 = cat3;
        this.contentid = contentid;
        this.contenttypeid = contenttypeid;
        this.createdtime = createdtime;
        this.firstimage = firstimage;
        this.firstimage2 = firstimage2;
        this.mapx = mapx;
        this.mapy = mapy;
        this.mlevel = mlevel;
        this.modifiedtime = modifiedtime;
        this.readcount = readcount;
        this.sigungucode = sigungucode;
        this.tel = tel;
        this.zipcode = zipcode;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
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

    public Integer getBooktour() {
        return booktour;
    }

    public void setBooktour(Integer booktour) {
        this.booktour = booktour;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(Integer checkbox) {
        this.checkbox = checkbox;
    }
}
