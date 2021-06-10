package com.example.criclowa.Model;

import com.google.gson.annotations.SerializedName;

public class ListABowling {

    @SerializedName("listA")
    public BowlingOutputs ListABowling;

    @SerializedName("firstClass")
    public BowlingOutputs firstClassBowling;

    public BowlingOutputs getFirstClassBowling() {
        return firstClassBowling;
    }

    public void setFirstClassBowling(BowlingOutputs firstClassBowling) {
        this.firstClassBowling = firstClassBowling;
    }

    public BowlingOutputs getListABowling() {
        return ListABowling;
    }

    public void setListABowling(BowlingOutputs listABowling) {
        ListABowling = listABowling;
    }


}
