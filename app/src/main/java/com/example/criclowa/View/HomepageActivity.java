package com.example.criclowa.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.criclowa.Adapter.LiveScoreAdapter;
import com.example.criclowa.Adapter.NewsAdapter;
import com.example.criclowa.Adapter.VideosAdapter;
import com.example.criclowa.Model.Matches;
import com.example.criclowa.Model.PlayerDetails;
import com.example.criclowa.Model.SportNews;
import com.example.criclowa.Model.SportNewsList;
import com.example.criclowa.Model.Item;
import com.example.criclowa.Model.SportVideosResponse;
import com.example.criclowa.R;
import com.example.criclowa.Services.ApiClientNews;
import com.example.criclowa.Services.ApiClientVideos;
import com.example.criclowa.Services.ApiInterface;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomepageActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    SharedPreferences sharedPreferences;
    String TAG = HomepageActivity.class.getSimpleName();
    private final static String API_Key_NEWS = "fa0a460e2ca943f7bd5cf89cf16855cc";
    private final static String Country = "in";
    private final static String Cat = "sports";
    private final static String API_Key_VIDEOS = "AIzaSyANcGmjuaXKqU3PfhiVdyNo4GBXGFTJZto";
    private final static String chId = "UCkd4takjjF1EGD1TKIK2QiA";
    private final static String part = "snippet,id";
    DatabaseReference myRef;
    List<Matches> matches;
    RecyclerView recyclerView, recyclerView2, recyclerView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Match Scores");//Database name


        recyclerView = findViewById(R.id.recycler);
        matches = new ArrayList<>();
        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(recyclerView);

        
        recyclerView2 = findViewById(R.id.recycler2);
        SnapHelper helper2 = new LinearSnapHelper();
        helper2.attachToRecyclerView(recyclerView2);

        getMatchNews();

        recyclerView3 = findViewById(R.id.recycler3);
        SnapHelper helper3 = new LinearSnapHelper();
        helper3.attachToRecyclerView(recyclerView3);

        getMatchVideos();


        sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        dl = (DrawerLayout) findViewById(R.id.d1);
        abdt = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();





                if (id == R.id.txtAddMatch) {

                    Intent mainActivityIntent = new Intent(HomepageActivity.this,
                            AddMatchActivity.class);
                    startActivity(mainActivityIntent);

                } else if (id == R.id.txtAddPlayerDetails) {

                    Intent mainActivityIntent = new Intent(HomepageActivity.this,
                            AddPlayerDetailActivity.class);
                    startActivity(mainActivityIntent);


                } else if (id == R.id.txtShowPlayerDetails) {

                    Intent mainActivityIntent = new Intent(HomepageActivity.this,
                            DisplayPlayersDetailsActivity.class);
                    startActivity(mainActivityIntent);

                }else if (id == R.id.txtLogout){
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.clear();
                    editor.commit();

                    Toast.makeText(HomepageActivity.this,
                            "You have successfully logout from the Criclova system",
                            Toast.LENGTH_LONG).show();


                } else if (id == R.id.txtExit)

                    finishAffinity();

                return true;
            }
        });

//


    }


    @Override
    protected void onStart() {
        super.onStart();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                matches.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Matches match = postSnapshot.getValue(Matches.class);

                    matches.add(match);
                }

                if (matches.size() > 0) {

                    LiveScoreAdapter LiveScoreAdapter = new LiveScoreAdapter
                            (HomepageActivity.this, matches);

                    LiveScoreAdapter adapter = new LiveScoreAdapter
                            (HomepageActivity.this, matches);


                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }




    private void getMatchNews() {
        ApiInterface apiInterface = ApiClientNews.getClient().create(ApiInterface.class);

        Call<SportNewsList> call = apiInterface.getMatchNews(Country, Cat, API_Key_NEWS);

        ((Call) call).enqueue(new Callback<SportNewsList>() {
            @Override
            public void onResponse(Call<SportNewsList> call, Response<SportNewsList> response) {


                if (response.isSuccessful() && response.body().getArticle().size() > 0) {
                    List<SportNews> News = response.body().getArticle();


                    NewsAdapter adapter = new NewsAdapter(News, R.layout.news_layout,
                            getApplicationContext());

                    recyclerView2.setAdapter(adapter);

                } else {
                    Toast.makeText(HomepageActivity.this, response.message(),
                            Toast.LENGTH_SHORT).show();
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

        Call<SportVideosResponse> call = apiInterface.getMatchVideos(API_Key_VIDEOS, chId, part);

        ((Call) call).enqueue(new Callback<SportVideosResponse>() {
            @Override
            public void onResponse(Call<SportVideosResponse> call,
                                   Response<SportVideosResponse> response) {


                SportVideosResponse body = response.body();
                if (response.isSuccessful() && body.getItem().size() > 0) {
                    List<Item> videos = body.getItem();

                    Log.e(TAG, String.format("OnSuccess: %s", body.getItem()));

                    VideosAdapter adapter = new VideosAdapter(videos, R.layout.videos_layout,
                            getApplicationContext());

                    recyclerView3.setAdapter(adapter);


//


                } else {
                    Log.e(TAG, String.format("OnFailure: %s", response.message()));
                    Toast.makeText(HomepageActivity.this, response.message(),
                            Toast.LENGTH_SHORT).show();
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

