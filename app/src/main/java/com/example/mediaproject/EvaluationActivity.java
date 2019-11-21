package com.example.mediaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mediaproject.Data.EvaluationModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class EvaluationActivity extends AppCompatActivity implements View.OnClickListener {
    protected FirebaseDatabase firebaseDatabase;
    protected DatabaseReference databaseReference;
    protected FirebaseAuth firebaseAuth;

    private RatingBar EvaluationRatingBar;
    private TextView EvaluationScope;
    private Button EvaluationLoad;

    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

        Intent intent = getIntent();
        title = intent.getExtras().getString("title");

        EvaluationRatingBar = (RatingBar) findViewById(R.id.EvaluationRatingBar);
        EvaluationScope = (TextView) findViewById(R.id.EvaluationScope);
        EvaluationLoad = (Button) findViewById(R.id.EvaluationLoad);
        EvaluationLoad.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.EvaluationLoad){
            EvaluationModel load = new EvaluationModel();
            load.Uid = firebaseAuth.getCurrentUser().getUid();
            load.TourScope = EvaluationRatingBar.getRating();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a h:mm");
            Date now = new Date();
            load.date = formatter.format(now);

            firebaseDatabase.getReference().child("TourInfo").child(title).child("Comments/" + firebaseAuth.getCurrentUser().getUid()).setValue(load);
            
        }
    }
}
