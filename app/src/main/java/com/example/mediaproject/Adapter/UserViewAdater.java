package com.example.mediaproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mediaproject.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewAdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public UserViewAdater(){




    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userview_cv, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
                ImageView UserView_UserImage;
                TextView UserView_UserName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            UserView_UserImage = (ImageView) itemView.findViewById(R.id.UserView_UserImage);
            UserView_UserName = (TextView) itemView.findViewById(R.id.UserView_UserName);
        }
    }

}
