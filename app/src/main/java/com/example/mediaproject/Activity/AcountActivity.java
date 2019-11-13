package com.example.mediaproject.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediaproject.Adapter.SearchTestAdapter;
import com.example.mediaproject.R;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.Arrays;

public class AcountActivity extends BaseActivity{

    Button logOut;

    //관광공사 광역시 코드
    ArrayList<String> provinceCode = new ArrayList<String>(
            Arrays.asList("서울","인천","대전","대구","광주","부산","울산","세종",
                    "경기도","강원도","충청북도","충청남도","경상북도","경상남도","전라북도","전라남도","제주도")
    );




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_account);
        getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//        Chip chip = (Chip) findViewById(R.id.chip);
//        chip.setLayoutDirection(View.LAYOUT_DIRECTION_LOCALE);
//        chip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Handle the click.
//            }
//        });

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.SearchTestView) ;

        recyclerView.setLayoutManager(new GridLayoutManager(this,4)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        SearchTestAdapter adapter = new SearchTestAdapter(provinceCode) ;
        recyclerView.setAdapter(adapter);



    }

    @Override
    protected void onResume() {
        super.onResume();
        setSelected(R.id.navigation_menu4);
    }




}
