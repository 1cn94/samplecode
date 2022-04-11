/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SiparislerDAO;
import entity.Siparisler;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author oktao
 */
@Named
@SessionScoped
public class SiparislerBean implements Serializable {

    private Siparisler entity;
    private SiparislerDAO dao;
    private List<Siparisler> list;

    /**
     * Creates a new instance of SiparislerBean
     */
    public SiparislerBean() {
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Siparisler();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Siparisler();
    }

    public void delete(Siparisler p) {
        this.getDao().delete(p);
        entity = new Siparisler();
    }

    public Siparisler getEntity() {
        if (entity == null) {
            entity = new Siparisler();
        }
        return entity;
    }

    public void setEntity(Siparisler entity) {
        this.entity = entity;
    }

    public SiparislerDAO getDao() {
        if (dao == null) {
            dao = new SiparislerDAO();
        }
        return dao;
    }

    public void setDao(SiparislerDAO dao) {
        this.dao = dao;
    }

    public List<Siparisler> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Siparisler> list) {
        this.list = list;
    }

}
