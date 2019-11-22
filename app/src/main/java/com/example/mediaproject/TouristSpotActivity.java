package com.example.mediaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mediaproject.Data.EvaluationModel;
import com.example.mediaproject.Data.TourInfoData;
import com.example.mediaproject.Data.TourInfoModel;
import com.example.mediaproject.Data.TourTypeData;
import com.example.mediaproject.Data.UserTourListModel;
import com.example.mediaproject.TourApi.LoadTourApi;
import com.example.mediaproject.TourApi.Model.TourDataRES;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TouristSpotActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {

    protected FirebaseDatabase firebaseDatabase;
    protected DatabaseReference databaseReference;
    protected FirebaseAuth firebaseAuth;

    HashMap<String, Object> childUpdates = null;
    Map<String, Object> userValue = null;
    TourInfoData tourInfoData = null;
    boolean checklist = false;


    private RatingBar TourRatingBar;
    private ImageView TourUpload;
    private ImageView TourList_Heart;
    private ImageView SpotImage;
    private ImageView TourList_Survey;
    private TextView TourTitle;
    private TextView location_textview;
    private TextView location2_textview;
    private TextView distance_textview;
    private TextView telephone_textview;
    private TextView overview_textview;
    private TextView homepage_textview;
    private TextView tour_spot1;
    private TextView tour_spot2;
    private TextView TourList_HeartCount;
    private TextView TourList_SurveyCount;
    private TextView TourRatingBarScope;


    private LinearLayout location_layout;
    private LinearLayout location2_layout;
    private LinearLayout distance_layout;
    private LinearLayout telephone_layout;
    private LinearLayout overview_layout;
    private LinearLayout homepage_layout;

    private GoogleMap mMap;
    private double mX;
    private double mY;
    String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_spot);

        Intent intent = getIntent();
        title = intent.getExtras().getString("title");
        final String addr = intent.getExtras().getString("addr");
        String dist = String.valueOf(intent.getExtras().getInt("dist")) + "m";
        String tel = intent.getExtras().getString("tel");
        final String photo = intent.getExtras().getString("photo");
        final int contentid = intent.getExtras().getInt("contentid");
        mX = intent.getExtras().getDouble("mapX");
        mY = intent.getExtras().getDouble("mapY");
        String cat2_key = intent.getExtras().getString("cat2");
        String cat3_key = intent.getExtras().getString("cat3");


        TourUpload = (ImageView) findViewById(R.id.TourList_Upload);
        SpotImage = (ImageView) findViewById(R.id.SpotImage);
        TourTitle = (TextView) findViewById(R.id.TourTitle);


        location_textview = (TextView) findViewById(R.id.location_textview);
        location2_textview = (TextView) findViewById(R.id.location2_textview);
        distance_textview = (TextView) findViewById(R.id.distance_textview);
        telephone_textview = (TextView) findViewById(R.id.telephone_textview);
        overview_textview = (TextView) findViewById(R.id.overview_textview);
        homepage_textview = (TextView) findViewById(R.id.homepage_textview);
        TourList_HeartCount = (TextView) findViewById(R.id.TourList_HeartCount);
        TourList_SurveyCount = (TextView) findViewById(R.id.TourList_SurveyCount);
        TourRatingBarScope = (TextView) findViewById(R.id.TourRatingBarScope);
        tour_spot1 = findViewById(R.id.Tourspot_type1);
        tour_spot2 = findViewById(R.id.Tourspot_type2);

        TourRatingBar = (RatingBar) findViewById(R.id.TourRatingBar);
        TourRatingBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


        TourList_Survey = (ImageView) findViewById(R.id.TourList_Survey);
        TourList_Survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TouristSpotActivity.this, EvaluationActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });


        location_layout = (LinearLayout) findViewById(R.id.location_layout);
        location2_layout = (LinearLayout) findViewById(R.id.location2_layout);
        distance_layout = (LinearLayout) findViewById(R.id.distance_layout);
        telephone_layout = (LinearLayout) findViewById(R.id.telephone_layout);
        overview_layout = (LinearLayout) findViewById(R.id.overview_layout);
        homepage_layout = (LinearLayout) findViewById(R.id.telephone_layout);


        TourTypeData tourTypeData = new TourTypeData();
        HashMap<String, String> category2 = tourTypeData.Category_2;
        HashMap<String, String> category3 = tourTypeData.Category_3;
        final String cat2 = category2.get(cat2_key);
        final String cat3 = category3.get(cat3_key);
        if (cat2 != null) {
            tour_spot1.setText(cat2);
        }
        if (cat3 != null) {
            tour_spot2.setText(cat3);
        }

        TourUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TouristSpotActivity.this, CommunityTourListLoad.class);
                intent.putExtra("cat2", cat2);
                intent.putExtra("cat3", cat3);
                intent.putExtra("addr", addr);
                startActivity(intent);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);

        Glide.with(SpotImage.getContext()).load(photo).into(SpotImage);
        TourTitle.setText(title);

        if (addr != null) { //주소
            location_layout.setVisibility(View.VISIBLE);
            location_textview.setText(addr);
        } else {
            location_layout.setVisibility(View.GONE);
        }

        if (!dist.equals("0m")) { //거리
            distance_layout.setVisibility(View.VISIBLE);
            distance_textview.setText(dist);
        } else {
            distance_layout.setVisibility(View.GONE);
        }

        if (tel != null) { //전화번호
            distance_layout.setVisibility(View.VISIBLE);
            telephone_textview.setText(tel);
        } else {
            telephone_layout.setVisibility(View.GONE);
        }

        if (contentid != 0) {
            TourInfo(contentid);
        }

        firebaseDatabase.getReference().child("TourInfo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                checklist = false;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UserTourListModel get = snapshot.getValue(UserTourListModel.class);
                    String listkey = snapshot.getKey();

                    if (listkey.equals(title)) {
                        checklist = true;
                        break;
                    }

                } // for end


                if (checklist == false) {
                    childUpdates = new HashMap<>();
                    tourInfoData = new TourInfoData(title, photo, addr, contentid, 0, 0, null, null);
                    userValue = tourInfoData.toMap();

                    childUpdates.put("/TourInfo/" + title, userValue);
                    databaseReference.updateChildren(childUpdates);
                }


                firebaseDatabase.getReference().child("TourInfo").child(title).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        TourInfoModel data = dataSnapshot.getValue(TourInfoModel.class);
                        if (data.stars.containsKey(firebaseAuth.getCurrentUser().getUid())) {
                            TourList_Heart.setImageResource(R.drawable.heart);
                            String count = "좋아요 " + String.valueOf(data.starCount) + "개";
                            TourList_HeartCount.setText(count);
                        } else {
                            TourList_Heart.setImageResource(R.drawable.heart_botom);
                            String count = "좋아요 " + String.valueOf(data.starCount) + "개";
                            TourList_HeartCount.setText(count);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }); // firebase // TourInfo // title 경로 end


                firebaseDatabase.getReference().child("TourInfo").child(title).child("Evaluations").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int count = 0;
                        int sum = 0;
                        float average = 0;
                        int Q1_yes = 0, Q1_normal = 0, Q1_no = 0,
                                Q2_yes = 0, Q2_normal = 0, Q2_no = 0,
                                Q3_yes = 0, Q3_normal = 0, Q3_no = 0,
                                Q4_yes = 0, Q4_normal = 0, Q4_no = 0,
                                Q5_yes = 0, Q5_normal = 0, Q5_no = 0;

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            EvaluationModel get = snapshot.getValue(EvaluationModel.class);
                            count++;
                            sum += get.TourScope;


                            if (get.Question1.equals("예")) {
                                Q1_yes++;
                            } else if (get.Question1.equals("글쎄요")) {
                                Q1_normal++;
                            } else if (get.Question1.equals("아니요")) {
                                Q1_no++;
                            }

                            if (get.Question2.equals("예")) {
                                Q2_yes++;
                            } else if (get.Question2.equals("글쎄요")) {
                                Q2_normal++;
                            } else if (get.Question2.equals("아니요")) {
                                Q2_no++;
                            }

                            if (get.Question3.equals("예")) {
                                Q3_yes++;
                            } else if (get.Question3.equals("글쎄요")) {
                                Q3_normal++;
                            } else if (get.Question3.equals("아니요")) {
                                Q3_no++;
                            }

                            if (get.Question4.equals("예")) {
                                Q4_yes++;
                            } else if (get.Question4.equals("글쎄요")) {
                                Q4_normal++;
                            } else if (get.Question4.equals("아니요")) {
                                Q4_no++;
                            }

                            if (get.Question5.equals("예")) {
                                Q5_yes++;
                            } else if (get.Question5.equals("글쎄요")) {
                                Q5_normal++;
                            } else if (get.Question5.equals("아니요")) {
                                Q5_no++;
                            }


                        }

                        String stringcount = "평가 " + count + "개";
                        TourList_SurveyCount.setText(stringcount);

                        if (count != 0) {
                            average = ((float) sum / count);
                            average = (float) (Math.round(average * 10) / 10.0);
                            TourRatingBarScope.setText(Float.toString(average));


//                            if (0 <= average && average < 0.5) {
//                                average = 0;
//                            } else if (0.5 <= average && average < 1.0) {
//                                average = (float) 0.5;
//                            } else if (1.0 <= average && average < 1.5) {
//                                average = (float) 1.0;
//                            } else if (1.5 <= average && average < 2.0) {
//                                average = (float) 1.5;
//                            } else if (2.0 <= average && average < 2.5) {
//                                average = (float) 2.0;
//                            } else if (2.5 <= average && average < 3.0) {
//                                average = (float) 2.5;
//                            } else if (3.0 <= average && average < 3.5) {
//                                average = (float) 3.0;
//                            } else if (3.5 <= average && average < 4.0) {
//                                average = (float) 3.5;
//                            } else if (4.0 <= average && average < 4.5) {
//                                average = (float) 4.0;
//                            } else if (4.5 <= average && average < 5.0) {
//                                average = (float) 4.5;
//                            } else {
//                                average = (float) 5.0;
//                            }

                            TourRatingBar.setRating(average);

                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }); //firebase // TourInfo end


        TourList_Heart = (ImageView) findViewById(R.id.TourList_Heart);
        TourList_Heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHeartClicked(firebaseDatabase.getReference().child("TourInfo").child(title));
            }
        });


    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        LatLng spotLoc = new LatLng(mY, mX);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(spotLoc);
        markerOptions.title(title);
        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(spotLoc));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    public void TourInfo(int contentid) {
        Call<TourDataRES> call = LoadTourApi.getInstance().getService().getDetailCommon(contentid, 1, 1);
        call.enqueue(new Callback<TourDataRES>() {
            @Override
            public void onResponse(Call<TourDataRES> call, Response<TourDataRES> response) {
                if (response.code() == 200) {
                    if (response.body().getResponse().getBody().getItems().getItem().get(0).getAddr1() != null) { //주소
                        location_layout.setVisibility(View.VISIBLE);
                        location_textview.setText(response.body().getResponse().getBody().getItems().getItem().get(0).getAddr1());
                    } else {
                        location_layout.setVisibility(View.GONE);
                    }

                    if (response.body().getResponse().getBody().getItems().getItem().get(0).getAddr2() != null) {  //주소2
                        location2_layout.setVisibility(View.VISIBLE);
                        location2_textview.setText(response.body().getResponse().getBody().getItems().getItem().get(0).getAddr2());
                    } else {
                        location2_layout.setVisibility(View.GONE);
                    }

                    if (response.body().getResponse().getBody().getItems().getItem().get(0).getOverview() != null) { //개요
                        overview_layout.setVisibility(View.VISIBLE);
                        overview_textview.setText(ChageBr(response.body().getResponse().getBody().getItems().getItem().get(0).getOverview()));
                    } else {
                        overview_layout.setVisibility(View.GONE);
                    }

                    if (response.body().getResponse().getBody().getItems().getItem().get(0).getHomepage() != null) { //홈페이지
                        homepage_layout.setVisibility(View.VISIBLE);
                        homepage_textview.setText(ChageHOME(response.body().getResponse().getBody().getItems().getItem().get(0).getHomepage()));
                    } else {
                        homepage_layout.setVisibility(View.GONE);
                    }

                }// if end
            }// onResponse end

            @Override
            public void onFailure(Call<TourDataRES> call, Throwable t) {

            }
        });
    } //TourInfoData end


    public String ChageHttps(String text) {
        String trans = "";
        trans = text;
        if (trans != null) {
            trans = trans.replace("http://", "https://");
        } else {
            trans = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAKMAAAB7CAMAAAAv38DwAAAAOVBMVEX4+Pezuav7+/qvtaba3Nbz9PLQ08zm5+Pp6ue4vrGss6PDyL3w8O7Bxbrs7erT1s7JzcPf4tylrZwuo5cQAAAEK0lEQVR4nO2a3XqkIAyGJQERFIXe/8VuEpwfZ+w+bdcuHOQ76EwVy9tAAgkOg0qlUqlUKpVKpVKpVCqVSqX6PcFykGvN8y6YAh6VVmgNdRRYNC9CM/UFub4hEmRoTXUQjCeMBktXhgwniAZzD4ywy8czRoPu1qAho89JdGpGUr07b81cHJYUz6bhiT1xbMS4hK8RCmVqggjz1xEJ0jYYbpjO/eRT/X/Es5Xlr4prA8azsI0m5TEnPLkVG6yMJ4w4l7rbcfbdndB3wIim3GM1DNsrZA+MmJxA7JzgO2Q0MswwTL46B0zYHSMvd7CmSMLMJn1x/PaMuAmVqdcweG6SOmPkkS5PV1aekrEnRtkpumeimYlCV4y0GkM5GHahNhl7YiQAmJ+nX2Rq2xMjp4BwdJFNGb/PyBkgPM8+EzknfJ0ObRl59h1DDQUjyKYjRsOpwPNgS0x32BUj8iK9Pn4VZtsZ41yX63otZm7hDhlte0Zjak5lUwhhLtIgd7anIAbJBWBwzskW8jXf6YHRmOcK1PtGvA9GHN2OAbC+Jd99MBrE7Fca67XM75lhJ4ycdxnyGWPOctcWjOV7dQrZrP1vLd9CNE2KUuf15U/N2Kbu/BKk/464taqSbmeFnRNADKURIVnSefsVTUPLgjh8TQ0JVao+9BNH+G3ncXsR2e1VRl+Kd/By3+23b5/39vIMxamy7kHI7boUMdSD3rnW8Lycpxt7vz9FM8mBTeBubyUpyWhuxwnW8DOhPFcm8cqzBupMDoGEESaDMSTq8X4udGdkpIU+hJGrVHsbwsKYQkRc6Q/QHp1rqfHjYkZjFtjtSOZYaGrNDzvcGBMhEU7a7cgLepBvq8FME9KFSJYmxnB9bGdGHCsj1yNkv7o8dgo3xo0LkTnkyugoW0T5P3iPxLMAfB6djDVZ8+IFkuaj5fcjhJFGSi5CwjwcGW0gs4U01nS7xDAk3LhpkCrqbjxiDKXYYv3FjNOGqTKOWMeP9mbzK+MYFxe3rTLOBGars1WT243EY23EgWL+tMMfMjoTSz4wzu+MJZbpw1fGhc/faEJM1CAIY/hgpxGfGTPJft7jjxg9m4S7AhuN5CY8gK+MK25bdMLIJMQh85inhdhxZM+/+8yViJWRzzLYHGuUwgn4WmR8ZtyGMKcAlZHiFR/WmOrJhkI++RsyI/vML/g15SPs0BIfKXu2y1KeXuC5M9IcJYsJI/0rYyHXQE5lKEELxa0Wb3b0rHLlexYU17xMwFpXlMNfipLTI4YjM8aNuqcQOcYZqulI1aW9kWco9AtjVbwyy3E5cZxYUpJRdiPH9PywwhoShcExWJhCmsCGEegReb0HtiTFyJWLutnZtHB1bde1yeJ+mnov6AzuEILrDbh9e/x4fO6P7IezmkOoVCqVSqVSqVQqlUqlUqlU/6Y/sxooCVUeRkIAAAAASUVORK5CYII=";
        }

        return trans;
    }


    // ChageBr
    // overview 의 <br />,<br> 을 "\n"로 바꿔주기
    public String ChageBr(String text) {
        String trans;
        trans = text;
        if (trans != null) {
            trans = trans.replace("</b>", "\n");
            trans = trans.replace("<b>", "\n");
            trans = trans.replace("<br>", "\n");
            trans = trans.replace("<br />", "\n");
            trans = trans.replace("</a>", "");
        } else {

        }
        return trans;
    }


    // ChageHOME
    // html 태그 제거하기
    public String ChageHOME(String html) {
        String trans = "";
        String result = "";
        trans = html;
        String regex1 = "\\<.*?\\>";        //html 태그 제거하기 코드

        if (trans != null) {
            result = trans.replaceAll(regex1, "\n");
        } else {
        }

        return result;
    }

    private void onHeartClicked(DatabaseReference postRef) {
        postRef.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                TourInfoModel TourInfoModel = mutableData.getValue(TourInfoModel.class);
                if (TourInfoModel == null) {
                    return Transaction.success(mutableData);
                }

                if (TourInfoModel.stars.containsKey(firebaseAuth.getCurrentUser().getUid())) {
                    // Unstar the post and remove self from stars
                    TourInfoModel.starCount = TourInfoModel.starCount - 1;
                    TourInfoModel.stars.remove(firebaseAuth.getCurrentUser().getUid());
                } else {
                    // Star the post and add self to stars
                    TourInfoModel.starCount = TourInfoModel.starCount + 1;
                    TourInfoModel.stars.put(firebaseAuth.getCurrentUser().getUid(), true);
                }

                // Set value and report transaction success
                mutableData.setValue(TourInfoModel);
                return Transaction.success(mutableData);
            }


            @Override
            public void onComplete(DatabaseError databaseError, boolean b,
                                   DataSnapshot dataSnapshot) {
                // Transaction completed
            }
        });
    } //onHeartClicked end

    @Override
    public void onClick(View v) {


    }


}
