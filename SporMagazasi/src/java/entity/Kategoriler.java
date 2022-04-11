/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author oktao
 */
public class Kategoriler {

    private int id;
    private String kategoriadi;

    public Kategoriler() {
    }

    public Kategoriler(int id, String kategoriadi) {
        this.id = id;
        this.kategoriadi = kategoriadi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKategoriadi() {
        return kategoriadi;
    }

    public void setKategoriadi(String kategoriadi) {
        this.kategoriadi = kategoriadi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kategoriler other = (Kategoriler) obj;
        return this.id == other.id;
    }

}
