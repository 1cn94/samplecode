/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KategorilerDAO;
import entity.Kategoriler;
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
public class KategorilerBean implements Serializable {

    private Kategoriler entity;
    private KategorilerDAO dao;
    private List<Kategoriler> list;

    /**
     * Creates a new instance of KategorilerBean
     */
    public KategorilerBean() {
    }

    public String getTitle(int id) {
        Kategoriler c = this.getDao().findByID(id);
        return c.getKategoriadi();

    }

    public void create() {
        this.getDao().create(entity);
        entity = new Kategoriler();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kategoriler();
    }

    public void delete(Kategoriler c) {
        this.getDao().delete(c);
        entity = new Kategoriler();
    }

    public Kategoriler getEntity() {
        if (entity == null) {
            entity = new Kategoriler();
        }
        return entity;
    }

    public void setEntity(Kategoriler entity) {
        this.entity = entity;
    }

    public KategorilerDAO getDao() {
        if (dao == null) {
            dao = new KategorilerDAO();
        }
        return dao;
    }

    public void setDao(KategorilerDAO dao) {
        this.dao = dao;
    }

    public List<Kategoriler> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kategoriler> list) {
        this.list = list;
    }

}
