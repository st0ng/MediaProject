package com.example.mediaproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mediaproject.R;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import io.reactivex.internal.operators.completable.CompletableHide;


public class SearchTestAdapter extends RecyclerView.Adapter<SearchTestAdapter.ViewHolder> {


    //서울 시군구코드
    ArrayList<String> sigunguSeoul = new ArrayList<String>(
            Arrays.asList("강남구","강동구", "강북구", "강서구", "관악구", "광진구",
                    "구로구", "금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구", "중구","중랑구"
            )
    );
    //인천 시군구코드
    ArrayList<String> sigunguInchun = new ArrayList<String>(
            Arrays.asList("강화군","계양구","미추홀구","남동구","동구","부평구","서구","연수구","옹진군","중구"
            )
    );
    //대전 시군구코드
    ArrayList<String> sigunguDaegeon = new ArrayList<String>(
            Arrays.asList("대덕구","동구", "서구","유성구","중구"
            )
    );
    //대구 시군구코드
    ArrayList<String> sigunguDaegu = new ArrayList<String>(
            Arrays.asList( "남구","달서구","달성군","동구","북구","서구","수성구","중구"
            )
    );
    //광주 시군구코드
    ArrayList<String> sigunguGwangju = new ArrayList<String>(
            Arrays.asList("광산구","남구","동구","북구","서구"
            )
    );
    //부산 시군구코드
    ArrayList<String> sigunguBusan = new ArrayList<String>(
            Arrays.asList("강서구","금정구","기장군","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구"
            )
    );
    //울산 시군구코드
    ArrayList<String> sigunguUlsan = new ArrayList<String>(
            Arrays.asList( "중구","남구","동구","북구","울주군"
            )
    );
    //세종시 시군구코드
    ArrayList<String> sigunguSejong = new ArrayList<String>(
            Arrays.asList( "세종시"
            )
    );
    //경기도 시군구코드
    ArrayList<String> sigunguGyunggi = new ArrayList<String>(
            Arrays.asList( "가평군","고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시",
                    "안산시","안성시","안양시","양주시","양평군","여주시","연천군","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시"
            )
    );
    //강원도 시군구코드
    ArrayList<String> sigunguGangwon = new ArrayList<String>(
            Arrays.asList( "강릉시","고성군","동해시","삼척시","속초시","양구군","양양군","영월군","원주시",
                    "인제군","정선군","철원군","춘천시","태백시","평창군","홍천군","화천군","횡성군"
            )
    );
    //충북 시군구코드
    ArrayList<String> sigunguChungBuk = new ArrayList<String>(
            Arrays.asList( "괴산군","단양군","보은군","영동군","옥천군","음성군","제천시","진천군","청원군","청주시","충주시","증평군"
            )
    );
    //충남 시군구코드
    ArrayList<String> sigunguChungNam = new ArrayList<String>(
            Arrays.asList( "공주시","금산군","논산시","당진시","보령시","부여군","서산시","서천군","아산시",

                    "예산군","천안시","청양군","태안군","흥성군","계룡시"
            )
    );
    //경북 시군구코드
    ArrayList<String> sigunguGyoungBuk = new ArrayList<String>(
            Arrays.asList("경산시","경주시","고령군","구미시","군위군","김천시","문경시","봉화군","상주시","성주군","안동시","영덕군","영양군",

                    "영주시","영천시","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군","포항시"
            )
    );
    //경남 시군구코드
    ArrayList<String> sigunguGyoungNam = new ArrayList<String>(
            Arrays.asList("거제시","고창군","고성군","김해시","남해군","마산시","밀양시","사천시","산청군","양산시",

                    "의령군","진주시","진해시","창녕군","창원시","통영시","하동군","함안군","함양군","합천군"

            )
    );
    //전북 시군구코드
    ArrayList<String> sigunguGeonBuk = new ArrayList<String>(
            Arrays.asList("고창군","군산시","김제시","남원시","무주군","부안군","순창군","완주군","익산시","임실군","장수군","전주시","정읍시","진안군"
            )
    );
    //전남 시군구코드
    ArrayList<String> sigunguGeonNam = new ArrayList<String>(
            Arrays.asList("강진군","고흥군","곡성군","광양시","구례군","나주시","담양군","목포시","무안군","보성군","순천시","신안군","여수시",
                    "영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"
            )
    );
    //제주 시군구코드
    ArrayList<String> sigunguZezu = new ArrayList<String>(
            Arrays.asList( "남제주군","북제주군","서귀포시","제주시"
            )
    );


    int flag = 0;
    int Selected = 0;
    Context context;
    LinearLayout mParent;

    private ArrayList<String> mData = null ;
    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView LocList ;
        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            LocList = itemView.findViewById(R.id.LocList) ;
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public SearchTestAdapter(ArrayList<String> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public SearchTestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mParent = (LinearLayout) parent.getParent();
        context = parent.getContext() ;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.test_item, parent, false) ;
        SearchTestAdapter.ViewHolder vh = new SearchTestAdapter.ViewHolder(view) ;
        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(SearchTestAdapter.ViewHolder holder, final int position) {
        String text = mData.get(position);
        if(text.equals("")){
            holder.LocList.setVisibility(View.GONE);
        }
        else
        {
            holder.LocList.setText(text) ;
        }

        ((ViewHolder) holder).LocList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Chip chip1 = mParent.findViewById(R.id.chip1);

                Log.d("shit", String.valueOf(position));
                if (flag == 0 ) {
                    if (position == 0) {
                        mData = sigunguSeoul;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 1) {
                        mData = sigunguInchun;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 2) {
                        mData = sigunguDaegeon;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 3) {
                        mData = sigunguDaegu;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 4) {
                        mData = sigunguGwangju;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 5) {
                        mData = sigunguBusan;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 6) {
                        mData = sigunguUlsan;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 7) {
                        mData = sigunguSejong;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 8) {
                        mData = sigunguGyunggi;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 9) {
                        mData = sigunguGangwon;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 10) {
                        mData = sigunguChungBuk;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 11) {
                        mData = sigunguChungNam;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 12) {
                        mData = sigunguGyoungBuk;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 13) {
                        mData = sigunguGyoungNam;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 14) {
                        mData = sigunguGeonBuk;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 15) {
                        mData = sigunguGeonNam;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 16) {
                        mData = sigunguZezu;
                        notifyDataSetChanged();
                        flag = 1;
                    }
                }
                else {
                    Selected = 1;
                    //holder.LocList.isClickable(false);
                    chip1.setText(mData.get(position));
                    chip1.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }


}