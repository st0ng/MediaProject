package com.example.mediaproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mediaproject.Data.UserTourListData;
import com.example.mediaproject.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserTourListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<UserTourListData> UserTourListData;


    public UserTourListAdapter(ArrayList<UserTourListData> UserTourListData) {
        this.UserTourListData = UserTourListData;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_cv, parent, false);
        return new UserTourListHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof UserTourListHolder) {
            ((UserTourListHolder) holder).CommnitiyUserEmail.setText(UserTourListData.get(position).getUserEmail());
            Glide.with(holder.itemView.getContext()).load(UserTourListData.get(position).ImageUri).into(((UserTourListHolder) holder).CommnitiyUserImage);

        }
    }

    @Override
    public int getItemCount() {
        return UserTourListData.size();
    }


    public static class UserTourListHolder extends RecyclerView.ViewHolder {
        ImageView CommnitiyUserImage;
        TextView CommnitiyUserEmail;

        public UserTourListHolder(@NonNull View itemView) {
            super(itemView);
            CommnitiyUserImage = itemView.findViewById(R.id.CommnitiyUserImage);
            CommnitiyUserEmail = itemView.findViewById(R.id.CommnitiyUserEmail);

        }
    }
}

