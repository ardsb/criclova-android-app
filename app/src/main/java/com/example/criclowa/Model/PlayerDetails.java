package com.example.criclowa.Model;

import java.io.Serializable;

public class PlayerDetails implements Serializable {



    public String id;

    public String mImageUrl;

    public String playerName;

    public String currentAge;

    public String born;

    public String country;

    public String playingRole;

    public String majorTeams;

    public String battingStyle;

    public String bowlingStyle;


    public PlayerDetails(String id,String playerName, String currentAge, String born, String country
            , String playingRole, String majorTeams, String battingStyle, String bowlingStyle,String imageUrl) {
        this.id = id;
        this.playerName = playerName;
        this.currentAge = currentAge;
        this.born = born;
        this.country = country;
        this.playingRole = playingRole;
        this.majorTeams = majorTeams;
        this.battingStyle = battingStyle;
        this.bowlingStyle = bowlingStyle;
        this.mImageUrl = imageUrl;
    }

    public PlayerDetails(){

    }



    public String getId() {
        return id;
    }


    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlayingRole() {
        return playingRole;
    }

    public void setPlayingRole(String playingRole) {
        this.playingRole = playingRole;
    }

    public String getMajorTeams() {
        return majorTeams;
    }

    public void setMajorTeams(String majorTeams) {
        this.majorTeams = majorTeams;
    }

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
}
