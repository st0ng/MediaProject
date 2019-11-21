package com.example.mediaproject.Data;

import java.util.HashMap;

public class TourTypeData {

    public HashMap<String,String> Category_2 = new HashMap<String, String>();
    public HashMap<String,String> Category_3 = new HashMap<String, String>();

    public TourTypeData()
    {
        //중분류 시작
        Category_2.put("A0101","자연관광지");
        Category_2.put("A0102","관광자원");
        Category_2.put("A0201","역사관광지");
        Category_2.put("A0202","휴양관광지");
        Category_2.put("A0203","체험관광지");
        Category_2.put("A0204","산업관광지");
        Category_2.put("A0205","건축/조형물");
        Category_2.put("A0206","문화시설");
        Category_2.put("A0207","축제");
        Category_2.put("A0208","공연/행사");
        //추천코스는 중분류가 소분류와 같아 임시로 작성
        Category_2.put("C0112","추천코스");
        Category_2.put("C0113","추천코스");
        Category_2.put("C0114","추천코스");
        Category_2.put("C0115","추천코스");
        Category_2.put("C0116","추천코스");
        Category_2.put("C0117","추천코스");

        Category_2.put("A0301","레포츠소개");
        Category_2.put("A0302","육상레포츠");
        Category_2.put("A0303","수상레포츠");
        Category_2.put("A0304","항공레포츠");
        Category_2.put("A0305","복합레포츠");
        Category_2.put("B0201","숙박시설");
        Category_2.put("A0502","음식점");
        //중분류 끝

        //세분류 시작
        Category_3.put("A01010100","국립공원");
        Category_3.put("A01010200","도립공원");
        Category_3.put("A01010300","군립공원");
        Category_3.put("A01010400","산");
        Category_3.put("A01010500","자연생태관광지");
        Category_3.put("A01010600","자연휴양림");
        Category_3.put("A01010700","수목원");
        Category_3.put("A01010800","폭포");
        Category_3.put("A01010900","계곡");
        Category_3.put("A01011000","약수터");
        Category_3.put("A01011100","해안절경");
        Category_3.put("A01011200","해수욕장");
        Category_3.put("A01011300","섬");
        Category_3.put("A01011400","항구/포구");
        Category_3.put("A01011500","어촌");
        Category_3.put("A01011600","등대");
        Category_3.put("A01011700","호수");
        Category_3.put("A01011800","강");
        Category_3.put("A01011900","동굴");
        Category_3.put("A01020100","희귀 동/식물");
        Category_3.put("A01020200","기암괴석");

        Category_3.put("A02010100","고궁");
        Category_3.put("A02010200","성");
        Category_3.put("A02010300","문");
        Category_3.put("A02010400","고택");
        Category_3.put("A02010500","생가");
        Category_3.put("A02010600","민속마을");
        Category_3.put("A02010700","유적지/사적지");
        Category_3.put("A02010800","사찰");
        Category_3.put("A02010900","종교성지");
        Category_3.put("A02011000","안보관광");
        Category_3.put("A02020100","유원지");
        Category_3.put("A02020200","관광단지");
        Category_3.put("A02020300","온천/욕장/스파");
        Category_3.put("A02020400","이색찜질방");
        Category_3.put("A02020500","헬스투어");
        Category_3.put("A02020600","테마공원");
        Category_3.put("A02020700","공원");
        Category_3.put("A02020800","유람선/잠수함관광");
        Category_3.put("A02030100","농/산/어촌체험");
        Category_3.put("A02030200","전통체험");
        Category_3.put("A02030300","산사체험");
        Category_3.put("A02030400","이색체험");
        Category_3.put("A02030500","관광농원");
        Category_3.put("A02030600","이색거리");
        Category_3.put("A02040100","제철소");
        Category_3.put("A02040200","조선소");
        Category_3.put("A02040300","공단");
        Category_3.put("A02040400","발전소");
        Category_3.put("A02040500","광산");
        Category_3.put("A02040600","식음료");
        Category_3.put("A02040700","화학/금속");
        Category_3.put("A02040800","기타");
        Category_3.put("A02040900","전자/반도체");
        Category_3.put("A02041000","자동차");
        Category_3.put("A02050100","다리/대교");
        Category_3.put("A02050200","기념탑/기념비/전망대");
        Category_3.put("A02050300","분수");
        Category_3.put("A02050400","동상");
        Category_3.put("A02050500","터널");
        Category_3.put("A02050600","유명건물");
        Category_3.put("A02060100","박물관");
        Category_3.put("A02060200","기념관");
        Category_3.put("A02060300","전시관");
        Category_3.put("A02060400","컨벤션센터");
        Category_3.put("A02060500","미술관/회랑");
        Category_3.put("A02060600","공연장");
        Category_3.put("A02060700","문화원");
        Category_3.put("A02060800","외국문화원");
        Category_3.put("A02060900","도서관");
        Category_3.put("A02061000","대형서점");
        Category_3.put("A02061100","문화전수시설");
        Category_3.put("A02061200","영화관");
        Category_3.put("A02061300","어학당");
        Category_3.put("A02070100","문화관광축제");
        Category_3.put("A02070200","일반축제");
        Category_3.put("A02080100","전통공연");
        Category_3.put("A02080200","연극");
        Category_3.put("A02080300","뮤지컬");
        Category_3.put("A02080400","오페라");
        Category_3.put("A02080500","전시회");
        Category_3.put("A02080600","박람회");
        Category_3.put("A02080700","컨벤션");
        Category_3.put("A02080800","무용");
        Category_3.put("A02080900","클래식음악회");
        Category_3.put("A02081000","대중콘서트");
        Category_3.put("A02081100","영화");
        Category_3.put("A02081200","스포츠경기");
        Category_3.put("A02081300","기타행사");
        Category_3.put("C01120001","가족코스");
        Category_3.put("C01130001","나홀로코스");
        Category_3.put("C01140001","힐링코스");
        Category_3.put("C01150001","도보코스");
        Category_3.put("C01160001","캠핑코스");
        Category_3.put("C01170001","맛코스");
        Category_3.put("A03010100","육상레포츠");
        Category_3.put("A03010200","수상레포츠");
        Category_3.put("A03010300","항공레포츠");

        Category_3.put("A03020100","스포츠센터");
        Category_3.put("A03020200","수련시설");
        Category_3.put("A03020300","경기장");
        Category_3.put("A03020400","인라인(실내 포함)");
        Category_3.put("A03020500","자전거하이킹");
        Category_3.put("A03020600","카트");
        Category_3.put("A03020700","골프");
        Category_3.put("A03020800","경마");
        Category_3.put("A03020900","경륜");
        Category_3.put("A03021000","카지노");
        Category_3.put("A03021100","승마");
        Category_3.put("A03021200","스키/스노보드");
        Category_3.put("A03021300","스케이트");
        Category_3.put("A03021400","썰매장");
        Category_3.put("A03021500","수렵장");
        Category_3.put("A03021600","사격장");
        Category_3.put("A03021700","야영장,오토캠핑장");
        Category_3.put("A03021800","암벽등반");
        Category_3.put("A03021900","빙벽등반");
        Category_3.put("A03022000","서바이벌게임");
        Category_3.put("A03022100","ATV");
        Category_3.put("A03022200","MTB");
        Category_3.put("A03022300","오프로드");
        Category_3.put("A03022400","번지점프");
        Category_3.put("A03022500","자동차경주");
        Category_3.put("A03022600","스키(보드) 렌탈샵");
        Category_3.put("A03022700","트래킹");

        Category_3.put("A03030100","윈드서핑/제트스키");
        Category_3.put("A03030200","카악/카누");
        Category_3.put("A03030300","요트");
        Category_3.put("A03030400","스노클링/스킨스쿠버");
        Category_3.put("A03030500","민물낚시");
        Category_3.put("A03030600","바다낚시");
        Category_3.put("A03030700","수영");
        Category_3.put("A03030800","래프팅");

        Category_3.put("A03040100","스카이다이빙");
        Category_3.put("A03040200","초경량비행");
        Category_3.put("A03040300","행글라이딩/패러글라이딩");
        Category_3.put("A03040400","열기구");
        Category_3.put("A03050100","복합레포츠");

        Category_3.put("B02010100","관광호텔");
        Category_3.put("B02010200","수상관광호텔");
        Category_3.put("B02010300","전통호텔");
        Category_3.put("B02010400","가족호텔");
        Category_3.put("B02010500","콘도미니엄");
        Category_3.put("B02010600","유스호스텔");
        Category_3.put("B02010700","펜션");
        Category_3.put("B02010800","여관");
        Category_3.put("B02010900","모텔");
        Category_3.put("B02011000","민박");
        Category_3.put("B02011100","게스트하우스");
        Category_3.put("B02011200","홈스테이");
        Category_3.put("B02011300","서비스드레지던스");
        Category_3.put("B02011400","의료관광호텔");
        Category_3.put("B02011500","소형호텔");
        Category_3.put("B02011600","한옥스테이");

        Category_3.put("A04010100","5일장");
        Category_3.put("A04010200","상설시장");
        Category_3.put("A04010300","백화점");
        Category_3.put("A04010400","면세점");
        Category_3.put("A04010500","할인매장");
        Category_3.put("A04010600","전문상자");
        Category_3.put("A04010700","공예,공방");
        Category_3.put("A04010800","관광기념품점");
        Category_3.put("A04010900","특산물판매점");

        Category_3.put("A05020100","한식");
        Category_3.put("A05020200","서양식");
        Category_3.put("A05020300","일식");
        Category_3.put("A05020400","중식");
        Category_3.put("A05020500","아시아식");
        Category_3.put("A05020600","패밀리레스토랑");
        Category_3.put("A05020700","이색음식점");
        Category_3.put("A05020800","채식전문점");
        Category_3.put("A05020900","바/까페");
        Category_3.put("A05021000","클럽");
        //세분류 끝
    }
}
