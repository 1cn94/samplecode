/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanicilar;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oktao
 */
public class KullanicilarDAO extends DBConnection {

    public Kullanicilar findByID(int id) {
        Kullanicilar c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from kullanicilar where id =" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                c = new Kullanicilar(rs.getInt("id"), rs.getString("kuladi"), rs.getString("sifre"), rs.getString("adi"), rs.getString("soyadi"), rs.getString("mail"), rs.getTimestamp("tarih"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public void create(Kullanicilar c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into kullanicilar (kuladi,sifre,adi,soyadi,mail) values ('" + c.getKuladi() + "','" + c.getSifre() + "','" + c.getAdi() + "','" + c.getSoyadi() + "','" + c.getMail() + "')";

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Kullanicilar c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "update kullanicilar set kuladi= '" + c.getKuladi() + "' where id= " + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Kullanicilar c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from kullanicilar where id=" + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Kullanicilar> getKullanicilarList(int page, int pageSize) {
        List<Kullanicilar> kullanicilarList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from kullanicilar order by id  asc limit " + pageSize + "offset " + start);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                kullanicilarList.add(new Kullanicilar(rs.getInt("id"), rs.getString("kuladi"), rs.getString("sifre"), rs.getString("adi"), rs.getString("soyadi"), rs.getString("mail"), rs.getTimestamp("tarih")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kullanicilarList;
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as kullanicilar_count from kullanicilar";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("kullanicilar_count");
            while (rs.next()) {

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

}
