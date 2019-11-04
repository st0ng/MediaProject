package com.example.mediaproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mediaproject.Adapter.UserTourListAdapter;
import com.example.mediaproject.Data.ImageData;
import com.example.mediaproject.Data.UserTourListData;
import com.example.mediaproject.Data.UserTourListModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommunityActivity extends BaseActivity {

    protected FirebaseStorage firebaseStorage;
    protected FirebaseDatabase firebaseDatabase;
    protected FirebaseAuth firebaseAuth;
    protected DatabaseReference databaseReference;

    ImageData imageData = null;

    Button CommunityTourListUploadButton;

    RecyclerView recyclerView;
    UserTourListAdapter userTourListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_community);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        final String currentid = firebaseAuth.getCurrentUser().getUid();



        CommunityTourListUploadButton = (Button) findViewById(R.id.CommunityTourListUploadButton);
        CommunityTourListUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, CommunityTourListLoad.class);
                startActivity(intent);
            }
        });




        recyclerView = (RecyclerView) findViewById(R.id.CommunityTourListRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase.getReference().child("UserTourListImage").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<UserTourListData> data = new ArrayList<>(); //데이터 받아서 adapter 에 보내줄 data 생성
                data.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String value = dataSnapshot.getValue().toString();
                    Log.d("Database", "Value is: " + value);

                    UserTourListModel get = snapshot.getValue(UserTourListModel.class);
                    data.add(new UserTourListData(get.Uid , get.UserEmail , get.ImageUri , get.description , get.CreateDate));
                }

                userTourListAdapter = new UserTourListAdapter(data);
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