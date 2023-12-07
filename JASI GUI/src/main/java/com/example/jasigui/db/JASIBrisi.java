package com.example.jasigui.db;

import java.sql.*;

public class JASIBrisi {
    public void brisiUsluguSaRadnogNaloga(int idRadniNalog,String sifra){ // RADI
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call brisanje_usluge_sa_radnogNaloga(?,?)}");
                cs.setInt(1, idRadniNalog);
                cs.setString(2,sifra);

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

    public void brisiArtikalSaRadnogNaloga(int idRadniNalog,String sifra){ // RADI
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call brisanje_artikla_sa_radnogNaloga(?,?)}");
                 cs.setInt(1, idRadniNalog);
                 cs.setString(2,sifra);

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

    public void brisiZaduzenje(int idZaduzenje){
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("delete from zaduzenje where idZaduzenje=?");
                ps.setInt(1, idZaduzenje);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //

    public void brisiRadniNalog(int idRadniNalog){
        Connection c = null;
        CallableStatement cs = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            cs = c.prepareCall("{call brisanje_radnog_naloga(?)}");
                cs.setInt(1,idRadniNalog);

            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //

    public void brisiUsluguIzSifarnika(String sifra){
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("delete from usluga where sifra=?");
            ps.setString(1, sifra);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //

    public void brisiArtikalIzSifarnika(String sifra){
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = ConnectionPool.getInstance().checkOut();
            ps = c.prepareStatement("delete from artikal where sifra=?");
            ps.setString(1, sifra);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            ConnectionPool.getInstance().checkIn(c);
        }
    } //
}

