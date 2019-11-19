package com.example.mediaproject.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.mediaproject.Data.UserInfo;
import com.example.mediaproject.Data.UserModel;
import com.example.mediaproject.Login.LoginActivity;
import com.example.mediaproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    protected DatabaseReference DBresgerce = null;
    protected FirebaseDatabase firebaseDatabase;

    private boolean UserDataCheck = false;


    HashMap<String, Object> UserDataUpdate = null;
    Map<String, Object> UserValue = null;
    UserInfo UserInfo = null;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int prevNav = getSelectedNav();
            int currentNav = item.getItemId();
            if (currentNav == prevNav)
                return false;
            switch (item.getItemId()) {
                case R.id.navigation_menu1:
                    if (prevNav != R.id.navigation_menu1)
                        finish();
                    Intent ii = new Intent(BaseActivity.this, RecommendActivity.class);
                    startActivity(ii);
//                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_menu2:
                    if (prevNav != R.id.navigation_menu2)
                        finish();
                    Intent ii2 = new Intent(BaseActivity.this, SearchActivity.class);
                    startActivity(ii2);
//                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_menu3:
                    if (prevNav != R.id.navigation_menu3)
                        finish();
                    Intent ii3 = new Intent(BaseActivity.this, CommunityActivity.class);
                    startActivity(ii3);
//                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_menu4:
                    if (prevNav != R.id.navigation_menu4)
                        finish();
                    Intent ii4 = new Intent(BaseActivity.this, AccountActivity.class);
                    startActivity(ii4);
//                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        }

    };

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        } else {
            auth = FirebaseAuth.getInstance();
            final FirebaseUser currentUser = auth.getCurrentUser();
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.getReference().child("UserInfo").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserDataCheck = false;
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        UserModel get = snapshot.getValue(UserModel.class);
                        if (currentUser.getUid().contains(get.Uid)) {
                            UserDataCheck = true;
                        }
                    }

                    if (UserDataCheck == false) {
                        DBresgerce = FirebaseDatabase.getInstance().getReference();
                        UserDataUpdate = new HashMap<>();

                        UserInfo = new UserInfo(currentUser.getUid(), currentUser.getEmail(), null, null, null, currentUser.getProviderId(), currentUser.getDisplayName(), null);
                        UserValue = UserInfo.toMap();

                        UserDataUpdate.put("/UserInfo/" + currentUser.getUid(), UserValue);
                        DBresgerce.updateChildren(UserDataUpdate);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

//            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE} , 10) ;
        }


        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public View setContentLayout(int layoutID) {
        FrameLayout contentLayout = (FrameLayout) findViewById(R.id.ContentLayout);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(layoutID, contentLayout, true);
    }

    public void setSelected(int optionID) {
        navigationView.getMenu().findItem(optionID).setChecked(true);
        getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putInt("selectedNav", optionID).commit();
    }

    public int getSelectedNav() {
        return getSharedPreferences(getPackageName(), MODE_PRIVATE).getInt("selectedNav", R.id.navigation_menu1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

}