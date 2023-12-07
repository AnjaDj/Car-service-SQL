package com.example.jasigui.db;

import java.sql.*;

public class JASIUmetni {

    public void kreirajZaduzenje(int idRadnaStanica, int idZaposleni, String brojSasije, Date zahtjevaniDatumZavrsetka, String opis) {
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call kreiranje_novog_zaduzenja(?,?,?,?,?)}");
                cs.setInt(1, idRadnaStanica);
                cs.setInt(2, idZaposleni);
                cs.setString(3, brojSasije);
                cs.setDate(4, zahtjevaniDatumZavrsetka);
                cs.setString(5, opis);

            rs = cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //

    public void kreirajRadniNalog(int idZaduzenje,int idZaposleni,Date ocekivaniDatumZavrsetka) {
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call kreiranje_novog_radnog_naloga(?,?,?)}");
                cs.setInt(1, idZaduzenje);
                cs.setInt(2, idZaposleni);
                cs.setDate(3, ocekivaniDatumZavrsetka);

            rs = cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //

    public void dodajUsluguNaRadniNalog(int idRadniNalog,String sifra) {
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call dodavanje_usluge_na_radniNalog(?,?)}");
                cs.setInt(1, idRadniNalog);
                cs.setString(2, sifra);

            rs = cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //

    public void dodajArtikalNaRadniNalog(int idRadniNalog,String sifra,double kolicina) {
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call dodavanje_artikla_na_radniNalog(?,?,?)}");
                cs.setInt(1, idRadniNalog);
                cs.setString(2, sifra);
                cs.setDouble(3,kolicina);

            rs = cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //

    public void dodajUsluguUSifarnik(String sifra,String naziv,double cena){
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call dodaj_uslugu(?,?,?)}");
                cs.setString(1, sifra);
                cs.setString(2, naziv);
                cs.setDouble(3, cena);

                rs = cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //

    public void dodajArtikalUSifarnik(String sifra,String naziv,double cena,double kolicina){
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call dodaj_artikal(?,?,?,?)}");
                cs.setString(1, sifra);
                cs.setString(2, naziv);
                cs.setDouble(3, cena);
                cs.setDouble(4, kolicina);

            rs = cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //

    public void idiUNabavku(String sifra,double kolicina, double cijena){
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call nabavka(?,?,?)}");
                cs.setString(1, sifra);
                cs.setDouble(2, kolicina);
                cs.setDouble(3, cijena);

            rs = cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //

    public void izmijeniUslugu(String sifra, double cijena){
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call izmeni_uslugu(?,?)}");
            cs.setString(1, sifra);
            cs.setDouble(2, cijena);

            rs = cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //
}
