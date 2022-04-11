/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author oktao
 */
public class Sepet {
    private int id;
    private int adet;
    private int sepetfiyati;
    private String sepetdurum;

    public Sepet() {
    }

    public Sepet(int id, int adet, int sepetfiyati, String sepetdurum) {
        this.id = id;
        this.adet = adet;
        this.sepetfiyati = sepetfiyati;
        this.sepetdurum = sepetdurum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public int getSepetfiyati() {
        return sepetfiyati;
    }

    public void setSepetfiyati(int sepetfiyati) {
        this.sepetfiyati = sepetfiyati;
    }

    public String getSepetdurum() {
        return sepetdurum;
    }

    public void setSepetdurum(String sepetdurum) {
        this.sepetdurum = sepetdurum;
    }
    
    
        
    
    
}
