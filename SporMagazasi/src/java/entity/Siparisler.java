/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author oktao
 */
public class Siparisler {
    private int id;
    private Kullanicilar kullanicilar;
    private int fiyat;
    private String siparisdurumu;

    public Siparisler() {
    }

    public Siparisler(int id, Kullanicilar kullanicilar, int fiyat, String siparisdurumu) {
        this.id = id;
        this.kullanicilar = kullanicilar;
        this.fiyat = fiyat;
        this.siparisdurumu = siparisdurumu;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getSiparisdurumu() {
        return siparisdurumu;
    }

    public void setSiparisdurumu(String siparisdurumu) {
        this.siparisdurumu = siparisdurumu;
    }

    public Kullanicilar getKullanicilar() {
        return kullanicilar;
    }

    public void setKullanicilar(Kullanicilar kullanicilar) {
        this.kullanicilar = kullanicilar;
    }
    
    
    
    
}
