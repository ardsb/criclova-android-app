package com.example.criclowa.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.criclowa.Model.PlayerDetails;
import com.example.criclowa.R;
import com.example.criclowa.Services.ApiClient;
import com.example.criclowa.Services.ApiInterface;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_statistic);

        recyclerView = findViewById(R.id.reyclerviewPlayerDetails);
        playerDetails = new ArrayList<>();


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

}