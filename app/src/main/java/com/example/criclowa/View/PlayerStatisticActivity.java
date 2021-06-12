package com.example.criclowa.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.criclowa.Adapter.LiveScoreAdapter;

import com.example.criclowa.Adapter.PlayersProfileAdpater;
import com.example.criclowa.Model.Matches;
import com.example.criclowa.Model.PlayerDetails;
import com.example.criclowa.Model.PlayerStatistic;
import com.example.criclowa.R;
import com.example.criclowa.Services.ApiClient;
import com.example.criclowa.Services.ApiInterface;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerStatisticActivity extends AppCompatActivity {
    String TAG = PlayerStatisticActivity.class.getSimpleName();
    private final static String API_KEY_SCORES = "jAOkpmcytOgBLzmtvhzmtfOLbfP2";
    private final static String pid = "35320";
    DatabaseReference myRef;
    List<PlayerDetails> playerDetails;
    RecyclerView recyclerView;


    TextView txtprofileName, txtprofileCountryName, txtProfileAge, txtProfileBorn, txtPlayingRole, txtMajorTeam, txtBattingStyle, txtBowlingStyle; //For Profile
    TextView txtMatchesBowling, txtInningsBowling, txtBalls, txtRunsBowling, txtWkts, txtBBI, txtBBM, txtAveBowling, txtEcon, txtSRBowling, txt4w, txt5w, txt10Bowling; //For Bowlers List A

    TextView txtMatches, txtInnings, txtNO, txtRuns, txtHS, txtAve, txtBF, txtSR, txt4s, txt6s, txtCt, txtSt, txt50, txt100; //For Batsmen List A

    TextView txtMatchesBowlingFirstClass, txtInningsBowlingFirstClass, txtBallsFirstClass, txtRunsBowlingFirstClass, txtWktsFirstClass, txtBBIFirstClass, txtBBMFirstClass, txtAveBowlingFirstClass, txtEconFirstClass, txtSRBowlingFirstClass, txt4wFirstClass, txt5wFirstClass, txt10BowlingFirstClass; //For Bowlers First Class

    TextView txtMatchesFirstClass, txtInningsFirstClass, txtNOFirstClass, txtRunsFirstClass, txtHSFirstClass, txtAveFirstClass, txtBFFirstClass, txtSRFirstClass, txt4sFirstClass, txt6sFirstClass, txtCtFirstClass, txtStFirstClass, txt50FirstClass, txt100FirstClass; //For Batsmen FirstClass

    private PlayerStatistic playerStatistic;
    CircleImageView profile;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_statistic);

        recyclerView = findViewById(R.id.reyclerviewPlayerDetails);
        playerDetails = new ArrayList<>();

        getPlayerStatistic();

        txtprofileName = findViewById(R.id.txtProfileNameStatistic);
        txtprofileCountryName = findViewById(R.id.txtProfileCountryNameStatistic);
        txtProfileAge = findViewById(R.id.txtProfileAge);
        txtProfileBorn = findViewById(R.id.txtProfileBorn);
        txtPlayingRole = findViewById(R.id.txtPlayingRole);
        txtMajorTeam = findViewById(R.id.txtMajorTeam);
        txtBattingStyle = findViewById(R.id.txtBattingStyle);
        txtBowlingStyle = findViewById(R.id.txtBowlingStyle);




        myRef = FirebaseDatabase.getInstance().getReference().child("player-details").child("-Mbw2GIKEpuqhT59taLW");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshots) {

                PlayerDetails playerDetails = dataSnapshots.getValue(PlayerDetails.class);
                String ProfileName = playerDetails.getPlayerName();
                String ProfileCountryName = playerDetails.getCountry();
                String ProfileAge = playerDetails.getCurrentAge();
                String ProfileBorn = playerDetails.getBorn();
                String PlayingRole = playerDetails.getPlayingRole();
                String MajorTeam = playerDetails.getMajorTeams();
                String BattingStyle = playerDetails.getBattingStyle();
                String BowlingStyle = playerDetails.getBowlingStyle();

                txtprofileName.setText(ProfileName);
                txtprofileCountryName.setText(ProfileCountryName);
                txtProfileAge.setText(ProfileAge);
                txtProfileBorn.setText(ProfileBorn);
                txtPlayingRole.setText(PlayingRole);
                txtMajorTeam.setText(MajorTeam);
                txtBattingStyle.setText(BattingStyle);
                txtBowlingStyle.setText(BowlingStyle);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }




    private void addingMatches(PlayerDetails matches) {

        String id = myRef.push().getKey();

        myRef.child(id).setValue(matches);

        Toast.makeText(this, "The Match has started", Toast.LENGTH_LONG).show();


    }

    private void getPlayerStatistic() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<PlayerStatistic> call = apiInterface.getPlayerStatistic(API_KEY_SCORES, pid);

        ((Call) call).enqueue(new Callback<PlayerStatistic>() {
            @Override
            public void onResponse(Call<PlayerStatistic> call, Response<PlayerStatistic> response) {


                if (response.isSuccessful()) {


                    playerStatistic = response.body();

//                  For Player Profile

//                    profile = findViewById(R.id.btnProfilePictureStatistic);
//
//                    profileName = findViewById(R.id.txtProfileNameStatistic);
//                    profileCountryName = findViewById(R.id.txtProfileCountryNameStatistic);
//                    txtProfileAge = findViewById(R.id.txtProfileAge);
//                    txtProfileBorn = findViewById(R.id.txtProfileBorn);
//                    txtPlayingRole = findViewById(R.id.txtPlayingRole);
//                    txtMajorTeam = findViewById(R.id.txtMajorTeam);
//                    txtBattingStyle = findViewById(R.id.txtBattingStyle);
//                    txtBowlingStyle = findViewById(R.id.txtBowlingStyle);


//                    profileName.setText(response.body().getPlayerName());
//                    profileCountryName.setText(response.body().getCountry());
//                    txtProfileAge.setText(response.body().getCurrentAge());
//                    txtProfileBorn.setText(response.body().getBorn());
//                    txtPlayingRole.setText(response.body().getPlayingRole());
//                    txtMajorTeam.setText(response.body().getMajorTeams());
//                    txtBattingStyle.setText(response.body().getBattingStyle());
//                    txtBowlingStyle.setText(response.body().getBowlingStyle());


//                    String image_url = response.body().getImageurl();
//                    Picasso.get().load(image_url).into(profile);

//                  For Player Bowling List A


                    txtMatchesBowling = findViewById(R.id.txtMatchesBowling);
                    txtRunsBowling = findViewById(R.id.txtRunsBowling);
                    txtInningsBowling = findViewById(R.id.txtInningsBowling);
                    txtBalls = findViewById(R.id.txtBalls);
                    txtWkts = findViewById(R.id.txtWkts);
                    txtBBI = findViewById(R.id.txtBBI);
                    txtBBM = findViewById(R.id.txtBBM);
                    txtAveBowling = findViewById(R.id.txtAveBowling);
                    txtEcon = findViewById(R.id.txtEcon);
                    txtSRBowling = findViewById(R.id.txtSRBowling);
                    txt4w = findViewById(R.id.txt4w);
                    txt5w = findViewById(R.id.txt5w);
                    txt10Bowling = findViewById(R.id.txt10Bowling);


                    txtMatchesBowling.setText(response.body().getData().getBowling().getListABowling().getMat());
                    txtInningsBowling.setText(response.body().getData().getBowling().getListABowling().getInns());
                    txtRunsBowling.setText(response.body().getData().getBowling().getListABowling().getRuns());
                    txtWkts.setText(response.body().getData().getBowling().getListABowling().getWkts());
                    txtBalls.setText(response.body().getData().getBowling().getListABowling().getBalls());
                    txtBBI.setText(response.body().getData().getBowling().getListABowling().getBBI());
                    txtBBM.setText(response.body().getData().getBowling().getListABowling().getBBM());
                    txtAveBowling.setText(response.body().getData().getBowling().getListABowling().getAve());
                    txtEcon.setText(response.body().getData().getBowling().getListABowling().getEcon());
                    txtSRBowling.setText(response.body().getData().getBowling().getListABowling().getSR());
                    txt4w.setText(response.body().getData().getBowling().getListABowling().getFourWicketsHaul());
                    txt5w.setText(response.body().getData().getBowling().getListABowling().getFiveWicketsHaul());
                    txt10Bowling.setText(response.body().getData().getBowling().getListABowling().getTenWicketsHaul());


//                  For Player Batting List A

//                    txtMatches = findViewById(R.id.txtMatches);
//                    txtInnings = findViewById(R.id.txtInnings);
//                    txtNO = findViewById(R.id.txtNO);
//                    txtRuns = findViewById(R.id.txtRuns);
//                    txtHS = findViewById(R.id.txtHS);
//                    txtAve = findViewById(R.id.txtAve);
//                    txtBF = findViewById(R.id.txtBF);
//                    txtSR = findViewById(R.id.txtSR);
//                    txt4s = findViewById(R.id.txt4s);
//                    txt6s = findViewById(R.id.txt6s);
//                    txtCt = findViewById(R.id.txtCt);
//                    txtSt = findViewById(R.id.txtSt);
//                    txt50 = findViewById(R.id.txt50);
//                    txt100 = findViewById(R.id.txt100);
//
//
//                    txtMatches.setText(response.body().getData().getBatting().getListABatting().getMatches());
//                    txtInnings.setText(response.body().getData().getBatting().getListABatting().getInnings());
//                    txtNO.setText(response.body().getData().getBatting().getListABatting().getNO());
//                    txtRuns.setText(response.body().getData().getBatting().getListABatting().getRunsBatting());
//                    txtHS.setText(response.body().getData().getBatting().getListABatting().getHS());
//                    txtAve.setText(response.body().getData().getBatting().getListABatting().getAve());
//                    txtBF.setText(response.body().getData().getBatting().getListABatting().getBF());
//                    txtSR.setText(response.body().getData().getBatting().getListABatting().getSR());
//                    txt4s.setText(response.body().getData().getBatting().getListABatting().getFours());
//                    txt6s.setText(response.body().getData().getBatting().getListABatting().getSixes());
//                    txtCt.setText(response.body().getData().getBatting().getListABatting().getCt());
//                    txtSt.setText(response.body().getData().getBatting().getListABatting().getSt());
//                    txt50.setText(response.body().getData().getBatting().getListABatting().getHalfCentury());
//                    txt100.setText(response.body().getData().getBatting().getListABatting().getCentury());

//                  For Player Bowling First Class

                    txtMatchesBowlingFirstClass = findViewById(R.id.txtMatchesBowlingFirstClass);
                    txtRunsBowlingFirstClass = findViewById(R.id.txtRunsBowlingFirstClass);
                    txtInningsBowlingFirstClass = findViewById(R.id.txtInningsBowlingFirstClass);
                    txtBallsFirstClass = findViewById(R.id.txtBallsFirstClass);
                    txtWktsFirstClass = findViewById(R.id.txtWktsFirstClass);
                    txtBBIFirstClass = findViewById(R.id.txtBBIFirstClass);
                    txtBBMFirstClass = findViewById(R.id.txtBBMFirstClass);
                    txtAveBowlingFirstClass = findViewById(R.id.txtAveBowlingFirstClass);
                    txtEconFirstClass = findViewById(R.id.txtEconFirstClass);
                    txtSRBowlingFirstClass = findViewById(R.id.txtSRBowlingFirstClass);
                    txt4wFirstClass = findViewById(R.id.txt4wFirstClass);
                    txt5wFirstClass = findViewById(R.id.txt5wFirstClass);
                    txt10BowlingFirstClass = findViewById(R.id.txt10BowlingFirstClass);


                    txtMatchesBowlingFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getMat());
                    txtInningsBowlingFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getInns());
                    txtRunsBowlingFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getRuns());
                    txtWktsFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getWkts());
                    txtBallsFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getBalls());
                    txtBBIFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getBBI());
                    txtBBMFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getBBM());
                    txtAveBowlingFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getAve());
                    txtEconFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getEcon());
                    txtSRBowlingFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getSR());
                    txt4wFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getFourWicketsHaul());
                    txt5wFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getFiveWicketsHaul());
                    txt10BowlingFirstClass.setText(response.body().getData().getBowling().getFirstClassBowling().getTenWicketsHaul());

