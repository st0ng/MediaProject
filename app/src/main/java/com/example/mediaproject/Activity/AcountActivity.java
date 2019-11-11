package com.example.mediaproject.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mediaproject.R;
import com.google.android.material.chip.Chip;

public class AcountActivity extends BaseActivity {

    Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_account);
        getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Chip chip = (Chip) findViewById(R.id.chip);
        chip.setLayoutDirection(View.LAYOUT_DIRECTION_LOCALE);
        chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click.
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        setSelected(R.id.navigation_menu4);
    }


}
