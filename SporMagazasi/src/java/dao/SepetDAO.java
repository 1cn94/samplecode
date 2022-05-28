/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Sepet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oktao
 */
public class SepetDAO extends DBConnection {

    public Sepet findByID(int id) {
        Sepet c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from sepet where id =" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                c = new Sepet(rs.getInt("id"), rs.getInt("adet"), rs.getInt("sepetfiyati"), rs.getString("sepetdurum"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public void create(Sepet c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into sepet (adet,sepetfiyati,sepetdurum) values ('" + c.getAdet() + "','" + c.getSepetfiyati() + "','" + c.getSepetdurum() + "')";

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Sepet c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "update sepet set sepetdurum= '" + c.getSepetdurum() + "' where id= " + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Sepet c) {

        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from sepet where id=" + c.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Sepet> getSepetList(int page, int pageSize) {
        List<Sepet> sepetList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from sepet order by id  asc limit " + pageSize + "offset " + start);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                sepetList.add(new Sepet(rs.getInt("id"), rs.getInt("adet"), rs.getInt("sepetfiyati"), rs.getString("sepetdurum")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sepetList;
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as sepet_count from sepet";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("sepet_count");
            while (rs.next()) {

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }


}
