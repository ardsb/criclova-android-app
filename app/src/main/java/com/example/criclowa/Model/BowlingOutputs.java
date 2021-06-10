package com.example.criclowa.Model;

import com.google.gson.annotations.SerializedName;

public class BowlingOutputs {

    @SerializedName("10")
    public String tenWicketsHaul;

    @SerializedName("5w")
    public String fiveWicketsHaul;

    @SerializedName("4w")
    public String fourWicketsHaul;

    @SerializedName("SR")
    public String SR;

    @SerializedName("Econ")
    public String Econ;

    @SerializedName("Ave")
    public String Ave;

    @SerializedName("BBM")
    public String BBM;

    @SerializedName("BBI")
    public String BBI;

    @SerializedName("Wkts")
    public String Wkts;

    @SerializedName("Runs")
    public String Runs;

    @SerializedName("Balls")
    public String Balls;

    @SerializedName("Inns")
    public String Inns;

    @SerializedName("Mat")
    public String Mat;

    public String getTenWicketsHaul() {
        return tenWicketsHaul;
    }

    public void setTenWicketsHaul(String tenWicketsHaul) {
        this.tenWicketsHaul = tenWicketsHaul;
    }

    public String getFiveWicketsHaul() {
        return fiveWicketsHaul;
    }

    public void setFiveWicketsHaul(String fiveWicketsHaul) {
        this.fiveWicketsHaul = fiveWicketsHaul;
    }

    public String getFourWicketsHaul() {
        return fourWicketsHaul;
    }

    public void setFourWicketsHaul(String fourWicketsHaul) {
        this.fourWicketsHaul = fourWicketsHaul;
    }

    public String getSR() {
        return SR;
    }

    public void setSR(String SR) {
        this.SR = SR;
    }

    public String getEcon() {
        return Econ;
    }

    public void setEcon(String econ) {
        Econ = econ;
    }

    public String getAve() {
        return Ave;
    }

    public void setAve(String ave) {
        Ave = ave;
    }

    public String getBBM() {
        return BBM;
    }

    public void setBBM(String BBM) {
        this.BBM = BBM;
    }

    public String getBBI() {
        return BBI;
    }

    public void setBBI(String BBI) {
        this.BBI = BBI;
    }

    public String getWkts() {
        return Wkts;
    }

    public void setWkts(String wkts) {
        Wkts = wkts;
    }

    public String getRuns() {
        return Runs;
    }

    public void setRuns(String runs) {
        Runs = runs;
    }

    public String getBalls() {
        return Balls;
    }

    public void setBalls(String balls) {
        Balls = balls;
    }

    public String getInns() {
        return Inns;
    }

    public void setInns(String inns) {
        Inns = inns;
    }

    public String getMat() {
        return Mat;
    }

    public void setMat(String mat) {
        Mat = mat;
    }
}
