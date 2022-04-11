/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KategorilerDAO;
import entity.Kategoriler;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author oktao
 */
//@FacesConverter("kategorilerConverter")
@FacesConverter("kategorilerConverter")
public class KategorilerConverter implements Converter {

    private KategorilerDAO kategorilerDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Kategoriler c = this.getKategorilerDao().findByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kategoriler c = (Kategoriler) t;
        return String.valueOf(c.getId());

    }

    public KategorilerDAO getKategorilerDao() {
        if (kategorilerDao == null) {
            this.kategorilerDao = new KategorilerDAO();
        }
        return kategorilerDao;
    }

    public void setKategorilerDao(KategorilerDAO kategorilerDao) {
        this.kategorilerDao = kategorilerDao;
    }

}
