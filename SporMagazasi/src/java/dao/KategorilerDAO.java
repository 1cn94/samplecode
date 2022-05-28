/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kategoriler;
import java.sql.Statement;
import java.sql.PreparedStatement;
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

    public List<Kategoriler> getKategorilerList(int page, int pageSize) {
        List<Kategoriler> kategorilerList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from kategoriler order by id  asc limit " + pageSize + "offset " + start);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                kategorilerList.add(new Kategoriler(rs.getInt("id"), rs.getString("kategoriadi")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kategorilerList;
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as kategoriler_count from kategoriler";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("kategoriler_count");
            while (rs.next()) {

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

}
