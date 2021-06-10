package com.example.criclowa.Model;

import com.google.gson.annotations.SerializedName;

public class ListABatting {

    @SerializedName("listA")
    public BattingOutputs ListABatting;

    @SerializedName("firstClass")
    public BattingOutputs firstClassBatting;

    public BattingOutputs getFirstClassBatting() {
        return firstClassBatting;
    }

    public void setFirstClassBatting(BattingOutputs firstClassBatting) {
        this.firstClassBatting = firstClassBatting;
    }

    public BattingOutputs getListABatting() {
        return ListABatting;
    }

    public void setListABatting(BattingOutputs listABatting) {
        ListABatting = listABatting;
    }
}
