package com.example.jasigui.model;

public class Usluga {
    private String sifra;
    private String naziv;
    private int idNalog;
    private Double cijena;

    public Usluga(String sifra, String naziv, int idNalog, Double cijena) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.idNalog = idNalog;
        this.cijena = cijena;
    }

    public Usluga(String sifra, String naziv, Double cijena) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.cijena = cijena;
    }

    public Usluga(String sifra, int idNalog, Double cijena) {
        this.sifra = sifra;
        this.idNalog = idNalog;
        this.cijena = cijena;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getIdNalog() {
        return idNalog;
    }

    public void setIdNalog(int idNalog) {
        this.idNalog = idNalog;
    }

    public Double getCijena() {
        return cijena;
    }

    public void setCijena(Double cijena) {
        this.cijena = cijena;
    }
}
