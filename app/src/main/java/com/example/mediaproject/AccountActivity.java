package com.example.mediaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mediaproject.Login.LoginActivityNew;

public class AccountActivity extends BaseActivity {

    Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_account);

        logOut = (Button) findViewById(R.id.logout_button);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                //LoginManager.getInstance().logOut();
                Intent intent = new Intent(AccountActivity.this, LoginActivityNew.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setSelected(R.id.navigation_menu4);
    }


}
