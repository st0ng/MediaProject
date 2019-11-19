package com.example.mediaproject.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LocationCodeData
{
    public LinkedHashMap<String, Integer> provinceCode = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguSeoul = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguInchun = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguDaegeon = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguDaegu = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguGwangju = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguBusan = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguUlsan = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguSejong = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguGyunggi = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguGangwon = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguChungBuk = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguChungNam = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguGyoungBuk = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguGyoungNam = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguGeonBuk = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguGeonNam = new LinkedHashMap<String, Integer>();
    public LinkedHashMap<String, Integer> sigunguZezu = new LinkedHashMap<String, Integer>();
    public LocationCodeData()
    {
        //지역코드
        provinceCode.put("서울",1);
        provinceCode.put("인천",2);
        provinceCode.put("대전",3);
        provinceCode.put("대구",4);
        provinceCode.put("광주",5);
        provinceCode.put("부산",6);
        provinceCode.put("울산",7);
        provinceCode.put("세종",8);
        provinceCode.put("경기도",31);
        provinceCode.put("강원도",32);
        provinceCode.put("충청북도",33);
        provinceCode.put("충청남도",34);
        provinceCode.put("경상북도",35);
        provinceCode.put("경상남도",36);
        provinceCode.put("전라북도",37);
        provinceCode.put("전라남도",38);
        provinceCode.put("제주도",39);

        //서울 시군구
        sigunguSeoul.put("강남구",1);
        sigunguSeoul.put("강동구",2);
        sigunguSeoul.put("강북구",3);
        sigunguSeoul.put("강서구",4);
        sigunguSeoul.put("관악구",5);
        sigunguSeoul.put("광진구",6);
        sigunguSeoul.put("구로구",7);
        sigunguSeoul.put("금천구",8);
        sigunguSeoul.put("노원구",9);
        sigunguSeoul.put("도봉구",10);
        sigunguSeoul.put("동대문구",11);
        sigunguSeoul.put("동작구",12);
        sigunguSeoul.put("마포구",13);
        sigunguSeoul.put("서대문구",14);
        sigunguSeoul.put("서초구",15);
        sigunguSeoul.put("성동구",16);
        sigunguSeoul.put("성북구",17);
        sigunguSeoul.put("송파구",18);
        sigunguSeoul.put("양천구",19);
        sigunguSeoul.put("영등포구",20);
        sigunguSeoul.put("용산구",21);
        sigunguSeoul.put("은평구",22);
        sigunguSeoul.put("종로구",23);
        sigunguSeoul.put("중구",24);
        sigunguSeoul.put("중랑구",25);

        //인천 시군구
        sigunguInchun.put("강화군",1);
        sigunguInchun.put("계약구",2);
        sigunguInchun.put("미추홀구",3);
        sigunguInchun.put("남동구",4);
        sigunguInchun.put("동구",5);
        sigunguInchun.put("부평구",6);
        sigunguInchun.put("서구",7);
        sigunguInchun.put("연수구",8);
        sigunguInchun.put("옹진군",9);
        sigunguInchun.put("중구",10);

        //대전 시군구코드
        sigunguDaegeon.put("대덕구",1);
        sigunguDaegeon.put("동구",2);
        sigunguDaegeon.put("서구",3);
        sigunguDaegeon.put("유성구",4);
        sigunguDaegeon.put("중구",5);

        //대구 시군구코드
        sigunguDaegu.put("남구",1);
        sigunguDaegu.put("달서구",2);
        sigunguDaegu.put("달성군",3);
        sigunguDaegu.put("동구",4);
        sigunguDaegu.put("북구",5);
        sigunguDaegu.put("서구",6);
        sigunguDaegu.put("수성구",7);
        sigunguDaegu.put("중구",8);

        //광주 시군구코드
        sigunguGwangju.put("광산구",1);
        sigunguGwangju.put("남구",2);
        sigunguGwangju.put("동구",3);
        sigunguGwangju.put("북구",4);
        sigunguGwangju.put("서구",5);

        //부산 시군구코드
        sigunguBusan.put("강서구",1);
        sigunguBusan.put("금정구",2);
        sigunguBusan.put("기장군",3);
        sigunguBusan.put("남구",4);
        sigunguBusan.put("동구",5);
        sigunguBusan.put("동래구",6);
        sigunguBusan.put("부산진구",7);
        sigunguBusan.put("북구",8);
        sigunguBusan.put("사상구",9);
        sigunguBusan.put("사하구",10);
        sigunguBusan.put("서구",11);
        sigunguBusan.put("수영구",12);
        sigunguBusan.put("연제구",13);
        sigunguBusan.put("영도구",14);
        sigunguBusan.put("중구",15);
        sigunguBusan.put("해운대구",16);

        //울산 시군구코드
        sigunguUlsan.put("중구",1);
        sigunguUlsan.put("남구",2);
        sigunguUlsan.put("동구",3);
        sigunguUlsan.put("북구",4);
        sigunguUlsan.put("울주군",5);

        //세종 시군구코드
        sigunguSejong.put("세종시",1);

        //경기도 시군구코드
        sigunguGyunggi.put("가평군",1);
        sigunguGyunggi.put("고양시",2);
        sigunguGyunggi.put("과천시",3);
        sigunguGyunggi.put("광명시",4);
        sigunguGyunggi.put("광주시",5);
        sigunguGyunggi.put("구리시",6);
        sigunguGyunggi.put("군포시",7);
        sigunguGyunggi.put("김포시",8);
        sigunguGyunggi.put("남양주시",9);
        sigunguGyunggi.put("동두천시",10);
        sigunguGyunggi.put("부천시",11);
        sigunguGyunggi.put("성남시",12);
        sigunguGyunggi.put("수원시",13);
        sigunguGyunggi.put("시흥시",14);
        sigunguGyunggi.put("안산시",15);
        sigunguGyunggi.put("안성시",16);
        sigunguGyunggi.put("안양시",17);
        sigunguGyunggi.put("양주시",18);
        sigunguGyunggi.put("양평군",19);
        sigunguGyunggi.put("여주시",20);
        sigunguGyunggi.put("연천군",21);
        sigunguGyunggi.put("오산시",22);
        sigunguGyunggi.put("용인시",23);
        sigunguGyunggi.put("의왕시",24);
        sigunguGyunggi.put("의정부시",25);
        sigunguGyunggi.put("이천시",26);
        sigunguGyunggi.put("파주시",27);
        sigunguGyunggi.put("평택시",28);
        sigunguGyunggi.put("포천시",29);
        sigunguGyunggi.put("하남시",30);
        sigunguGyunggi.put("화성시",31);

        //강원도 시군구코드
        sigunguGangwon.put("강릉시",1);
        sigunguGangwon.put("고성군",2);
        sigunguGangwon.put("동해시",3);
        sigunguGangwon.put("삼척시",4);
        sigunguGangwon.put("속초시",5);
        sigunguGangwon.put("양구군",6);
        sigunguGangwon.put("양양군",7);
        sigunguGangwon.put("영월군",8);
        sigunguGangwon.put("원주시",9);
        sigunguGangwon.put("인제군",10);
        sigunguGangwon.put("정선군",11);
        sigunguGangwon.put("철원군",12);
        sigunguGangwon.put("춘천시",13);
        sigunguGangwon.put("태백시",14);
        sigunguGangwon.put("평창군",15);
        sigunguGangwon.put("홍천군",16);
        sigunguGangwon.put("화천군",17);
        sigunguGangwon.put("횡성군",18);

        //충북 시군구코드
        sigunguChungBuk.put("괴산군",1);
        sigunguChungBuk.put("단양군",2);
        sigunguChungBuk.put("보은군",3);
        sigunguChungBuk.put("영동군",4);
        sigunguChungBuk.put("옥천군",5);
        sigunguChungBuk.put("음성군",6);
        sigunguChungBuk.put("제천시",7);
        sigunguChungBuk.put("진천군",8);
        sigunguChungBuk.put("청원군",9);
        sigunguChungBuk.put("청주시",10);
        sigunguChungBuk.put("충주시",11);
        sigunguChungBuk.put("증평군",12);

        //충남 시군구코드
        sigunguChungNam.put("공주시",1);
        sigunguChungNam.put("금산군",2);
        sigunguChungNam.put("논산시",3);
        sigunguChungNam.put("당진시",4);
        sigunguChungNam.put("보령시",5);
        sigunguChungNam.put("부여군",6);
        sigunguChungNam.put("서산시",7);
        sigunguChungNam.put("서천군",8);
        sigunguChungNam.put("아산시",9);
        sigunguChungNam.put("예산군",11);
        sigunguChungNam.put("천안시",12);
        sigunguChungNam.put("청양군",13);
        sigunguChungNam.put("태안군",14);
        sigunguChungNam.put("흥성군",15);
        sigunguChungNam.put("계룡시",16);

        //경북 시군구코드
        sigunguGyoungBuk.put("경산시",1);
        sigunguGyoungBuk.put("경주시",2);
        sigunguGyoungBuk.put("고령군",3);
        sigunguGyoungBuk.put("구미시",4);
        sigunguGyoungBuk.put("군위군",5);
        sigunguGyoungBuk.put("김천시",6);
        sigunguGyoungBuk.put("문경시",7);
        sigunguGyoungBuk.put("봉화군",8);
        sigunguGyoungBuk.put("상주시",9);
        sigunguGyoungBuk.put("성주군",10);
        sigunguGyoungBuk.put("안동시",11);
        sigunguGyoungBuk.put("영덕군",12);
        sigunguGyoungBuk.put("영양군",13);
        sigunguGyoungBuk.put("영주시",14);
        sigunguGyoungBuk.put("영천시",15);
        sigunguGyoungBuk.put("예천군",16);
        sigunguGyoungBuk.put("울릉군",17);
        sigunguGyoungBuk.put("울진군",18);
        sigunguGyoungBuk.put("의성군",19);
        sigunguGyoungBuk.put("청도군",20);
        sigunguGyoungBuk.put("청송군",21);
        sigunguGyoungBuk.put("칠곡군",22);
        sigunguGyoungBuk.put("포항시",23);

        //경남 시군구코드
        sigunguGyoungNam.put("거제시",1);
        sigunguGyoungNam.put("고창군",2);
        sigunguGyoungNam.put("고성군",3);
        sigunguGyoungNam.put("김해시",4);
        sigunguGyoungNam.put("남해군",5);
        sigunguGyoungNam.put("마산시",6);
        sigunguGyoungNam.put("밀양시",7);
        sigunguGyoungNam.put("사천시",8);
        sigunguGyoungNam.put("산청군",9);
        sigunguGyoungNam.put("양산시",10);
        sigunguGyoungNam.put("의령군",12);
        sigunguGyoungNam.put("진주시",13);
        sigunguGyoungNam.put("진해시",14);
        sigunguGyoungNam.put("창녕군",15);
        sigunguGyoungNam.put("창원시",16);
        sigunguGyoungNam.put("통영시",17);
        sigunguGyoungNam.put("하동군",18);
        sigunguGyoungNam.put("함안군",19);
        sigunguGyoungNam.put("함양군",20);
        sigunguGyoungNam.put("합천군",21);

        //전북 시군구코드
        sigunguGeonBuk.put("고창군",1);
        sigunguGeonBuk.put("군산시",2);
        sigunguGeonBuk.put("김제시",3);
        sigunguGeonBuk.put("남원시",4);
        sigunguGeonBuk.put("무주군",5);
        sigunguGeonBuk.put("부안군",6);
        sigunguGeonBuk.put("순창군",7);
        sigunguGeonBuk.put("완주군",8);
        sigunguGeonBuk.put("익산시",9);
        sigunguGeonBuk.put("임실군",10);
        sigunguGeonBuk.put("장수군",11);
        sigunguGeonBuk.put("전주시",12);
        sigunguGeonBuk.put("정읍시",13);
        sigunguGeonBuk.put("진안군",14);

        //전남 시군구코드
        sigunguGeonNam.put("강진군",1);
        sigunguGeonNam.put("고흥군",2);
        sigunguGeonNam.put("곡성군",3);
        sigunguGeonNam.put("광양시",4);
        sigunguGeonNam.put("구례군",5);
        sigunguGeonNam.put("나주시",6);
        sigunguGeonNam.put("담양군",7);
        sigunguGeonNam.put("목포시",8);
        sigunguGeonNam.put("무안군",9);
        sigunguGeonNam.put("보성군",10);
        sigunguGeonNam.put("순천시",11);
        sigunguGeonNam.put("신안군",12);
        sigunguGeonNam.put("여수시",13);
        sigunguGeonNam.put("영광군",16);
        sigunguGeonNam.put("영암군",17);
        sigunguGeonNam.put("완도군",18);
        sigunguGeonNam.put("장성군",19);
        sigunguGeonNam.put("장흥군",20);
        sigunguGeonNam.put("진도군",21);
        sigunguGeonNam.put("함평군",22);
        sigunguGeonNam.put("해남군",23);
        sigunguGeonNam.put("화순군",24);

        //제주 시군구코드
        sigunguZezu.put("남제주군",1);
        sigunguZezu.put("북제주군",1);
        sigunguZezu.put("서귀포시",1);
        sigunguZezu.put("제주시",1);

    }












}
