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
    private int page = 1;
    private int pageSize = 3;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }

    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
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
        this.list = this.getDao().getKategorilerList(page, pageSize);
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(this.list.get(i).getId());
        }
        return list;
    }

    public void setList(List<Kategoriler> list) {
        this.list = list;
    }

}
