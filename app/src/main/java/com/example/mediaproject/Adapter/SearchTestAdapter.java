package com.example.mediaproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mediaproject.Data.LocationCodeData;
import com.example.mediaproject.R;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.internal.operators.completable.CompletableHide;


public class SearchTestAdapter extends RecyclerView.Adapter<SearchTestAdapter.ViewHolder> {

    LocationCodeData LocData = new LocationCodeData();

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
                ArrayList<String> Locations = new ArrayList<String>();
                Chip chip1 = mParent.findViewById(R.id.chip1);

                Log.d("shit", String.valueOf(position));
                if (flag == 0 ) {
                    if (position == 0) {
                        HashMap<String,Integer> map = LocData.sigunguSeoul;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 1) {
                        HashMap<String,Integer> map = LocData.sigunguInchun;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 2) {
                        HashMap<String,Integer> map = LocData.sigunguDaegeon;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 3) {
                        HashMap<String,Integer> map = LocData.sigunguDaegu;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 4) {
                        HashMap<String,Integer> map = LocData.sigunguGwangju;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 5) {
                        HashMap<String,Integer> map = LocData.sigunguBusan;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 6) {
                        HashMap<String,Integer> map = LocData.sigunguUlsan;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 7) {
                        HashMap<String,Integer> map = LocData.sigunguSejong;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 8) {
                        HashMap<String,Integer> map = LocData.sigunguGyunggi;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 9) {
                        HashMap<String,Integer> map = LocData.sigunguGangwon;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 10) {
                        HashMap<String,Integer> map = LocData.sigunguChungBuk;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 11) {
                        HashMap<String,Integer> map = LocData.sigunguChungNam;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 12) {
                        HashMap<String,Integer> map = LocData.sigunguGyoungBuk;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 13) {
                        HashMap<String,Integer> map = LocData.sigunguGyoungNam;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 14) {
                        HashMap<String,Integer> map = LocData.sigunguGeonBuk;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 15) {
                        HashMap<String,Integer> map = LocData.sigunguGeonNam;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
                        notifyDataSetChanged();
                        flag = 1;
                    } else if (position == 16) {
                        HashMap<String,Integer> map = LocData.sigunguZezu;
                        for(String key : map.keySet())
                        {
                            Locations.add(key);
                        }
                        mData = Locations;
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