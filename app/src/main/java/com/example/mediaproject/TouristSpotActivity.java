package com.example.mediaproject;

import android.content.Intent;
import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

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
        String photo = intent.getExtras().getString("photo");

        ImageView Image = findViewById(R.id.SpotImage);
        TextView Title =  findViewById(R.id.TourTitle);
        TextView Addr =  findViewById(R.id.location_textview);
        TextView Dist = findViewById(R.id.distance_textview);
        TextView Tel  =  findViewById(R.id.telephone_textview);

        Glide.with(Image.getContext()).load(photo).into(Image);
        Title.setText(title);
        Addr.setText(addr);
        Dist.setText(dist);
        Tel.setText(tel);



    }

}
