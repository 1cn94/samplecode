package entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author oktao
 */
public class Kullanicilar {

    private int id;
    private String kuladi;
    private String sifre;
    private String adi;
    private String soyadi;
    private String mail;
    private Timestamp tarih;

    public Kullanicilar() {
    }

    public Kullanicilar(int id, String kuladi, String sifre, String adi, String soyadi, String mail, Timestamp tarih) {
        this.id = id;
        this.kuladi = kuladi;
        this.sifre = sifre;
        this.adi = adi;
        this.soyadi = soyadi;
        this.mail = mail;
        this.tarih = tarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKuladi() {
        return kuladi;
    }

    public void setKuladi(String kuladi) {
        this.kuladi = kuladi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Timestamp getTarih() {
        return tarih;
    }

    public void setTarih(Timestamp tarih) {
        this.tarih = tarih;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final Kullanicilar other = (Kullanicilar) obj;
        return this.id == other.id;
    }
    
    

}
