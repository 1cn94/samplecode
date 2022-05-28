/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SepetDAO;
import entity.Sepet;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

import java.util.List;

/**
 *
 * @author oktao
 */
@Named
@SessionScoped
public class SepetBean implements Serializable {

    private Sepet entity;
    private SepetDAO dao;
    private List<Sepet> list;

    /**
     * Creates a new instance of SepetBean
     */
    public SepetBean() {
    }
    private int page = 1;
    private int pageSize = 1;
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
        Sepet c = this.getDao().findByID(id);
        return c.getSepetdurum();

    }

    public void create() {
        this.getDao().create(entity);
        entity = new Sepet();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Sepet();
    }

    public void delete(Sepet c) {
        this.getDao().delete(c);
        entity = new Sepet();
    }

    public Sepet getEntity() {
        if (entity == null) {
            entity = new Sepet();
        }
        return entity;
    }

    public void setEntity(Sepet entity) {
        this.entity = entity;
    }

    public SepetDAO getDao() {
        if (dao == null) {
            dao = new SepetDAO();
        }
        return dao;
    }

    public void setDao(SepetDAO dao) {
        this.dao = dao;
    }

    public List<Sepet> getList() {
        this.list = this.getDao().getSepetList(page, pageSize);
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(this.list.get(i).getId());
        }
        return list;
    }

    public void setList(List<Sepet> list) {
        this.list = list;
    }

}
