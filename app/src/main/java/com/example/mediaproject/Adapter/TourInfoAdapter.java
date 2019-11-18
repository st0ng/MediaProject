package com.example.mediaproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mediaproject.Data.TourInfoData;
import com.example.mediaproject.R;
import com.example.mediaproject.TouristSpotActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TourInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TourInfoData> tourInfoData;
    private List<String> UidLists;
    protected Context ThisView;



    public TourInfoAdapter(List<TourInfoData> tourInfoData, List<String> UidLists) {
        this.tourInfoData = tourInfoData;
        this.UidLists = UidLists;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_cv, parent, false);
        ThisView = parent.getContext();
        return new TourInfoHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof TourInfoHolder) {
            ((TourInfoHolder) holder).TourTitle.setText(tourInfoData.get(position).getTourTitle());
            ((TourInfoHolder) holder).TourAdd1.setText(tourInfoData.get(position).getTourAddr());

            Glide.with(((TourInfoHolder) holder).TourImage.getContext()).load(tourInfoData.get(position)
                    .getTourImage())
                    .into(((TourInfoHolder) holder).TourImage);

            ((TourInfoHolder)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ThisView, TouristSpotActivity.class);
                    intent.putExtra("contentid", tourInfoData.get(position).getTourContentId());
                    intent.putExtra("photo",tourInfoData.get(position).getTourImage());
                    intent.putExtra("title",tourInfoData.get(position).getTourTitle());
                    intent.putExtra("addr",tourInfoData.get(position).getTourAddr());
                    ThisView.startActivity(intent);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return tourInfoData.size();
    }


    public static class TourInfoHolder extends RecyclerView.ViewHolder {
        TextView TourTitle;
        TextView TourAdd1;
        ImageView TourImage;

        public TourInfoHolder(@NonNull View itemView) {
            super(itemView);
            TourTitle = itemView.findViewById(R.id.TourTitle);
            TourAdd1 = itemView.findViewById(R.id.TourAdd1);
            TourImage = itemView.findViewById(R.id.TourImage);
        }
    }
}
