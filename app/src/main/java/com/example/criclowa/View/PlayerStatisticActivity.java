package com.example.criclowa.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.criclowa.Model.PlayerDetails;
import com.example.criclowa.R;
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

    TextView txtprofileName, txtprofileCountryName, txtProfileAge, txtProfileBorn, txtPlayingRole,
            txtMajorTeam, txtBattingStyle, txtBowlingStyle; //For Profile

    TextView txtMatchesBowlingPassing,txtInningsBowlingPassing,txtBallPassing,txtWktsPassing,
            txt4wPassing,txt5wPassing,txtAveBowlingPassing,txtEconPassing; //For Bowling Statistic

    TextView txtMatches,txtInnings,txtRuns,txtHS,txtAve,txtSR,txt50,txt100,txt4s,txt6s;
            //For Batting Statistic

    DatabaseReference myRef;
    Button btndelete;
    CircleImageView imageView;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_statistic);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("player-details");

        PlayerDetails playerDetails = (PlayerDetails) getIntent().getSerializableExtra
                ("Player Details");



        //For Profile
        txtprofileName = findViewById(R.id.txtProfileNameStatistic);
        txtprofileCountryName = findViewById(R.id.txtProfileCountryNameStatistic);
        txtProfileAge = findViewById(R.id.txtProfileAge);
        txtProfileBorn = findViewById(R.id.txtProfileBorn);
        txtPlayingRole = findViewById(R.id.txtPlayingRole);
        txtMajorTeam = findViewById(R.id.txtMajorTeam);
        txtBattingStyle = findViewById(R.id.txtBattingStyle);
        txtBowlingStyle = findViewById(R.id.txtBowlingStyle);
        imageView=findViewById(R.id.imgProfileDisplayListStatistic);

        txtprofileName.setText(playerDetails.getPlayerName());
        txtprofileCountryName.setText(playerDetails.getCurrentAge());
        txtProfileAge.setText(playerDetails.getBorn());
        txtProfileBorn.setText(playerDetails.getCountry());
        txtPlayingRole.setText(playerDetails.getPlayingRole());
        txtMajorTeam.setText(playerDetails.getMajorTeams());
        txtBattingStyle.setText(playerDetails.getBattingStyle());
        txtBowlingStyle.setText(playerDetails.getBowlingStyle());
        Picasso.get()
                .load(playerDetails.getmImageUrl())
                .fit()
                .centerCrop()
                .into(imageView);


        //For Batting Statistic
        txtMatches = findViewById(R.id.txtMatchesPassing);
        txtInnings = findViewById(R.id.txtInningsPassing);
        txtRuns = findViewById(R.id.txtRunsPassing);
        txtHS = findViewById(R.id.txtHSPassing);
        txtAve = findViewById(R.id.txtAvePassing);
        txtSR = findViewById(R.id.txtSRPassing);
        txt50 = findViewById(R.id.txt50Passing);
        txt100 = findViewById(R.id.txt100Passing);
        txt4s=findViewById(R.id.txt4sPassing);
        txt6s=findViewById(R.id.txt6sPassing);


        txtMatches.setText(playerDetails.getMatches());
        txtInnings.setText(playerDetails.getInnings());
        txtRuns.setText(playerDetails.getRunsBatting());
        txtHS.setText(playerDetails.getHS());
        txtAve.setText(playerDetails.getAve());
        txtSR.setText(playerDetails.getSR());
        txt50.setText(playerDetails.getHalfCentury());
        txt100.setText(playerDetails.getCentury());
        txt4s.setText(playerDetails.getFours());
        txt6s.setText(playerDetails.getSixes());


        //For Bowling Statistic
        txtMatchesBowlingPassing = findViewById(R.id.txtMatchesBowlingPassing);
        txtInningsBowlingPassing = findViewById(R.id.txtInningsBowlingPassing);
        txtBallPassing = findViewById(R.id.txtBallsPassing);
        txtWktsPassing = findViewById(R.id.txtWktsPassing);
        txt4wPassing = findViewById(R.id.txt4wPassing);
        txt5wPassing = findViewById(R.id.txt5wPassing);
        txtAveBowlingPassing = findViewById(R.id.txtAveBowlingPassing);
        txtEconPassing = findViewById(R.id.txtEconPassing);


        txtMatchesBowlingPassing.setText(playerDetails.getMatchesBowling());
        txtInningsBowlingPassing.setText(playerDetails.getInningsBowling());
        txtBallPassing.setText(playerDetails.getBalls());
        txtWktsPassing.setText(playerDetails.getWkts());
        txt4wPassing.setText(playerDetails.getFourWicketsHaul());
        txt5wPassing.setText(playerDetails.getFiveWicketsHaul());
        txtAveBowlingPassing.setText(playerDetails.getAveBowling());
        txtEconPassing.setText(playerDetails.getEcon());

        btndelete=findViewById(R.id.btnDelete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlayerStatisticActivity.this, "One player has deleted ",
                        Toast.LENGTH_SHORT).show();
                DatabaseReference dR = FirebaseDatabase.getInstance().getReference
                        ("player-details").child(playerDetails.getId());
                dR.removeValue();
            }
        });

    }

}