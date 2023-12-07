package com.example.jasigui.model;

import java.util.Date;

public class Zaduzenje {

    private int id;
    private Date datumPreuzimanja;
    private String opis;
    private String brojSasije;
    private int idRadnaStanica;
    private int idZaposleni;
    private Date datumZavrsetka;
    private double racun;

    public Zaduzenje(int id, Date datumPreuzimanja, String opis, String brojSasije, int idRadnaStanica, int idZaposleni, Date datumZavrsetka, double racun) {
        this.id = id;
        this.datumPreuzimanja = datumPreuzimanja;
        this.opis = opis;
        this.brojSasije = brojSasije;
        this.idRadnaStanica = idRadnaStanica;
        this.idZaposleni = idZaposleni;
        this.datumZavrsetka = datumZavrsetka;
        this.racun = racun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatumPreuzimanja() {
        return datumPreuzimanja;
    }

    public void setDatumPreuzimanja(Date datumPreuzimanja) {
        this.datumPreuzimanja = datumPreuzimanja;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getBrojSasije() {
        return brojSasije;
    }

    public void setBrojSasije(String brojSasije) {
        this.brojSasije = brojSasije;
    }

    public int getIdRadnaStanica() {
        return idRadnaStanica;
    }

    public void setIdRadnaStanica(int idRadnaStanica) {
        this.idRadnaStanica = idRadnaStanica;
    }

    public int getIdZaposleni() {
        return idZaposleni;
    }

    public void setIdZaposleni(int idZaposleni) {
        this.idZaposleni = idZaposleni;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public double getRacun() {
        return racun;
    }

    public void setRacun(double racun) {
        this.racun = racun;
    }
}
