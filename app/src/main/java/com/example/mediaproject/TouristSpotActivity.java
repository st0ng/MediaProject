package com.example.mediaproject;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Set;

public class TouristSpotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_spot);

        Intent intent = getIntent();
        String title = intent.getExtras().getString("title");
        String addr = intent.getExtras().getString("addr");
        String dist = String.valueOf(intent.getExtras().getInt("dist")) + "m";
        String tel = intent.getExtras().getString("tel");

        TextView Title = (TextView) findViewById(R.id.TourTitle);
        TextView Addr = (TextView) findViewById(R.id.location_textview);
        TextView Dist = (TextView) findViewById(R.id.distance_textview);
        TextView Tel  = (TextView) findViewById(R.id.telephone_textview);

        Title.setText(title);
        Addr.setText(addr);
        Dist.setText(dist);
        Tel.setText(tel);



    }

}
