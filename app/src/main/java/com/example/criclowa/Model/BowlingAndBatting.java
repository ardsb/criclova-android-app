package com.example.criclowa.Model;

import com.google.gson.annotations.SerializedName;

public class BowlingAndBatting {

    @SerializedName("bowling")
    public ListABowling bowling;

    @SerializedName("batting")
    public ListABatting batting;

    public ListABatting getBatting() {
        return batting;
    }

    public void setBatting(ListABatting batting) {
        this.batting = batting;
    }

    public ListABowling getBowling() {
        return bowling;
    }

    public void setBowling(ListABowling bowling) {
        this.bowling = bowling;
    }
}
