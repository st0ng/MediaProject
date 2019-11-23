package com.example.mediaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class EvaluationActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    protected FirebaseDatabase firebaseDatabase;
    protected DatabaseReference databaseReference;
    protected FirebaseAuth firebaseAuth;

    private RatingBar EvaluationRatingBar;
    private TextView EvaluationScope;
    private Button EvaluationLoad;

    private RadioGroup Question1;
    private RadioGroup Question2;
    private RadioGroup Question3;
    private RadioGroup Question4;
    private RadioGroup Question5;

    private RadioButton Question1_yes;
    private RadioButton Question1_normal;
    private RadioButton Question1_no;
    private RadioButton Question2_yes;
    private RadioButton Question2_normal;
    private RadioButton Question2_no;
    private RadioButton Question3_yes;
    private RadioButton Question3_normal;
    private RadioButton Question3_no;
    private RadioButton Question4_yes;
    private RadioButton Question4_normal;
    private RadioButton Question4_no;
    private RadioButton Question5_yes;
    private RadioButton Question5_normal;
    private RadioButton Question5_no;

    private String Question1_result;
    private String Question2_result;
    private String Question3_result;
    private String Question4_result;
    private String Question5_result;


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

        Question1 = (RadioGroup) findViewById(R.id.Question1);
        Question1.setOnCheckedChangeListener(this);
        Question2 = (RadioGroup) findViewById(R.id.Question2);
        Question2.setOnCheckedChangeListener(this);
        Question3 = (RadioGroup) findViewById(R.id.Question3);
        Question3.setOnCheckedChangeListener(this);
        Question4 = (RadioGroup) findViewById(R.id.Question4);
        Question4.setOnCheckedChangeListener(this);
        Question5 = (RadioGroup) findViewById(R.id.Question5);
        Question5.setOnCheckedChangeListener(this);


        Question1_yes = (RadioButton) findViewById(R.id.Question1_yes);
        Question1_normal = (RadioButton) findViewById(R.id.Question1_normal);
        Question1_no = (RadioButton) findViewById(R.id.Question1_no);
        Question2_yes = (RadioButton) findViewById(R.id.Question2_yes);
        Question2_normal = (RadioButton) findViewById(R.id.Question2_normal);
        Question2_no = (RadioButton) findViewById(R.id.Question2_no);
        Question3_yes = (RadioButton) findViewById(R.id.Question3_yes);
        Question3_normal = (RadioButton) findViewById(R.id.Question3_normal);
        Question3_no = (RadioButton) findViewById(R.id.Question3_no);
        Question4_yes = (RadioButton) findViewById(R.id.Question4_yes);
        Question4_normal = (RadioButton) findViewById(R.id.Question4_normal);
        Question4_no = (RadioButton) findViewById(R.id.Question4_no);
        Question5_yes = (RadioButton) findViewById(R.id.Question5_yes);
        Question5_normal = (RadioButton) findViewById(R.id.Question5_normal);
        Question5_no = (RadioButton) findViewById(R.id.Question5_no);


        EvaluationRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               String count = String.valueOf(rating);
                EvaluationScope.setText(count);
            }
        });


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

                        String Q1 = "";
                        String Q2 = "";
                        String Q3 = "";
                        String Q4 = "";
                        String Q5 = "";

                        Q1 = get.Question1;
                        Q2 = get.Question2;
                        Q3 = get.Question3;
                        Q4 = get.Question4;
                        Q5 = get.Question5;

                        if(Q1 != ""){
                            if(get.Question1.equals("예")){
                                Question1_yes.setChecked(true);
                            }else if(get.Question1.equals("글쎄요")) {
                                Question1_normal.setChecked(true);
                            }else if(get.Question1.equals("아니요")){
                                Question1_no.setChecked(true);
                            }
                        }

                        if(Q2 != ""){
                            if(get.Question2.equals("예")){
                                Question2_yes.setChecked(true);
                            }else if(get.Question2.equals("글쎄요")) {
                                Question2_normal.setChecked(true);
                            }else if(get.Question2.equals("아니요")){
                                Question2_no.setChecked(true);
                            }
                        }

                        if(Q3 != ""){
                            if(get.Question3.equals("예")){
                                Question3_yes.setChecked(true);
                            }else if(get.Question3.equals("글쎄요")) {
                                Question3_normal.setChecked(true);
                            }else if(get.Question3.equals("아니요")){
                                Question3_no.setChecked(true);
                            }
                        }

                        if(Q4 != ""){
                            if(get.Question4.equals("예")){
                                Question4_yes.setChecked(true);
                            }else if(get.Question4.equals("글쎄요")) {
                                Question4_normal.setChecked(true);
                            }else if(get.Question4.equals("아니요")){
                                Question4_no.setChecked(true);
                            }
                        }

                        if(Q5 != ""){
                            if(get.Question5.equals("예")){
                                Question5_yes.setChecked(true);
                            }else if(get.Question5.equals("글쎄요")) {
                                Question5_normal.setChecked(true);
                            }else if(get.Question5.equals("아니요")){
                                Question5_no.setChecked(true);
                            }
                        }


                    } //if end
                } //for end
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
            load.Question1 = Question1_result;
            load.Question2 = Question2_result;
            load.Question3 = Question3_result;
            load.Question4 = Question4_result;
            load.Question5 = Question5_result;

            firebaseDatabase.getReference().child("TourInfo").child(title).child("Evaluations/" + firebaseAuth.getCurrentUser().getUid()).setValue(load).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    finish();
                }
            });

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.Question1_yes){
            Question1_result = "예";
        }else if (checkedId == R.id.Question1_normal){
            Question1_result = "글쎄요";
        }else if (checkedId == R.id.Question1_no){
            Question1_result = "아니요";
        }else if (checkedId == R.id.Question2_yes){
            Question2_result = "예";
        }else if (checkedId == R.id.Question2_normal){
            Question2_result = "글쎄요";
        }else if (checkedId == R.id.Question2_no){
            Question2_result = "아니요";
        }else if (checkedId == R.id.Question3_yes){
            Question3_result = "예";
        }else if (checkedId == R.id.Question3_normal){
            Question3_result = "글쎄요";
        }else if (checkedId == R.id.Question3_no){
            Question3_result = "아니요";
        }else if (checkedId == R.id.Question4_yes){
            Question4_result = "예";
        }else if (checkedId == R.id.Question4_normal){
            Question4_result = "글쎄요";
        }else if (checkedId == R.id.Question4_no){
            Question4_result = "아니요";
        }else if (checkedId == R.id.Question5_yes){
            Question5_result = "예";
        }else if (checkedId == R.id.Question5_normal){
            Question5_result = "글쎄요";
        }else if (checkedId == R.id.Question5_no){
            Question5_result = "아니요";
        }else{

        }
    }
}
