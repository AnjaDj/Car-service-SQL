package com.example.jasigui.model;

import java.util.Date;

public class RadniNalog {
    private int id;
    private String status;
    private Date datumZavrsetka;
    private int idZaduzenje;
    private int idZaposleni;

    public RadniNalog(int id, String status, Date datumZavrsetka, int idZaduzenje, int idZaposleni) {
        this.id = id;
        this.status = status;
        this.datumZavrsetka = datumZavrsetka;
        this.idZaduzenje = idZaduzenje;
        this.idZaposleni = idZaposleni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public int getIdZaduzenje() {
        return idZaduzenje;
    }

    public void setIdZaduzenje(int idZaduzenje) {
        this.idZaduzenje = idZaduzenje;
    }

    public int getIdZaposleni() {
        return idZaposleni;
    }

    public void setIdZaposleni(int idZaposleni) {
        this.idZaposleni = idZaposleni;
    }
}
