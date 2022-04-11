/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author oktao
 */
public class Urunler {

    private int id;
    private Kategoriler kategoriler;
    private String baslik;
    private String urundetayi;
    private int kampanyali_fiyati;
    private int normal_fiyati;
    private int stok;

    public Urunler() {
    }

    public Urunler(int id, Kategoriler kategoriler, String baslik, String urundetayi, int kampanyali_fiyati, int normal_fiyati, int stok) {
        this.id = id;
        this.kategoriler = kategoriler;
        this.baslik = baslik;
        this.urundetayi = urundetayi;
        this.kampanyali_fiyati = kampanyali_fiyati;
        this.normal_fiyati = normal_fiyati;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kategoriler getKategoriler() {
        return kategoriler;
    }

    public void setKategoriler(Kategoriler kategoriler) {
        this.kategoriler = kategoriler;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getUrundetayi() {
        return urundetayi;
    }

    public void setUrundetayi(String urundetayi) {
        this.urundetayi = urundetayi;
    }

    public int getKampanyali_fiyati() {
        return kampanyali_fiyati;
    }

    public void setKampanyali_fiyati(int kampanyali_fiyati) {
        this.kampanyali_fiyati = kampanyali_fiyati;
    }

    public int getNormal_fiyati() {
        return normal_fiyati;
    }

    public void setNormal_fiyati(int normal_fiyati) {
        this.normal_fiyati = normal_fiyati;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

}
