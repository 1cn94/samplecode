/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KullanicilarDAO;
import entity.Kullanicilar;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author oktao
 */
@FacesConverter("kullanicilarConverter")
public class KullanicilarConverter implements Converter {

    private KullanicilarDAO kullanicilarDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Kullanicilar c = this.getKullanicilarDao().findByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kullanicilar c = (Kullanicilar) t;
        return String.valueOf(c.getId());
    }

    public KullanicilarDAO getKullanicilarDao() {
        if (kullanicilarDao == null) {
            this.kullanicilarDao = new KullanicilarDAO();
        }
        return kullanicilarDao;
    }

    public void setKullanicilarDao(KullanicilarDAO kullanicilarDao) {
        this.kullanicilarDao = kullanicilarDao;
    }

}
