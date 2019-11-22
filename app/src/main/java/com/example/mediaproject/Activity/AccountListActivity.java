package com.example.mediaproject.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mediaproject.Adapter.TourInfoAdapter;
import com.example.mediaproject.Adapter.UserTourListAdapter;
import com.example.mediaproject.Data.TourInfoData;
import com.example.mediaproject.Data.TourInfoModel;
import com.example.mediaproject.Data.UserTourListData;
import com.example.mediaproject.Data.UserTourListModel;
import com.example.mediaproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AccountListActivity extends AppCompatActivity {

    protected FirebaseStorage firebaseStorage;
    protected FirebaseDatabase firebaseDatabase;
    protected FirebaseAuth firebaseAuth;

    private RecyclerView recyclerView;
    private UserTourListAdapter userTourListAdapter;
    private TourInfoAdapter tourInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();


        recyclerView = (RecyclerView) findViewById(R.id.AcountListRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        int number = intent.getExtras().getInt("ListCheck");
        firebaseDatabase.getReference().child("TourInfo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<TourInfoData> data = new ArrayList<>();
                List<String> list = new ArrayList<>();
                data.clear();
                list.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    TourInfoModel get = snapshot.getValue(TourInfoModel.class);
                    if (get.stars.containsKey(firebaseAuth.getCurrentUser().getUid())) {
                        data.add(new TourInfoData(get.TourTitle, get.TourImage, get.TourAddr, get.TourContentId, get.starCount, get.EvaluationCount, get.stars, get.Evaluations));
                        String UidKey = snapshot.getKey();
                        list.add(UidKey);
                    }
                } //for end
                tourInfoAdapter = new TourInfoAdapter(data, list);
                recyclerView.setAdapter(tourInfoAdapter);
                tourInfoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        if (number == 0) {

        } else if (number == 1) { //heart
            firebaseDatabase.getReference().child("UserTourListImage").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    List<UserTourListData> data = new ArrayList<>();
                    List<String> UidLists = new ArrayList<>();
                    data.clear();
                    UidLists.clear();

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        UserTourListModel get = snapshot.getValue(UserTourListModel.class);

                        if (get.stars.containsKey(firebaseAuth.getCurrentUser().getUid())) {
                            data.add(new UserTourListData(get.Uid, get.UserEmail, get.ImageUri, get.ImageName, get.description, get.CreateDate, get.starCount, get.CommentCount, get.stars, get.Comments, get.Cat2, get.Cat3, get.Addr, get.Title));
                            String UidKey = snapshot.getKey();
                            UidLists.add(UidKey);
                        }
                    }
                    userTourListAdapter = new UserTourListAdapter(data, UidLists);
                    recyclerView.setAdapter(userTourListAdapter);
                    userTourListAdapter.notifyDataSetChanged();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        } else if (number == 2) {
            firebaseDatabase.getReference().child("UserTourListImage").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    List<UserTourListData> data = new ArrayList<>();
                    List<String> UidLists = new ArrayList<>();
                    data.clear();
                    UidLists.clear();

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        UserTourListModel get = snapshot.getValue(UserTourListModel.class);

                        if (get.Uid.equals(firebaseAuth.getCurrentUser().getUid())) {
                            data.add(new UserTourListData(get.Uid, get.UserEmail, get.ImageUri, get.ImageName, get.description, get.CreateDate, get.starCount, get.CommentCount, get.stars, get.Comments, get.Cat2, get.Cat3, get.Addr, get.Title));
                            String UidKey = snapshot.getKey();
                            UidLists.add(UidKey);
                        }
                    }
                    userTourListAdapter = new UserTourListAdapter(data, UidLists);
                    recyclerView.setAdapter(userTourListAdapter);
                    userTourListAdapter.notifyDataSetChanged();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        } else if (number == 3) {


        } else if (number == 4) {


        } else if (number == 5) {
//            firebaseDatabase.getReference().child("UserTourListImage").addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                        UserTourListModel get = snapshot.getValue(UserTourListModel.class);
//                        if (get.Uid.equals(firebaseAuth.getCurrentUser().getUid())) {
//
//
//
//                        }
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });

        } else {
        }


    }
}
