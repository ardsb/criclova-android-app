package com.example.criclowa.Model;

public class BowlingOutputs {

    private String id;

    private String Matches;

    private String Innings;

    private String Balls;

    private String Wkts;

    private String fourWicketsHaul;

    private String fiveWicketsHaul;


    private String Ave;

    private String Econ;

    public BowlingOutputs(String id, String matches, String innings, String balls, String wkts
            , String fourWicketsHaul, String fiveWicketsHaul, String ave
            , String econ) {
        this.id = id;
        Matches = matches;
        Innings = innings;
        Balls = balls;
        Wkts = wkts;
        this.fourWicketsHaul = fourWicketsHaul;
        this.fiveWicketsHaul = fiveWicketsHaul;
        Ave = ave;
        Econ = econ;
    }

    public BowlingOutputs(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatches() {
        return Matches;
    }

    public void setMatches(String matches) {
        Matches = matches;
    }

    public String getInnings() {
        return Innings;
    }

    public void setInnings(String innings) {
        Innings = innings;
    }

    public String getBalls() {
        return Balls;
    }

    public void setBalls(String balls) {
        Balls = balls;
    }

    public String getWkts() {
        return Wkts;
    }

    public void setWkts(String wkts) {
        Wkts = wkts;
    }

    public String getFourWicketsHaul() {
        return fourWicketsHaul;
    }

    public void setFourWicketsHaul(String fourWicketsHaul) {
        this.fourWicketsHaul = fourWicketsHaul;
    }

    public String getFiveWicketsHaul() {
        return fiveWicketsHaul;
    }

    public void setFiveWicketsHaul(String fiveWicketsHaul) {
        this.fiveWicketsHaul = fiveWicketsHaul;
    }



    public String getAve() {
        return Ave;
    }

    public void setAve(String ave) {
        Ave = ave;
    }

    public String getEcon() {
        return Econ;
    }

    public void setEcon(String econ) {
        Econ = econ;
    }
}
