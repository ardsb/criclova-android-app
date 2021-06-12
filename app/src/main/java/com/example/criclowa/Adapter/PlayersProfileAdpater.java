package com.example.criclowa.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.criclowa.Model.PlayerDetails;
import com.example.criclowa.R;
import com.example.criclowa.View.DisplayPlayersProfileDetailActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class PlayersProfileAdpater extends RecyclerView.Adapter<PlayersProfileAdpater.ViewHolder> {
    private List<PlayerDetails> dataSet;
    private Context context;


    public class ViewHolder extends RecyclerView.ViewHolder   {
        TextView profileName, profileCountryName,txtProfileAge,txtProfileBorn,txtPlayingRole,txtMajorTeam
                ,txtBattingStyle,txtBowlingStyle; //For Profile
        Button btnDelete;
        ImageView imageView;
        LinearLayout layout;


        public ViewHolder(View view) {
            super(view);

            profileName = view.findViewById(R.id.txtProfileNameStatisticAdmin);
            profileCountryName = view.findViewById(R.id.txtProfileCountryNameStatisticAdmin);
            txtProfileAge = view.findViewById(R.id.txtProfileAgeAdmin);
            txtProfileBorn = view.findViewById(R.id.txtProfileBornAdmin);
            txtPlayingRole = view.findViewById(R.id.txtPlayingRoleAdmin);
            txtMajorTeam = view.findViewById(R.id.txtMajorTeamAdmin);
            txtBattingStyle = view.findViewById(R.id.txtBattingStyleAdmin);
            txtBowlingStyle = view.findViewById(R.id.txtBowlingStyleAdmin);
            btnDelete = view.findViewById(R.id.btnDelete);
            layout = view.findViewById(R.id.playerProfileLayout);
            imageView =view.findViewById(R.id.btnProfileAdmin2);




        }
    }

    public PlayersProfileAdpater(Context context, List<PlayerDetails> dataSet) {
        this.dataSet = dataSet;
        this.context = context;
    }

    @Override
    public PlayersProfileAdpater.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.players_profile_list_layout, viewGroup, false);
        return new PlayersProfileAdpater.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayersProfileAdpater.ViewHolder viewHolder, final int position) {



        viewHolder.profileName.setText(dataSet.get(position).getPlayerName());
        viewHolder.profileCountryName.setText(dataSet.get(position).getCountry());
        viewHolder.txtProfileAge.setText(dataSet.get(position).getCurrentAge());
        viewHolder.txtProfileBorn.setText(dataSet.get(position).getBorn());
        viewHolder.txtPlayingRole.setText(dataSet.get(position).getPlayingRole());
        viewHolder.txtMajorTeam.setText(dataSet.get(position).getMajorTeams());
        viewHolder.txtBattingStyle.setText(dataSet.get(position).getBattingStyle());
        viewHolder.txtBowlingStyle.setText(dataSet.get(position).getBowlingStyle());


        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(context, DisplayPlayersProfileDetailActivity.class);
                PlayerDetails playerDetails=dataSet.get(position);
                mainActivityIntent.putExtra("Player Details",playerDetails);
                context.startActivity(mainActivityIntent);
            }
        });

        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "One record deleted ", Toast.LENGTH_SHORT).show();
                DatabaseReference dR = FirebaseDatabase.getInstance().getReference("player-details").child(dataSet.get(position).getId());
//
                dR.removeValue();
            }
        });




    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
