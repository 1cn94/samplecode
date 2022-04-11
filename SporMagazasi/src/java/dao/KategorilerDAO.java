/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kategoriler;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oktao
 */
public class KategorilerDAO extends DBConnection {

    public Kategoriler findByID(int id) {
        Kategoriler c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from kategoriler where id =" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                c = new Kategoriler(rs.getInt("id"), rs.getString("kategoriadi"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public void create(Kategoriler c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into kategoriler (kategoriadi) values ('" + c.getKategoriadi() + "')";

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Kategoriler c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "update kategoriler set kategoriadi= '" + c.getKategoriadi() + "' where id= " + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Kategoriler c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from kategoriler where id=" + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Kategoriler> getList() {
        List<Kategoriler> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from kategoriler";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Kategoriler(rs.getInt("id"), rs.getString("kategoriadi")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;

    }

}
