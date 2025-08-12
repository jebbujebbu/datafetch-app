package com.example.datafetchapp;

public class DateName {
    private String pvm;
    private String nimi;

    public DateName(String pvm, String nimi) {
        this.pvm = pvm;
        this.nimi = nimi;
    }

    public String getPvm() { return pvm; }
    public String getNimi() { return nimi; }
}
