package com.example.criclowa.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.criclowa.Model.Match;
import com.example.criclowa.R;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {
    private final List<Match> match;
    private int rowLayout;
    private Context context;



    public static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView scores;

        public MatchViewHolder(View v) {

            super(v);

            scores = v.findViewById(R.id.txtMatchesOutput);
        }
    }

    public MatchAdapter(List<Match> match, int rowLayout, Context context) {
        this.match = match;
        this.rowLayout = rowLayout;
        this.context = context;



    }

    @Override
    public MatchAdapter.MatchViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.matches_layout, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, final int position) {

        String item= match.get(position).getTitle();
        holder.scores.setText(match.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return match.size();
    }

}

