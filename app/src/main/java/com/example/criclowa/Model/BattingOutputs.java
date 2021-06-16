package com.example.criclowa.Model;


public class BattingOutputs {

    private String id;

    private String Matches;

    private String Innings;

    private String RunsBatting;

    private String HS;

    private String Ave;

    private String SR;

    private String halfCentury;

    private String century;

    private String Sixes;

    private String fours;


    public BattingOutputs(String id,String matches, String innings, String runsBatting, String HS
            , String ave, String SR, String halfCentury, String century, String sixes
            , String fours) {
        this.id = id;
        Matches = matches;
        Innings = innings;
        RunsBatting = runsBatting;
        this.HS = HS;
        Ave = ave;
        this.SR = SR;
        this.halfCentury = halfCentury;
        this.century = century;

        Sixes = sixes;
        this.fours = fours;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BattingOutputs(){

    }

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
