package com.example.mediaproject.TourApi;

public interface OnItemClick {
    void onClick(String title,
                 String addr1,
                 String addr2,
                 Integer areacode,
                 Integer booktour,
                 String cat1,
                 String cat2,
                 String cat3,
                 Integer contentid,
                 Integer contenttypeid,
                 Long createdtime,
                 String firstimage,
                 String firstimage2,
                 Double mapx,
                 Double mapy,
                 Integer mlevel,
                 Long modifiedtime,
                 Integer readcount,
                 Integer sigungucode,
                 String tel,
                 String zipcode);

    void onclick1(String title, Double mapx, Double mapy);
    void onclick2(String title);
    void onClicked(String value);

}
