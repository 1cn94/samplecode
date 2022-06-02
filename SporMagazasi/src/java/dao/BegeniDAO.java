/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Begeni;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oktao
 */
public class BegeniDAO extends DBConnection {

    public Begeni findByID(int id) {
        Begeni c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from begeni where id =" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                c = new Begeni(rs.getInt("id"), rs.getString("puan"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public void create(Begeni c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into begeni (puan) values ('" + c.getPuan()  + "')";

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Begeni c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "update begeni set puan= '" + c.getPuan() + "' where id= " + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Begeni c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from begeni where id=" + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Begeni> getBegeniList(int page, int pageSize) {
        List<Begeni> begeniList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from begeni order by id  asc limit " + pageSize + "offset " + start);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                begeniList.add(new Begeni(rs.getInt("id"), rs.getString("puan")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return begeniList;
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as begeni_count from begeni";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("begeni_count");
            while (rs.next()) {

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }


}
