package com.example.criclowa.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.criclowa.Model.PlayerDetails;
import com.example.criclowa.R;
//import com.example.criclowa.View.DisplayPlayersProfileDetailActivity;
import com.example.criclowa.View.PlayerStatisticActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlayersProfileAdpater extends RecyclerView.Adapter<PlayersProfileAdpater.ViewHolder> {
    private List<PlayerDetails> dataSet;
    private Context context;


    public class ViewHolder extends RecyclerView.ViewHolder   {

        LinearLayout layout;

        TextView profileName, profileCountryName,txtProfileAge,txtProfileBorn,txtPlayingRole
                ,txtMajorTeam,txtBattingStyle,txtBowlingStyle; //For Profile

        TextView txtMatches,txtInnings,txtRuns,txtHS,txtAve,txtSR,txt50,txt100,txt4s,txt6s;
                    //For Batting Statistic

        TextView txtMatchesBowling,txtInningsBowling,txtBalls,txtWkts,txt4w,txt5w,txtAveBowling,
                txtEcon; //For Bowling Statistic


       public CircleImageView imageView;

        public ViewHolder(View view) {
            super(view);

            //For Profile
            profileName = view.findViewById(R.id.txtProfileNameStatisticAdmin);
            profileCountryName = view.findViewById(R.id.txtProfileCountryNameStatisticAdmin);
            txtProfileAge = view.findViewById(R.id.txtProfileAgeAdmin);
            txtProfileBorn = view.findViewById(R.id.txtProfileBornAdmin);
            txtPlayingRole = view.findViewById(R.id.txtPlayingRoleAdmin);
            txtMajorTeam = view.findViewById(R.id.txtMajorTeamAdmin);
            txtBattingStyle = view.findViewById(R.id.txtBattingStyleAdmin);
            txtBowlingStyle = view.findViewById(R.id.txtBowlingStyleAdmin);
            layout = view.findViewById(R.id.playerProfileLayout);
            imageView =view.findViewById(R.id.imgProfileImageList);

            //For Batting Statistic
            txtMatches=view.findViewById(R.id.txtMatches);
            txtInnings=view.findViewById(R.id.txtInnings);
            txtRuns=view.findViewById(R.id.txtRuns);
            txtHS=view.findViewById(R.id.txtHS);
            txtAve=view.findViewById(R.id.txtAve);
            txtSR=view.findViewById(R.id.txtSR);
            txt50=view.findViewById(R.id.txt50);
            txt100=view.findViewById(R.id.txt100);
            txt4s=view.findViewById(R.id.txt4s);
            txt6s=view.findViewById(R.id.txt6s);


            //For Bowling Statistic
            txtMatchesBowling=view.findViewById(R.id.txtMatchesBowling);
            txtInningsBowling=view.findViewById(R.id.txtInningsBowling);
            txtBalls=view.findViewById(R.id.txtBalls);
            txtWkts=view.findViewById(R.id.txtWkts);
            txt4w=view.findViewById(R.id.txt4w);
            txt5w=view.findViewById(R.id.txt5w);
            txtAveBowling=view.findViewById(R.id.txtAveBowling);
            txtEcon=view.findViewById(R.id.txtEcon);




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

        PlayerDetails playerDetails = dataSet.get(position);

        //For Profile
        viewHolder.profileName.setText(dataSet.get(position).getPlayerName());
        viewHolder.profileCountryName.setText(dataSet.get(position).getCountry());
        viewHolder.txtProfileAge.setText(dataSet.get(position).getCurrentAge());
        viewHolder.txtProfileBorn.setText(dataSet.get(position).getBorn());
        viewHolder.txtPlayingRole.setText(dataSet.get(position).getPlayingRole());
        viewHolder.txtMajorTeam.setText(dataSet.get(position).getMajorTeams());
        viewHolder.txtBattingStyle.setText(dataSet.get(position).getBattingStyle());
        viewHolder.txtBowlingStyle.setText(dataSet.get(position).getBowlingStyle());


        //For Batting Statistic
        viewHolder.txtMatches.setText(dataSet.get(position).getMatches());
        viewHolder.txtInnings.setText(dataSet.get(position).getInnings());
        viewHolder.txtRuns.setText(dataSet.get(position).getRunsBatting());
        viewHolder.txtHS.setText(dataSet.get(position).getHS());
        viewHolder.txtAve.setText(dataSet.get(position).getAve());
        viewHolder.txtSR.setText(dataSet.get(position).getSR());
        viewHolder.txt50.setText(dataSet.get(position).getHalfCentury());
        viewHolder.txt100.setText(dataSet.get(position).getCentury());
        viewHolder.txt4s.setText(dataSet.get(position).getFours());
        viewHolder.txt6s.setText(dataSet.get(position).getSixes());

        //For Bowling Statistic
        viewHolder.txtMatchesBowling.setText(dataSet.get(position).getMatchesBowling());
        viewHolder.txtInningsBowling.setText(dataSet.get(position).getInningsBowling());
        viewHolder.txtBalls.setText(dataSet.get(position).getBalls());
        viewHolder.txtWkts.setText(dataSet.get(position).getWkts());
        viewHolder.txt4w.setText(dataSet.get(position).getFourWicketsHaul());
        viewHolder.txt5w.setText(dataSet.get(position).getFiveWicketsHaul());
        viewHolder.txtAveBowling.setText(dataSet.get(position).getAveBowling());
        viewHolder.txtEcon.setText(dataSet.get(position).getEcon());


        String image = playerDetails.getmImageUrl();
        if (image !=null && !image.trim().equals("")) {
            Picasso.get()
                    .load(image).into(viewHolder.imageView);
        }


        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(context
                        , PlayerStatisticActivity.class);
                PlayerDetails playerDetails=dataSet.get(position);
                mainActivityIntent.putExtra("Player Details",playerDetails);
                context.startActivity(mainActivityIntent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}
