package com.example.jasigui.db;

import com.example.jasigui.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JASIPrikazi {

    public List<Zaduzenje> prikazSvihZaduzenja(){
        List<Zaduzenje> zaduzenja = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from zaduzenje z inner join racun r on z.idZaduzenje=r.idZaduzenje");

            while (rs.next())
                zaduzenja.add(new Zaduzenje(rs.getInt(1), rs.getDate(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6),
                        rs.getDate(7), rs.getDouble(9)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return zaduzenja;
    } //

    public List<RadniNalog> prikazSvihRadnihNaloga(){
        List<RadniNalog> nalozi = new ArrayList<>();

        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from radni_nalog");

            while (rs.next())
                nalozi.add(new RadniNalog(rs.getInt(1), rs.getString(2), rs.getDate(3),
                                    rs.getInt(4), rs.getInt(5)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return nalozi;
    } //

    public List<RadniNalog> prikazSvihRadnihNalogaZaNekoZaduzenje(int idZaduzenje) {  // radi
        List<RadniNalog> nalozi = new ArrayList<>();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from radni_nalog where idZaduzenje=?");
                ps.setInt(1, idZaduzenje);
            rs = ps.executeQuery();

            while (rs.next())
                nalozi.add(new RadniNalog(rs.getInt(1), rs.getString(2), rs.getDate(3),
                        rs.getInt(4), rs.getInt(5)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return nalozi;
    } //

    public List<Racun> prikazSvihRacuna(){ // radi
        List<Racun> racuni = new ArrayList<>();

        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from racun");

            while (rs.next())
                racuni.add(new Racun(rs.getInt(1), rs.getDouble(2),
                        rs.getDate(3), rs.getInt(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return racuni;
    } //

    public void prikazRacunaZaNekoZaduzenje(int idZaduzenje){ // radi

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from racun where idZaduzenje=?");
            ps.setInt(1, idZaduzenje);
            rs = ps.executeQuery();

            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getDouble(2) + " "
                        + rs.getString(3) + " " + rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }

    }

    public List<StavkaNalog> prikazUkupnogIznosaPoNalozimaNaOsnovuUsluga(){ // radi
        List<StavkaNalog> usluge = new ArrayList<>();

        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from prikaz_ukupnogIznosaUsluga_za_radniNalog");

            while (rs.next())
                usluge.add(new StavkaNalog(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return usluge;
    } //

    public List<StavkaNalog> prikazUkupnogIznosaPoNalozimaNaOsnovuArtikala(){ // radi
        List<StavkaNalog> artikli = new ArrayList<>();

        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from prikaz_ukupnogIznosaArtikala_za_radniNalog");

            while (rs.next())
                artikli.add(new StavkaNalog(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return artikli;
    } //

    public List<Usluga> sifarnikUsluga(){ // radi
        List<Usluga> usluge = new ArrayList<>();

        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from usluga");

            while (rs.next())
                usluge.add(new Usluga(rs.getString(1), rs.getString(2), rs.getDouble(3)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return usluge;
    } //

    public List<Artikal> sifarnikArtikala(){ // raddi
        List<Artikal> artikli = new ArrayList<>();

        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            s = c.createStatement();
            rs = s.executeQuery("select * from artikal");

            while (rs.next())
                artikli.add(new Artikal(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return artikli;
    } //

    public List<Usluga> prikazSvihUslugaZaNekiRadniNalog(int idRadniNalog) { // radi
        List<Usluga> usluge = new ArrayList<>();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from ukljucuje_uslugu uu " +
                    "inner join usluga u on uu.sifra=u.sifra where uu.idRadniNalog=?");
            ps.setInt(1, idRadniNalog);
            rs = ps.executeQuery();

            while (rs.next())
                usluge.add(new Usluga(rs.getString(1), rs.getString(5), rs.getInt(2), rs.getDouble(3)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return usluge;
    } //

    public List<Artikal> prikazSvihArtikalaZaNekiRadniNalog(int idRadniNalog) { // radi
        List<Artikal> artikli = new ArrayList<>();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("select * from ukljucuje_artikal ua" +
                    " inner join artikal a on ua.sifra=a.sifra where idRadniNalog=?");
            ps.setInt(1, idRadniNalog);
            rs = ps.executeQuery();

            while (rs.next())
                artikli.add(new Artikal(rs.getString(1), rs.getString(6), rs.getInt(2), rs.getDouble(3), rs.getDouble(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
        return artikli;
    } //

    public int prijava(String korisnickoIme, String korsinickaLozinka) {
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        int idZaposleni = -1;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call prijava(?,?,?,?)}");
            cs.setString(1, korisnickoIme);
            cs.setString(2, korsinickaLozinka);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.registerOutParameter(4, Types.BOOLEAN);

            rs = cs.executeQuery();
            boolean postoji = cs.getBoolean(4);

            if (postoji) {
                idZaposleni = cs.getInt(3);
            }
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
        return idZaposleni;
    }
}



