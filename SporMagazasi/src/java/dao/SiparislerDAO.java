/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanicilar;
import entity.Siparisler;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oktao
 */
public class SiparislerDAO extends DBConnection {

    private KullanicilarDAO kullanicilarDao;

    public void create(Siparisler c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into siparisler (kullanicilar_id, fiyat, siparisdurumu) values ('" + c.getKullanicilar().getId() + "','" + c.getFiyat() + "', '" + c.getSiparisdurumu() + "')";

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Siparisler c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "update siparisler set kullanicilar_id=" + c.getKullanicilar().getId() + " ,fiyat='" + c.getFiyat() + "', siparisdurumu='" + c.getSiparisdurumu() + "' where id=" + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Siparisler c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from siparisler where id=" + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Siparisler> getList() {
        List<Siparisler> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from siparisler";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Kullanicilar c = this.getKullanicilarDao().findByID(rs.getInt("kullanicilar_id"));

                list.add(new Siparisler(rs.getInt("id"), c, rs.getInt("fiyat"), rs.getString("siparisdurumu")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;

    }

    public KullanicilarDAO getKullanicilarDao() {
        if (kullanicilarDao == null) {
            this.kullanicilarDao = new KullanicilarDAO();
        }
        return kullanicilarDao;
    }

    public void setKullanicilarDao(KullanicilarDAO kullanicilarDao) {
        this.kullanicilarDao = kullanicilarDao;
    }

}
