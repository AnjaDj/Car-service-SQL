package com.example.jasigui.model;

import java.util.Date;

public class Racun {
    private int id;
    private double iznos;
    private Date datum;
    private int idZaduzenje;

    public Racun(int id, double iznos, Date datum, int idZaduzenje) {
        this.id = id;
        this.iznos = iznos;
        this.datum = datum;
        this.idZaduzenje = idZaduzenje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getIdZaduzenje() {
        return idZaduzenje;
    }

    public void setIdZaduzenje(int idZaduzenje) {
        this.idZaduzenje = idZaduzenje;
    }
}