//                    For Player Bowling First Class

//
//                    txtMatchesFirstClass = findViewById(R.id.txtMatchesFirstClass);
//                    txtInningsFirstClass = findViewById(R.id.txtInningsFirstClass);
//                    txtNOFirstClass = findViewById(R.id.txtNOFirstClass);
//                    txtRunsFirstClass = findViewById(R.id.txtRunsFirstClass);
//                    txtHSFirstClass = findViewById(R.id.txtHSFirstClass);
//                    txtAveFirstClass = findViewById(R.id.txtAveFirstClass);
//                    txtBFFirstClass = findViewById(R.id.txtBFFirstClass);
//                    txtSRFirstClass = findViewById(R.id.txtSRFirstClass);
//                    txt4sFirstClass = findViewById(R.id.txt4sFirstClass);
//                    txt6sFirstClass = findViewById(R.id.txt6sFirstClass);
//                    txtCtFirstClass = findViewById(R.id.txtCtFirstClass);
//                    txtStFirstClass = findViewById(R.id.txtStFirstClass);
//                    txt50FirstClass = findViewById(R.id.txt50FirstClass);
//                    txt100FirstClass = findViewById(R.id.txt100FirstClass);
//
//
//                    txtMatchesFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getMatches());
//                    txtInningsFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getInnings());
//                    txtNOFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getNO());
//                    txtRunsFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getRunsBatting());
//                    txtHSFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getHS());
//                    txtAveFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getAve());
//                    txtBFFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getBF());
//                    txtSRFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getSR());
//                    txt4sFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getFours());
//                    txt6sFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getSixes());
//                    txtCtFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getCt());
//                    txtStFirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getSt());
//                    txt50FirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getHalfCentury());
//                    txt100FirstClass.setText(response.body().getData().getBatting().getFirstClassBatting().getCentury());

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