package com.example.mediaproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mediaproject.Data.LocationCodeData;
import com.example.mediaproject.R;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import androidx.recyclerview.widget.RecyclerView;


public class SearchTestAdapter extends RecyclerView.Adapter<SearchTestAdapter.ViewHolder> {

    LocationCodeData LocData = new LocationCodeData();

    int flag = 0;
    int Selected = 0;
    Context context;
    LinearLayout mParent;

    private ArrayList<String> mData = null;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView LocList;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            LocList = itemView.findViewById(R.id.LocList);
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public SearchTestAdapter(ArrayList<String> list) {
        mData = list;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public SearchTestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mParent = (LinearLayout) parent.getParent();
        context = parent.getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.test_item, parent, false);
        SearchTestAdapter.ViewHolder vh = new SearchTestAdapter.ViewHolder(view);
        return vh;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(SearchTestAdapter.ViewHolder holder, final int position) {
        String text = mData.get(position);
        holder.LocList.setText(text);

        ((ViewHolder) holder).LocList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> Locations = new ArrayList<String>();
                Chip chip1 = mParent.findViewById(R.id.chip1);
                Chip chip0 = mParent.findViewById(R.id.chip0);

                if (flag == 0) {
                    if (position == 0) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguSeoul;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("서울");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 1) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguInchun;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("인천");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 2) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguDaegeon;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("대전");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 3) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguDaegu;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("대구");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 4) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguGwangju;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("광주");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 5) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguBusan;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("부산");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 6) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguUlsan;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("울산");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 7) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguSejong;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("세종");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 8) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguGyunggi;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("경기도");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 9) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguGangwon;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("강원도");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 10) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguChungBuk;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("충청북도");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 11) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguChungNam;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("충청남도");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 12) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguGyoungBuk;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("경상북도");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 13) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguGyoungNam;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("경상남도");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 14) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguGeonBuk;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("전라북도");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 15) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguGeonNam;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("전라남도");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    } else if (position == 16) {
                        LinkedHashMap<String, Integer> map = LocData.sigunguZezu;
                        for (String key : map.keySet()) {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        chip0.setText("제주도");
                        chip0.setVisibility(View.VISIBLE);
                        flag = 1;
                    }
                } else {
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
        return mData.size();
    }


}