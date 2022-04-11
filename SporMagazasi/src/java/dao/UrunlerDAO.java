/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kategoriler;
import entity.Urunler;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oktao
 */
public class UrunlerDAO extends DBConnection {

    private KategorilerDAO kategorilerDao;

    public void create(Urunler c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into urunler (kategoriler_id, baslik, urundetayi,kampanyali_fiyati,Normal_fiyati,stok) values ('" + c.getKategoriler().getId() + "','" + c.getBaslik() + "', '" + c.getUrundetayi() + "','" + c.getKampanyali_fiyati() + "','" + c.getNormal_fiyati() + "','" + c.getStok() + "')";

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Urunler c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "update urunler set kategoriler_id=" + c.getKategoriler().getId() + " ,baslik='" + c.getBaslik() + "', urundetayi='" + c.getUrundetayi() + "', kampanyali_fiyati='" + c.getKampanyali_fiyati() + "',Normal_fiyati='" + c.getNormal_fiyati() + "', stok='" + c.getStok() + "' where id=" + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Urunler c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from urunler where id=" + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Urunler> getList() {
        List<Urunler> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from urunler";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Kategoriler c = this.getKategorilerDao().findByID(rs.getInt("kategoriler_id"));

                list.add(new Urunler(rs.getInt("id"), c, rs.getString("baslik"), rs.getString("urundetayi"), rs.getInt("kampanyali_fiyati"), rs.getInt("Normal_fiyati"), rs.getInt("stok")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;

    }

    public KategorilerDAO getKategorilerDao() {
        if (kategorilerDao == null) {
            kategorilerDao = new KategorilerDAO();
        }
        return kategorilerDao;
    }

    public void setKategorilerDao(KategorilerDAO kategorilerDao) {
        this.kategorilerDao = kategorilerDao;
    }

}
