package com.example.mediaproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.example.mediaproject.Adapter.TourSearchAdapter;
import com.example.mediaproject.AirApi.AirApiService;
import com.example.mediaproject.AirApi.LoadAirApi;
import com.example.mediaproject.AirApi.model.AirDataRES;
import com.example.mediaproject.Data.TourSearchData;
import com.example.mediaproject.TourApi.LoadTourApi;
import com.example.mediaproject.TourApi.Model.TourDataRES;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //MainActivity 변수선언
    public BottomNavigationView bottomNavigationView;
    Activity activity = this;



    //SearchActivity 변수 선언
    SearchView searchView;
    RecyclerView recyclerView;
    TourSearchAdapter TourSearchAdapter;




    //AcountActivity 변수 선언
    Button button; // Test bottom


    @Override
    protected void onStart() {
        super.onStart();
        updateNavigationBarState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        if (getContentViewId() == R.layout.activity_recommend) { // Recommend Activity


        } else if (getContentViewId() == R.layout.activity_search) { // Search Activity

            searchView = findViewById(R.id.TourSearchView);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    KeywordTourSearch(query);
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

            recyclerView = (RecyclerView) findViewById(R.id.TourSearchRecyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            TourSearch();
            AirSearch();

        } else if (getContentViewId() == R.layout.activity_community) { // Community Activity




        } else if (getContentViewId() == R.layout.activity_acount) { // Acount Activity

            button = (Button) findViewById(R.id.button1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });



        } else {

        }


    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {
        bottomNavigationView.postDelayed(new Runnable() {
            @Override
            public void run() {
                int itemId = menuItem.getItemId();
                Intent intent = null;
                if (itemId == R.id.navigation_menu1) {
                    intent = new Intent(MainActivity.this, RecommendActivity.class);
                } else if (itemId == R.id.navigation_menu2) {
                    intent = new Intent(MainActivity.this, SearchActivity.class);
                } else if (itemId == R.id.navigation_menu3) {
                    intent = new Intent(MainActivity.this, CommunityActivity.class);
                } else if (itemId == R.id.navigation_menu4) {
                    intent = new Intent(MainActivity.this, AcountActivity.class);
                } else {

                }
                startActivity(intent);
                overridePendingTransition(0, 0); //Activity에서 Activity로 화면 이동 시 애니매이션 효과 없애기
                finish();
            }
        }, 300);
        return true;

    }


    private void updateNavigationBarState() {
        int actionId = getNavigationMenuItemId();
        selectBottomNavigationBarItem(actionId);
    }

    void selectBottomNavigationBarItem(int itemId) {
        MenuItem item = bottomNavigationView.getMenu().findItem(itemId);
        item.setChecked(true);
    }

    abstract int getContentViewId();

    abstract int getNavigationMenuItemId();


    public void AirSearch() {
        AirApiService airApiService = LoadAirApi.getClient().create(AirApiService.class);
        Call<AirDataRES> call = airApiService.getCtprvnMesureLIst();
        call.enqueue(new Callback<AirDataRES>() {
            @Override
            public void onResponse(Call<AirDataRES> call, Response<AirDataRES> response) {
                Log.d("main", "연결됨");
            }

            @Override
            public void onFailure(Call<AirDataRES> call, Throwable t) {
                Log.d("mainactivity_AIR", "연결안됨");
                Log.d("mainactivity_AIR", t.getMessage());
                Log.d("mainactivity_AIR", t.getMessage());
                Log.d("mainactivity_AIR", t.toString());
            }
        });

    }

    public void TourSearch() {
        Call<TourDataRES> call = LoadTourApi.getInstance().getService().getareaBasedList();
        call.enqueue(new Callback<TourDataRES>() {
            @Override
            public void onResponse(Call<TourDataRES> call, Response<TourDataRES> response) {
                if (response.code() == 200) {
                    Log.d("MainActivity_TourSearch", response.body().getResponse().getHeader().getResultMsg());

                    int size = response.body().getResponse().getBody().getItems().getItem().size(); //검색된 Api item의 수
                    ArrayList<TourSearchData> data = new ArrayList<>(); //데이터 받아서 adapter 에 보내줄 data 생성

                    for (int i = 0; i < size; i++) {
                        data.add(new TourSearchData(
                                response.body().getResponse().getBody().getItems().getItem().get(i).getTitle(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getAddr1(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getAddr2(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getAreacode(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getBooktour(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getCat1(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getCat2(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getCat3(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getContentid(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getContenttypeid(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getCreatedtime(),
                                ChageHttps(response.body().getResponse().getBody().getItems().getItem().get(i).getFirstimage()),
                                ChageHttps(response.body().getResponse().getBody().getItems().getItem().get(i).getFirstimage2()),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getMapx(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getMapy(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getMlevel(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getModifiedtime(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getReadcount(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getSigungucode(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getTel(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getZipcode()
                        ));
                    }
                    TourSearchAdapter = new TourSearchAdapter(data, activity);
                    recyclerView.setAdapter(TourSearchAdapter);
                    TourSearchAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TourDataRES> call, Throwable t) {
                Log.d("mainactivity", "연결안됨");
                t.fillInStackTrace();
            }
        });
    }

    public void KeywordTourSearch(String query){
        String keyword = "";
        keyword = query.trim();

        Call<TourDataRES> call = LoadTourApi.getInstance().getService().getsearchKeyword("Y", "A", 12, keyword, 999, 1);
        call.enqueue(new Callback<TourDataRES>() {
            @Override
            public void onResponse(Call<TourDataRES> call, Response<TourDataRES> response) {
                if (response.code() == 200) {
                    Log.d("MainActivity_KeywordTourSearch", response.body().getResponse().getHeader().getResultMsg());

                    int size = response.body().getResponse().getBody().getItems().getItem().size(); //검색된 Api item의 수
                    ArrayList<TourSearchData> data = new ArrayList<>(); //데이터 받아서 adapter 에 보내줄 data 생성
                    
                    for (int i = 0; i < size; i++) {
                        data.add(new TourSearchData(
                                response.body().getResponse().getBody().getItems().getItem().get(i).getTitle(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getAddr1(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getAddr2(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getAreacode(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getBooktour(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getCat1(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getCat2(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getCat3(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getContentid(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getContenttypeid(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getCreatedtime(),
                                ChageHttps(response.body().getResponse().getBody().getItems().getItem().get(i).getFirstimage()),
                                ChageHttps(response.body().getResponse().getBody().getItems().getItem().get(i).getFirstimage2()),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getMapx(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getMapy(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getMlevel(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getModifiedtime(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getReadcount(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getSigungucode(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getTel(),
                                response.body().getResponse().getBody().getItems().getItem().get(i).getZipcode()
                        ));
                    }
                    TourSearchAdapter = new TourSearchAdapter(data, activity);
                    recyclerView.setAdapter(TourSearchAdapter);
                    TourSearchAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TourDataRES> call, Throwable t) {

            }
        });



    }



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
