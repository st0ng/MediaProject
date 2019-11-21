package com.example.mediaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mediaproject.Data.EvaluationModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.NonNull;
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

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        EvaluationRatingBar = (RatingBar) findViewById(R.id.EvaluationRatingBar);
        EvaluationScope = (TextView) findViewById(R.id.EvaluationScope);
        EvaluationLoad = (Button) findViewById(R.id.EvaluationLoad);
        EvaluationLoad.setOnClickListener(this);

        firebaseDatabase.getReference().child("TourInfo")
                .child(title).child("Evaluations")
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    EvaluationModel get = snapshot.getValue(EvaluationModel.class);

                    if(get.Uid.equals(firebaseAuth.getCurrentUser().getUid())){
                        EvaluationRatingBar.setRating(get.TourScope);
                        int scope = get.TourScope;
                        String stringscope = String.valueOf(scope);
                        EvaluationScope.setText(stringscope);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            EvaluationRatingBar.setRating(0);
            EvaluationScope.setText(0);
            }
        });




    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.EvaluationLoad){
            EvaluationModel load = new EvaluationModel();
            load.Uid = firebaseAuth.getCurrentUser().getUid();
            int setratiog = (int) EvaluationRatingBar.getRating();
            load.TourScope = setratiog;

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a h:mm");
            Date now = new Date();
            load.date = formatter.format(now);

            firebaseDatabase.getReference().child("TourInfo").child(title).child("Evaluations/" + firebaseAuth.getCurrentUser().getUid()).setValue(load).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    finish();
                }
            });

        }
    }
}
