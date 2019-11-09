package com.example.mediaproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mediaproject.Data.TourListSpotData;
import com.example.mediaproject.TourApi.LoadTourApi;
import com.example.mediaproject.TourApi.Model.TourDataRES;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TouristSpotActivity extends AppCompatActivity {
    ArrayList<TourListSpotData> data = new ArrayList<>();
    ImageView SpotImage;
    TextView TourTitle;
    TextView location_textview;
    TextView distance_textview;
    TextView telephone_textview;
    TextView overview_textview;




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
        int contentid = intent.getExtras().getInt("contentid");


        SpotImage = (ImageView) findViewById(R.id.SpotImage);
        TourTitle = (TextView) findViewById(R.id.TourTitle);
        location_textview = (TextView) findViewById(R.id.location_textview);
        distance_textview = (TextView) findViewById(R.id.distance_textview);
        telephone_textview = (TextView) findViewById(R.id.telephone_textview);
        overview_textview = (TextView) findViewById(R.id.overview_textview);

        Glide.with(SpotImage.getContext()).load(photo).into(SpotImage);
        TourTitle.setText(title);
        location_textview.setText(addr);
        distance_textview.setText(dist);
        telephone_textview.setText(tel);

        if(contentid != 0){
            TourInfo(contentid);
        }








    }


    public void TourInfo(int contentid){
    Call<TourDataRES> call = LoadTourApi.getInstance().getService().getDetailCommon(contentid,1,1);
    call.enqueue(new Callback<TourDataRES>() {
        @Override
        public void onResponse(Call<TourDataRES> call, Response<TourDataRES> response) {
            if(response.code() ==200){
                int size = response.body().getResponse().getBody().getItems().getItem().size(); //검색된 Api item의 수
                    data.clear();

//                data.add(new TourListSpotData(
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getAddr1(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getAddr2(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getAreacode(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getBooktour(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getCat1(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getCat2(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getCat3(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getContentid(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getContenttypeid(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getCreatedtime(),
//                        ChageHttps(response.body().getResponse().getBody().getItems().getItem().get(0).getFirstimage()),
//                        ChageHttps(response.body().getResponse().getBody().getItems().getItem().get(0).getFirstimage2()),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getHomepage(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getMapx(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getMapy(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getMlevel(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getModifiedtime(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getOverview(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getSigungucode(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getTitle(),
//                        response.body().getResponse().getBody().getItems().getItem().get(0).getZipcode()));


                if(response.body().getResponse().getBody().getItems().getItem().get(0).getAddr1() != null){
                    location_textview.setText(response.body().getResponse().getBody().getItems().getItem().get(0).getAddr1());
                }else{

                }

                if(response.body().getResponse().getBody().getItems().getItem().get(0).getOverview() != null){
                    overview_textview.setText(response.body().getResponse().getBody().getItems().getItem().get(0).getOverview());
                }else{

                }



            }
        }

        @Override
        public void onFailure(Call<TourDataRES> call, Throwable t) {

        }
    });
    } //TourInfo end

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


}
