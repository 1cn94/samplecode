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
    private int page = 1;
    private int pageSize = 2;
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
        this.list = this.getDao().getSiparislerList(page, pageSize);
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(this.list.get(i).getId());
        }
        return list;
    }

    public void setList(List<Siparisler> list) {
        this.list = list;
    }


}
