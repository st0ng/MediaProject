package com.example.mediaproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.mediaproject.Data.TourSearchData;
import com.example.mediaproject.R;
import com.example.mediaproject.TouristSpotActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TourSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<TourSearchData> tourSearchData;
    private List<String> UidLists;
    protected Context ThisView;


    public TourSearchAdapter(ArrayList<TourSearchData> tourSearchData) {
        this.tourSearchData = tourSearchData;
    }


    public TourSearchAdapter(ArrayList<TourSearchData> tourSearchData, List<String> UidLists) {
        this.tourSearchData = tourSearchData;
        this.UidLists = UidLists;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_cv, parent, false);
        ThisView = parent.getContext();
        return new TourSearchHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof TourSearchHolder) {
            ((TourSearchHolder) holder).TourTitle.setText(tourSearchData.get(position).getTitle());
            ((TourSearchHolder) holder).TourAdd1.setText(tourSearchData.get(position).getAddr1());

            RequestOptions myOptions = new RequestOptions()
                    .fitCenter()
                    .override(85, 85);

            Glide.with(((TourSearchHolder) holder).TourImage.getContext())
                    .load(tourSearchData.get(position).getFirstimage())
                    .apply(new RequestOptions().override(75, 75))
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(15)))
                    .into(((TourSearchHolder) holder).TourImage);

            ((TourSearchHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ThisView, TouristSpotActivity.class);
                    intent.putExtra("contentid", tourSearchData.get(position).getContentid());
                    Log.d("TourSearchAdapter", tourSearchData.get(position).getContentid().toString());
                    intent.putExtra("photo", tourSearchData.get(position).getFirstimage());
                    intent.putExtra("title", tourSearchData.get(position).getTitle());
                    intent.putExtra("addr", tourSearchData.get(position).getAddr1());
                    intent.putExtra("dist",tourSearchData.get(position).getDist());
                    intent.putExtra("tel", tourSearchData.get(position).getTel());
                    intent.putExtra("mapX",tourSearchData.get(position).getMapx());
                    intent.putExtra("mapY",tourSearchData.get(position).getMapy());
                    intent.putExtra("cat2",tourSearchData.get(position).getCat2());
                    intent.putExtra("cat3",tourSearchData.get(position).getCat3());
                    ThisView.startActivity(intent);

                }
            });
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
