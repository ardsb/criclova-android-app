package com.example.criclowa.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchList {
    @SerializedName ("data")
    public List<Match> data;

    public List<Match> getData() {
        return data;
    }

    public void setData(List<Match> data) {
        this.data = data;
    }

    @SerializedName("main")
    private Match main;

    public List<Match> getResults() {
        return results;
    }

    public void setResults(List<Match> results) {
        this.results = results;
    }

    @SerializedName("results")
    private List<Match> results;

    public Match getMain() {
        return main;
    }

    public void setMain(Match main) {
        this.main = main;
    }

}
