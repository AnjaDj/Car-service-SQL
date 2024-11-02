package com.example.jasigui.model;

public class StavkaNalog {
    private int idNalog;
    private int idZaduzenje;
    private double cijena;

    public StavkaNalog(int idNalog, int idZaduzenje, double cijena) {
        this.idNalog = idNalog;
        this.idZaduzenje = idZaduzenje;
        this.cijena = cijena;
    }

    public int getIdNalog() {
        return idNalog;
    }

    public void setIdNalog(int idNalog) {
        this.idNalog = idNalog;
    }

    public int getIdZaduzenje() {
        return idZaduzenje;
    }

    public void setIdZaduzenje(int idZaduzenje) {
        this.idZaduzenje = idZaduzenje;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }
}
