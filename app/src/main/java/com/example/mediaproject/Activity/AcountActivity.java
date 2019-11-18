package com.example.mediaproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mediaproject.AccountListActivity;
import com.example.mediaproject.Data.TourInfoModel;
import com.example.mediaproject.Data.UserTourListModel;
import com.example.mediaproject.R;
import com.example.mediaproject.UpdateUserInfo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import androidx.annotation.NonNull;

public class AcountActivity extends BaseActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseStorage firebaseStorage;
    private DatabaseReference databaseReference;

    private TextView TourLost_Myheart_count;
    private TextView TourInfo_Myheart_count;
    private LinearLayout Account_SelectedTourList;
    private LinearLayout Account_SelectedHeartList;
    private ImageView UserImage;

    private Button Update_UserInfoButton;
    Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_account);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        TourLost_Myheart_count = (TextView) findViewById(R.id.TourLost_Myheart_count);
        TourInfo_Myheart_count = (TextView) findViewById(R.id.TourInfo_Myheart_count);
        Account_SelectedTourList = (LinearLayout) findViewById(R.id.Account_SelectedTourList);
        Account_SelectedHeartList = (LinearLayout) findViewById(R.id.Account_SelectedHeartList);
        Update_UserInfoButton = (Button) findViewById(R.id.Update_UserInfo);

        Update_UserInfoButton.setOnClickListener(this);
        Account_SelectedTourList.setOnClickListener(this);
        Account_SelectedHeartList.setOnClickListener(this);

        UserImage = (ImageView) findViewById(R.id.AccountUserImage);
//        GradientDrawable drawable = (GradientDrawable) this.getDrawable(R.drawable.backfround_rounding);
//        UserImage.setBackground(drawable);
//        UserImage.setClipToOutline(true);
//        UserImage.setBackground(new ShapeDrawable(new OvalShape()));
//        UserImage.setClipToOutline(true);

        firebaseDatabase.getReference().child("UserTourListImage").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int UserTourListCount = 0 ;
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    UserTourListModel get = snapshot.getValue(UserTourListModel.class);

                    if(get.stars.containsKey(firebaseAuth.getCurrentUser().getUid())){
                        UserTourListCount ++;
                    }
                }
                String count = String.valueOf(UserTourListCount);
                TourLost_Myheart_count.setText(count);

                firebaseDatabase.getReference().child("TourInfo").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int TourInfocount = 0;
                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            TourInfoModel get = snapshot.getValue(TourInfoModel.class);

                            if(get.stars.containsKey(firebaseAuth.getCurrentUser().getUid())){
                                TourInfocount ++;
                            }
                        }
                        String count = String.valueOf(TourInfocount);
                        TourInfo_Myheart_count.setText(count);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        TourInfo_Myheart_count.setText("0");
                    }
                });
            } // UserTourListImage end

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                TourLost_Myheart_count.setText("0");
            }
        });




    }//Oncreate end

    @Override
    protected void onResume() {
        super.onResume();
        setSelected(R.id.navigation_menu4);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.Account_SelectedTourList){
            Intent intent = new Intent(AcountActivity.this, AccountListActivity.class);
            intent.putExtra("ListCheck" , 0 );
            startActivity(intent);
        }else if (v.getId() == R.id.Account_SelectedHeartList){
            Intent intent = new Intent(AcountActivity.this, AccountListActivity.class);
            intent.putExtra("ListCheck" , 1);
            startActivity(intent);
        }else if (v.getId() == R.id.Update_UserInfo){
            Intent intent = new Intent(AcountActivity.this , UpdateUserInfo.class);
            startActivity(intent);
        }

    }//onclick end
}//AcountActivity end
