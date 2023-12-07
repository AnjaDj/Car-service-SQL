package com.example.jasigui.model;

public class Artikal {

    private String sifra;
    private String naziv;
    private int idNalog;
    private Double cijena;
    private Double kolicina;

    public Artikal(String sifra, String naziv, int idNalog, Double cijena, Double kolicina) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.idNalog = idNalog;
        this.cijena = cijena;
        this.kolicina = kolicina;
    }

    public Artikal(String sifra, String naziv, Double cijena, Double kolicina) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.cijena = cijena;
        this.kolicina = kolicina;
    }

    public Artikal(String sifra, int idNalog, Double cijena, Double kolicina) {
        this.sifra = sifra;
        this.idNalog = idNalog;
        this.cijena = cijena;
        this.kolicina = kolicina;
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

    public Double getKolicina() {
        return kolicina;
    }

    public void setKolicina(Double kolicina) {
        this.kolicina = kolicina;
    }
}
