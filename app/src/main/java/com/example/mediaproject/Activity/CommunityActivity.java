package com.example.mediaproject.Activity;

import android.os.Bundle;
import android.util.Log;

import com.example.mediaproject.Adapter.UserTourListAdapter;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommunityActivity extends BaseActivity {

    protected FirebaseStorage firebaseStorage;
    protected FirebaseDatabase firebaseDatabase;
    protected FirebaseAuth firebaseAuth;

    private RecyclerView recyclerView;
    private UserTourListAdapter userTourListAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_community);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();


        recyclerView = (RecyclerView) findViewById(R.id.CommunityTourListRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        firebaseDatabase.getReference().child("UserTourListImage").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<UserTourListData> data = new ArrayList<>();
                List<String> UidLists = new ArrayList<>();

                data.clear();
                UidLists.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UserTourListModel get = snapshot.getValue(UserTourListModel.class);

                    data.add(new UserTourListData(get.Uid, get.UserEmail, get.ImageUri, get.ImageName, get.description, get.CreateDate, get.starCount, get.CommentCount, get.stars, get.Comments, get.Cat2, get.Cat3, get.Addr,get.Title));

                    String UidKey = snapshot.getKey();
                    UidLists.add(UidKey);
                }

                userTourListAdapter = new UserTourListAdapter(data, UidLists);
                recyclerView.setAdapter(userTourListAdapter);
                userTourListAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Database", "Failed to read value.", databaseError.toException());

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        setSelected(R.id.navigation_menu3);
    }
}



