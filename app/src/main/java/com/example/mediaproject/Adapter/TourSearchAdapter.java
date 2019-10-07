package com.example.mediaproject.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mediaproject.Data.TourSearchData;
import com.example.mediaproject.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TourSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<TourSearchData> tourSearchData;
    private Activity activity;

    public TourSearchAdapter(ArrayList<TourSearchData> tourSearchData, Activity activity) {
        this.tourSearchData = tourSearchData;
        this.activity = activity ;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_toursearch_cv, parent, false);
        return new TourSearchHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof TourSearchHolder) {
            ((TourSearchHolder) holder).TourTitle.setText(tourSearchData.get(position).getTitle());
            ((TourSearchHolder) holder).TourAdd1.setText(tourSearchData.get(position).getAddr1());

            Glide.with(activity).load(tourSearchData.get(position)
                    .getFirstimage())
                    .into(((TourSearchHolder) holder).TourImage);
        }
    }

    @Override
    public int getItemCount() {
        return tourSearchData.size();
    }


    public static class TourSearchHolder extends RecyclerView.ViewHolder {
        TextView TourTitle;
        TextView TourAdd1;
        ImageView TourImage;

        public TourSearchHolder(@NonNull View itemView) {
            super(itemView);
            TourTitle = itemView.findViewById(R.id.TourTitle);
            TourAdd1 = itemView.findViewById(R.id.TourAdd1);
            TourImage = itemView.findViewById(R.id.TourImage);
        }
    }
}
