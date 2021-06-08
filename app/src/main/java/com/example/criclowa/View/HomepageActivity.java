package com.example.criclowa.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.criclowa.Adapter.MatchAdapter;
import com.example.criclowa.Adapter.NewsAdapter;
import com.example.criclowa.Adapter.VideosAdapter;
import com.example.criclowa.Model.Match;
import com.example.criclowa.Model.MatchList;
import com.example.criclowa.Model.SportNews;
import com.example.criclowa.Model.SportNewsList;
import com.example.criclowa.Model.Item;
import com.example.criclowa.Model.SportVideosResponse;
import com.example.criclowa.R;
import com.example.criclowa.Services.ApiClient;
import com.example.criclowa.Services.ApiClientNews;
import com.example.criclowa.Services.ApiClientVideos;
import com.example.criclowa.Services.ApiInterface;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomepageActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    SharedPreferences sharedPreferences;
    String TAG = HomepageActivity.class.getSimpleName();
    private final static String API_KEY_SCORES="jAOkpmcytOgBLzmtvhzmtfOLbfP2";
    private final static String API_Key_NEWS ="fa0a460e2ca943f7bd5cf89cf16855cc";
    private final static String Country="in";
    private final static String Cat="sports";
    private final static String API_Key_VIDEOS ="AIzaSyANcGmjuaXKqU3PfhiVdyNo4GBXGFTJZto";
    private final static String chId="UCkd4takjjF1EGD1TKIK2QiA";
    private final static String part="snippet,id";
    RecyclerView recyclerView,recyclerView2,recyclerView3;
    ImageView profile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        recyclerView = findViewById(R.id.recycler);
        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(recyclerView);

        getScoreData();

        recyclerView2 = findViewById(R.id.recycler2);
        SnapHelper helper2 = new LinearSnapHelper();
        helper2.attachToRecyclerView(recyclerView2);

        getMatchNews();

        recyclerView3 = findViewById(R.id.recycler3);
        SnapHelper helper3 = new LinearSnapHelper();
        helper3.attachToRecyclerView(recyclerView3);

        getMatchVideos();







        sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        dl = (DrawerLayout)findViewById(R.id.d1);
        abdt = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view= (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              int id =item.getItemId();

                profile = findViewById(R.id.btnProfile);
                profile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent mainActivityIntent = new Intent(HomepageActivity.this, PlayerStatisticActivity.class);
                        startActivity(mainActivityIntent);
                    }
                });


              if (id ==R.id.imgProfile){

                  Intent mainActivityIntent = new Intent(HomepageActivity.this, PlayerStatisticActivity.class);
                  startActivity(mainActivityIntent);

              }
               else if (id ==R.id.imgHome){

                    Toast.makeText(HomepageActivity.this,"Home",Toast.LENGTH_SHORT).show();
                }
                else if (id ==R.id.imgLogout){

                  SharedPreferences.Editor editor= sharedPreferences.edit();
                  editor.clear();
                  editor.commit();
//

                }else if(id ==R.id.imgExit)
                  finish();

                return true;
            }
        });

//        recyclerView = findViewById(R.id.recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    private void getScoreData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<MatchList> call = apiInterface.getMatchScore(API_KEY_SCORES);

        ((Call) call).enqueue(new Callback<MatchList>() {
            @Override
            public void onResponse(Call<MatchList> call, Response<MatchList> response) {


                if (response.isSuccessful() && response.body().getData().size() > 0){
                    List<Match> matche =response.body().getData();


                    MatchAdapter adapter = new MatchAdapter(matche, R.layout.matches_layout, getApplicationContext());

                    recyclerView.setAdapter(adapter);


//                    String image_url = IMAGE_URL_BASE_PATH + response.body().getWeather().getIcon();
//                    Picasso.get().load(image_url).into(imgWeather);


                } else {
                    Toast.makeText(HomepageActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onFailure(Call<MatchList> call, Throwable t) {
                Log.e(TAG, String.format("onFailure: %s", t.getMessage()));


            }

        });


    }

    private void getMatchNews() {
        ApiInterface apiInterface = ApiClientNews.getClient().create(ApiInterface.class);

        Call<SportNewsList> call = apiInterface.getMatchNews(Country,Cat,API_Key_NEWS);

        ((Call) call).enqueue(new Callback<SportNewsList>() {
            @Override
            public void onResponse(Call<SportNewsList> call, Response<SportNewsList> response) {


                if (response.isSuccessful() && response.body().getArticle().size() > 0){
                    List<SportNews> News =response.body().getArticle();


                    NewsAdapter adapter = new NewsAdapter(News, R.layout.news_layout, getApplicationContext());

                    recyclerView2.setAdapter(adapter);


//                    String image_url = IMAGE_URL_BASE_PATH + response.body().getWeather().getIcon();
//                    Picasso.get().load(image_url).into(imgWeather);


                } else {
                    Toast.makeText(HomepageActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onFailure(Call<SportNewsList> call, Throwable t) {
                Log.e(TAG, String.format("onFailure: %s", t.getMessage()));


            }

        });



    }

    private void getMatchVideos() {
        ApiInterface apiInterface = ApiClientVideos.getClient().create(ApiInterface.class);

        Call<SportVideosResponse> call = apiInterface.getMatchVideos(API_Key_VIDEOS,chId,part);

        ((Call) call).enqueue(new Callback<SportVideosResponse>() {
            @Override
            public void onResponse(Call<SportVideosResponse> call, Response<SportVideosResponse> response) {


                SportVideosResponse body = response.body();
                if (response.isSuccessful() && body.getItem().size() > 0){
                    List<Item> videos = body.getItem();

                    Log.e(TAG, String.format("OnSuccess: %s", body.getItem()));

                    VideosAdapter adapter = new VideosAdapter(videos, R.layout.videos_layout, getApplicationContext());

                    recyclerView3.setAdapter(adapter);


//                    String image_url = IMAGE_URL_BASE_PATH + response.body().getWeather().getIcon();
//                    Picasso.get().load(image_url).into(imgWeather);


                } else {
                    Log.e(TAG, String.format("OnFailure: %s", response.message()));
                    Toast.makeText(HomepageActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onFailure(Call<SportVideosResponse> call, Throwable t) {
                Log.e(TAG, String.format("onFailure: %s", t.getMessage()));


            }

        });



    }





    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}

