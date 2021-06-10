package com.example.criclowa.Model;

import com.google.gson.annotations.SerializedName;

public class BattingOutputs {

    @SerializedName("100")
    public String century;

    @SerializedName("50")
    public String halfCentury;

    @SerializedName("St")
    public String St;

    @SerializedName("Ct")
    public String Ct;

    @SerializedName("6s")
    public String Sixes;

    @SerializedName("4s")
    public String fours;

    @SerializedName("SR")
    public String SR;

    @SerializedName("BF")
    public String BF;

    @SerializedName("Ave")
    public String Ave;

    @SerializedName("HS")
    public String HS;

    @SerializedName("Runs")
    public String RunsBatting;

    @SerializedName("NO")
    public String NO;

    @SerializedName("Inns")
    public String Innings;

    @SerializedName("Mat")
    public String Matches;

    public String getCentury() {
        return century;
    }

    public void setCentury(String century) {
        this.century = century;
    }

    public String getHalfCentury() {
        return halfCentury;
    }

    public void setHalfCentury(String halfCentury) {
        this.halfCentury = halfCentury;
    }

    public String getSt() {
        return St;
    }

    public void setSt(String st) {
        St = st;
    }

    public String getCt() {
        return Ct;
    }

    public void setCt(String ct) {
        Ct = ct;
    }

    public String getSixes() {
        return Sixes;
    }

    public void setSixes(String sixes) {
        Sixes = sixes;
    }

    public String getFours() {
        return fours;
    }

    public void setFours(String fours) {
        this.fours = fours;
    }

    public String getSR() {
        return SR;
    }

    public void setSR(String SR) {
        this.SR = SR;
    }

    public String getBF() {
        return BF;
    }

    public void setBF(String BF) {
        this.BF = BF;
    }

    public String getAve() {
        return Ave;
    }

    public void setAve(String ave) {
        Ave = ave;
    }

    public String getHS() {
        return HS;
    }

    public void setHS(String HS) {
        this.HS = HS;
    }

    public String getRunsBatting() {
        return RunsBatting;
    }

    public void setRunsBatting(String runsBatting) {
        RunsBatting = runsBatting;
    }

    public String getNO() {
        return NO;
    }

    public void setNO(String NO) {
        this.NO = NO;
    }

    public String getInnings() {
        return Innings;
    }

    public void setInnings(String innings) {
        Innings = innings;
    }

    public String getMatches() {
        return Matches;
    }

    public void setMatches(String matches) {
        Matches = matches;
    }
}
