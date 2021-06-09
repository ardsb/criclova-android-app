package com.example.criclowa.Model;

import com.google.gson.annotations.SerializedName;

public class PlayerStatistic {

    @SerializedName("name")
    public String playerName;

    @SerializedName("imageURL")
    public String imageurl;

    @SerializedName("country")
    public String country;

    @SerializedName("battingStyle")
    public String battingStyle;

    @SerializedName("bowlingStyle")
    public String bowlingStyle;

    @SerializedName("majorTeams")
    public String majorTeams;

    @SerializedName("currentAge")
    public String currentAge;

    @SerializedName("born")
    public String born;

    @SerializedName("playingRole")
    public String playingRole;


    public String getBattingStyle() {
        return battingStyle;
    }

    public void setBattingStyle(String battingStyle) {
        this.battingStyle = battingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        this.bowlingStyle = bowlingStyle;
    }

    public String getMajorTeams() {
        return majorTeams;
    }

    public void setMajorTeams(String majorTeams) {
        this.majorTeams = majorTeams;
    }

    public String getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(String currentAge) {
        this.currentAge = currentAge;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getPlayingRole() {
        return playingRole;
    }

    public void setPlayingRole(String playingRole) {
        this.playingRole = playingRole;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
