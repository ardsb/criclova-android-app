package com.example.criclowa.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.criclowa.Model.Matches;
import com.example.criclowa.Model.PlayerDetails;
import com.example.criclowa.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPlayerDetailActivity extends AppCompatActivity {
    DatabaseReference myRef;
    TextView txtPLayersName,txtPLayersAge,txtPLayersBorn,txtPlayingCountry,txtPlayerPlayingRole
            ,txtMajorteam,txtPlayerBattingStyle,txtPlayerBowlingStyle;
    Button addMatch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player_detail);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("player-details");//Database name


        txtPLayersName=findViewById(R.id.txtPLayersName);
        txtPLayersAge=findViewById(R.id.txtPLayersAge);
        txtPLayersBorn=findViewById(R.id.txtPLayersBorn);
        txtPlayingCountry=findViewById(R.id.txtPlayingCountry);
        txtPlayerPlayingRole=findViewById(R.id.txtPlayerPlayingRole);
        txtMajorteam=findViewById(R.id.txtMajorteam);
        txtPlayerBattingStyle=findViewById(R.id.txtPlayerBattingStyle);
        txtPlayerBowlingStyle=findViewById(R.id.txtPlayerBowlingStyle);


        addMatch=findViewById(R.id.btnAdd);
        addMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PLayersName = txtPLayersName.getText().toString().trim();
                String PLayersAge = txtPLayersAge.getText().toString().trim();
                String PLayersBorn = txtPLayersBorn.getText().toString().trim();
                String PlayingCountry = txtPlayingCountry.getText().toString().trim();
                String PlayerPlayingRole = txtPlayerPlayingRole.getText().toString().trim();
                String Majorteam = txtMajorteam.getText().toString().trim();
                String PlayerBattingStyle = txtPlayerBattingStyle.getText().toString().trim();
                String PlayerBowlingStyle = txtPlayerBowlingStyle.getText().toString().trim();



                if(!TextUtils.isEmpty(PLayersName) && !TextUtils.isEmpty(PLayersAge)
                        && !TextUtils.isEmpty(PLayersBorn)&& !TextUtils.isEmpty(PlayingCountry)
                        && !TextUtils.isEmpty(PlayerPlayingRole) && !TextUtils.isEmpty(Majorteam)
                        && !TextUtils.isEmpty(PlayerBattingStyle)
                        && !TextUtils.isEmpty(PlayerBowlingStyle)  ){

                    addMatch(PLayersName,PLayersAge,PLayersBorn,PlayingCountry,PlayerPlayingRole,
                            Majorteam,PlayerBattingStyle,PlayerBowlingStyle);



                }else {

                    Toast.makeText(getApplicationContext(),"Artist Name cannot be empty"
                            ,Toast.LENGTH_SHORT).show();
                }

            }


        });

    }

    public void addMatch(String PLayersName, String PLayersAge, String PLayersBorn,String PlayingCountry
            ,String PlayerPlayingRole,String Majorteam,String PlayerBattingStyle,String PlayerBowlingStyle){


        String id = myRef.push().getKey();
        PlayerDetails playerDetails = new PlayerDetails (id,PLayersName,PLayersAge,PLayersBorn,PlayingCountry
                ,PlayerPlayingRole, Majorteam,PlayerBattingStyle, PlayerBowlingStyle);

        myRef.child(id).setValue(playerDetails);


        Toast.makeText(this,"New player has added",Toast.LENGTH_SHORT).show();
    }
}