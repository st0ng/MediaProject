package com.example.mediaproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mediaproject.Data.TourSearchData;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TourSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<TourSearchData> TourSearchData;
    private Context context;
    private int layoutId;


    public TourSearchAdapter(ArrayList<TourSearchData> TourSearchData, Context context, int layoutId) {
        this.TourSearchData = TourSearchData;
        this.context = context;
        this.layoutId = layoutId;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new TourSearchHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof TourSearchHolder) {

        }
    }

    @Override
    public int getItemCount() {
        return TourSearchData.size();
    }



    public static class TourSearchHolder extends RecyclerView.ViewHolder {



        public TourSearchHolder(@NonNull View itemView) {
            super(itemView);


        }
    }
}
