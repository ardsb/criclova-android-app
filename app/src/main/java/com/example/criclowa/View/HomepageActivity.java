package com.example.criclowa.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.criclowa.Adapter.MatchAdapter;
import com.example.criclowa.Model.Match;
import com.example.criclowa.Model.MatchList;
import com.example.criclowa.R;
import com.example.criclowa.Services.ApiClient;
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
    private final static String API_KEY ="jAOkpmcytOgBLzmtvhzmtfOLbfP2";
    RecyclerView recyclerView;
    private MatchList MatchList;
    TextView txtScores;
    Button btnLiveScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getWeatherData();



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



              if (id ==R.id.imgProfile){

                  Toast.makeText(HomepageActivity.this,"Logout",Toast.LENGTH_SHORT).show();
                  SharedPreferences.Editor editor= sharedPreferences.edit();
                  editor.clear();
                  editor.commit();
              }
               else if (id ==R.id.imgHome){

                    Toast.makeText(HomepageActivity.this,"News and Videos",Toast.LENGTH_SHORT).show();
                }
                else if (id ==R.id.imgSetting){

//                    Toast.makeText(HomepageActivity.this,"Settings",Toast.LENGTH_SHORT).show();
                    finish();
                }
                return true;
            }
        });

//        recyclerView = findViewById(R.id.recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    private void getWeatherData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<MatchList> call = apiInterface.getMatchScore(API_KEY);

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





    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}

