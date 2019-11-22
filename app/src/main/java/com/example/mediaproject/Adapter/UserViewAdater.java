package com.example.mediaproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mediaproject.Data.UserInfo;
import com.example.mediaproject.Data.UserModel;
import com.example.mediaproject.Data.UserTourListData;
import com.example.mediaproject.Data.UserTourListModel;
import com.example.mediaproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewAdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    List<String> UiList = new ArrayList<>();
    List<UserInfo> userInfos = new ArrayList<>();
    List<UserTourListData> userTourListData = new ArrayList<>();

    public UserViewAdater() {

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseDatabase.getReference().child("UserTourListImage").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UiList.clear();
                userInfos.clear();
                userTourListData.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UserTourListModel get = snapshot.getValue(UserTourListModel.class);
                    if (firebaseAuth.getCurrentUser().getUid().equals(get.Uid)) {
                        for (String Key : get.stars.keySet()) {
                            UiList.add(Key);
                        }
                    }
                } //for end


                firebaseDatabase.getReference().child("UserInfo").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            UserModel get = snapshot.getValue(UserModel.class);
                            for (int i = 0; i < UiList.size(); i++) {
                                if (get.Uid.equals(UiList.get(i))) {
//                                    userInfos.add()
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            } // onDataChange

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userview_cv, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


//        if (userInfos.get(position).getUserDisplayName() == null) {
//            ((UserViewHolder) holder).UserView_UserName.setText(userInfos.get(position).UserEmail);
//        } else {
//            ((UserViewHolder) holder).UserView_UserName.setText(userInfos.get(position).UserDisplayName);
//        }
//
//        if (userInfos.get(position).getUserImage() == null) {
//
//        } else {
//            Glide.with(holder.itemView.getContext()).load(userInfos.get(position).UserImage).into(((UserViewHolder) holder).UserView_UserImage);
//        }


    }

    @Override
    public int getItemCount() {
        return userInfos.size();
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
