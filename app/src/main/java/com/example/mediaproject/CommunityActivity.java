package com.example.mediaproject;

import android.os.Bundle;

public class CommunityActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_community);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setSelected(R.id.navigation_menu3);
    }
}
