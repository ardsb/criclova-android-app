package com.example.criclowa.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.criclowa.Model.BattingOutputs;
import com.example.criclowa.Model.BowlingOutputs;
import com.example.criclowa.Model.PlayerDetails;
import com.example.criclowa.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class DisplayPlayersProfileDetailActivity extends AppCompatActivity {
    TextView txtProfileNameStatisticPassing, txtProfileAgePassing, txtProfileBornPassing
            , txtProfileCountryNameStatisticPassing, txtPlayingRolePassing, txtMajorTeamPassing
            , txtBattingStylePassing, txtBowlingStylePassing;

    TextView txtMatchesStatistic,txtInningsStatistic,txtRunsStaistic,txtHSStatistic
                ,txtAverageStatistic,txtStrikeRateStatistic,txtHalfCenturyStatistic,txtCenturyStatistic
            ,txtSixesStatistic,txtfoursStatistic;;

    TextView txtMatchesStatisticBowling,txtInningsStatisticBowling,txtBallsStaistic
            ,txtWicketsStatistic,txtFourWicketsHaulStatistic,txtAverageStatisticBowling
            ,txtFiveWicketsHaulStatistic,txtTenWicketsHaulStatistic,txtEconStatistic
            ,txtSixesStatisticBowling,txtfoursStatisticBowling;;
    ImageView imgProfile;
    DatabaseReference myRef;
    Button btnAddStatistic,btnAddStatisticBowling;

    private List<PlayerDetails> dataSet;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_players_profile_detail);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("player-details");

        PlayerDetails playerDetails = (PlayerDetails) getIntent().getSerializableExtra("Player Details");
        myRef = FirebaseDatabase.getInstance().getReference("bowling&batting-statistic").child(playerDetails.getId());

        txtProfileNameStatisticPassing = findViewById(R.id.txtProfileNameStatisticPassing);
        txtProfileAgePassing = findViewById(R.id.txtProfileAgePassing);
        txtProfileBornPassing = findViewById(R.id.txtProfileBornPassing);
        txtProfileCountryNameStatisticPassing = findViewById(R.id.txtProfileCountryNameStatisticPassing);
        txtPlayingRolePassing = findViewById(R.id.txtPlayingRolePassing);
        txtMajorTeamPassing = findViewById(R.id.txtMajorTeamPassing);
        txtBattingStylePassing = findViewById(R.id.txtBattingStylePassing);
        txtBowlingStylePassing = findViewById(R.id.txtBowlingStylePassing);

        txtProfileNameStatisticPassing.setText(playerDetails.getPlayerName());
        txtProfileAgePassing.setText(playerDetails.getCurrentAge());
        txtProfileBornPassing.setText(playerDetails.getBorn());
        txtProfileCountryNameStatisticPassing.setText(playerDetails.getCountry());
        txtPlayingRolePassing.setText(playerDetails.getPlayingRole());
        txtMajorTeamPassing.setText(playerDetails.getMajorTeams());
        txtBattingStylePassing.setText(playerDetails.getBattingStyle());
        txtBowlingStylePassing.setText(playerDetails.getBowlingStyle());

        txtMatchesStatistic=findViewById(R.id.txtMatchesStatistic);
        txtInningsStatistic=findViewById(R.id.txtInningsStatistic);
        txtRunsStaistic=findViewById(R.id.txtRunsStaistic);
        txtHSStatistic=findViewById(R.id.txtHSStatistic);
        txtAverageStatistic=findViewById(R.id.txtAverageStatistic);
        txtStrikeRateStatistic=findViewById(R.id.txtStrikeRateStatistic);
        txtHalfCenturyStatistic=findViewById(R.id.txtHalfCenturyStatistic);
        txtCenturyStatistic=findViewById(R.id.txtCenturyStatistic);
        txtSixesStatistic=findViewById(R.id.txtSixesStatistic);
        txtfoursStatistic=findViewById(R.id.txtfoursStatistic);



        btnAddStatistic=findViewById(R.id.btnAddBatting);
        btnAddStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BattingOutputs battingOutputs = new BattingOutputs();

                battingOutputs.setMatches(txtMatchesStatistic.getText().toString().trim());
                battingOutputs.setInnings(txtInningsStatistic.getText().toString().trim());
                battingOutputs.setRunsBatting(txtRunsStaistic.getText().toString().trim());
                battingOutputs.setHS(txtHSStatistic.getText().toString().trim());
                battingOutputs.setAve(txtAverageStatistic.getText().toString().trim());
                battingOutputs.setSR(txtStrikeRateStatistic.getText().toString().trim());
                battingOutputs.setHalfCentury(txtHalfCenturyStatistic.getText().toString().trim());
                battingOutputs.setCentury(txtCenturyStatistic.getText().toString().trim());
                battingOutputs.setSixes(txtSixesStatistic.getText().toString().trim());
                battingOutputs.setFours(txtfoursStatistic.getText().toString().trim());


                saveBattingStatistic(battingOutputs);
            }
        });


        txtMatchesStatisticBowling=findViewById(R.id.txtMatchesStatisticBowling);
        txtInningsStatisticBowling=findViewById(R.id.txtInningsStatisticBowling);
        txtBallsStaistic=findViewById(R.id.txtBallsStaistic);
        txtWicketsStatistic=findViewById(R.id.txtWicketsStatistic);
        txtFourWicketsHaulStatistic=findViewById(R.id.txtFourWicketsHaulStatistic);
        txtFiveWicketsHaulStatistic=findViewById(R.id.txtFiveWicketsHaulStatistic);
        txtAverageStatisticBowling=findViewById(R.id.txtAverageStatisticBowling);
        txtEconStatistic=findViewById(R.id.txtEconStatistic);


        btnAddStatisticBowling=findViewById(R.id.btnAddBowling);
        btnAddStatisticBowling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                BowlingOutputs bowlingOutputs = new BowlingOutputs();

                bowlingOutputs.setMatches(txtMatchesStatisticBowling.getText().toString().trim());
                bowlingOutputs.setInnings(txtInningsStatistic.getText().toString().trim());
                bowlingOutputs.setBalls(txtBallsStaistic.getText().toString().trim());
                bowlingOutputs.setWkts(txtWicketsStatistic.getText().toString().trim());
                bowlingOutputs.setFourWicketsHaul(txtFourWicketsHaulStatistic.getText().toString().trim());
                bowlingOutputs.setFiveWicketsHaul(txtFiveWicketsHaulStatistic.getText().toString().trim());
                bowlingOutputs.setAve(txtAverageStatisticBowling.getText().toString().trim());
                bowlingOutputs.setEcon(txtEconStatistic.getText().toString().trim());

                saveBowlingStatistic(bowlingOutputs);
            }
        });


    }


    public void saveBattingStatistic(BattingOutputs battingOutputs){

        String id = myRef.push().getKey();
        battingOutputs.setId(id);
        myRef.child(id).setValue(battingOutputs);
        Toast.makeText(this,"Batting statistic has added",Toast.LENGTH_LONG).show();


    }

    public void saveBowlingStatistic(BowlingOutputs bowlingOutputs){

        String id = myRef.push().getKey();
        bowlingOutputs.setId(id);
        myRef.child(id).setValue(bowlingOutputs);
        Toast.makeText(this,"Bowling statistic has added",Toast.LENGTH_LONG).show();


    }



}