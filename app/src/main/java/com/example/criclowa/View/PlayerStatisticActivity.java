package com.example.criclowa.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.criclowa.Model.PlayerStatistic;
import com.example.criclowa.R;
import com.example.criclowa.Services.ApiClient;
import com.example.criclowa.Services.ApiInterface;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerStatisticActivity extends AppCompatActivity {
    String TAG = PlayerStatisticActivity.class.getSimpleName();
    private final static String API_KEY_SCORES="jAOkpmcytOgBLzmtvhzmtfOLbfP2";
    private final static String pid="35320";
    TextView profileName,profileCountryName;
    CircleImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_statistic);

        getPlayerStatistic();
    }




    private void getPlayerStatistic() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<PlayerStatistic> call = apiInterface.getPlayerStatistic(API_KEY_SCORES,pid);

        ((Call) call).enqueue(new Callback<PlayerStatistic>() {
            @Override
            public void onResponse(Call<PlayerStatistic> call, Response<PlayerStatistic> response) {



                if (response.isSuccessful()){


                    profile=findViewById(R.id.btnProfilePictureStatistic);
                    profileName = findViewById(R.id.txtProfileNameStatistic);
                    profileCountryName= findViewById(R.id.txtProfileCountryNameStatistic);


                    profileName.setText(response.body().getPlayerName());
                    profileCountryName.setText(response.body().getCountry());
                    String image_url = response.body().getImageurl();
                    Picasso.get().load(image_url).into(profile);




                } else {
                    Log.e(TAG, String.format("OnFailure: %s", response.message()));
                    Toast.makeText(PlayerStatisticActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onFailure(Call<PlayerStatistic> call, Throwable t) {
                Log.e(TAG, String.format("onFailure: %s", t.getMessage()));


            }

        });



    }
}