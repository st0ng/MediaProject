package com.example.mediaproject.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mediaproject.Login.LoginActivityNew;
import com.example.mediaproject.R;
import com.google.android.material.chip.Chip;
import com.google.firebase.auth.FirebaseAuth;

public class AcountActivity extends BaseActivity {

    Button logOut;
    LinearLayout layout;
    Context context;
    int count = 0;
    boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_account);
        getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        auth = FirebaseAuth.getInstance();
        Button logOut = (Button) findViewById(R.id.logout_button);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                //LoginManager.getInstance().logOut();
                Intent intent = new Intent(AcountActivity.this, LoginActivityNew.class);
                startActivity(intent);
                finish();
            }
        });


//        layout = (LinearLayout) findViewById(R.id.dynamic_layout);
//        Chip chip = (Chip) findViewById(R.id.chip);
//        chip.setLayoutDirection(View.LAYOUT_DIRECTION_LOCALE);
//        context = this;
//
//        chip.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View view) {
//                // Handle the click.
//                if(!clicked) {
//                    count++;
//                    Chip new_chip = new Chip(context);
//                    new_chip.setId(count);
//                    new_chip.setText("버튼" + String.valueOf(count));
//                    layout.addView(new_chip);
//                    clicked = true;
//                }
//                else{
//                    Chip new_chip = (Chip) findViewById(count);
//                    layout.removeView(new_chip);
//                    clicked = false;
//                }
//            }
//        });

//        Chip new_chip2 = new Chip(this);
//        new_chip2.setText("버튼" + String.valueOf(count));
//        layout.addView(new_chip2);
//        count++;

    }

    @Override
    protected void onResume() {
        super.onResume();
        setSelected(R.id.navigation_menu4);
    }


}
