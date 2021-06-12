package com.example.criclowa.View;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.criclowa.Adapter.PlayersProfileAdpater;
import com.example.criclowa.Model.PlayerDetails;
import com.example.criclowa.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayPlayersDetailsActivity extends Activity {
    String TAG = DisplayPlayersDetailsActivity.class.getSimpleName();
    DatabaseReference myRef;
    List<PlayerDetails> playerDetails;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_players_profile);

        recyclerView = findViewById(R.id.reyclerviewPlayerDetails);
        playerDetails = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("player-details");

    }


    @Override
    protected void onStart() {
        super.onStart();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                playerDetails.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    PlayerDetails playerDetailsDisplay = postSnapshot.getValue(PlayerDetails.class);

                    playerDetails.add(playerDetailsDisplay);
                }

                if (playerDetails.size() > 0) {

                    PlayersProfileAdpater playersProfileAdpater = new PlayersProfileAdpater(DisplayPlayersDetailsActivity.this, playerDetails);

                    PlayersProfileAdpater adapter = new PlayersProfileAdpater(DisplayPlayersDetailsActivity.this, playerDetails);


                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(DisplayPlayersDetailsActivity.this);
                    recyclerView.setLayoutManager(mLayoutManager);
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


}
