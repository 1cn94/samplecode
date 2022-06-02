/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BegeniDAO;
import entity.Begeni;
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
public class BegeniBean implements Serializable{
    private Begeni entity;
    private BegeniDAO dao;
    private List<Begeni>list;

    public BegeniBean() {
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
        Begeni c = this.getDao().findByID(id);
        return c.getPuan();

    }
    public void create() {
        this.getDao().create(entity);
        entity = new Begeni();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Begeni();
    }

    public void delete(Begeni c) {
        this.getDao().delete(c);
        entity = new Begeni();
    }

    public Begeni getEntity() {
        if (entity == null) {
            entity = new Begeni();
        }
        return entity;
    }

    public void setEntity(Begeni entity) {
        this.entity = entity;
    }

    public BegeniDAO getDao() {
        if (dao == null) {
            dao = new BegeniDAO();
        }
        return dao;
    }

    public void setDao(BegeniDAO dao) {
        this.dao = dao;
    }

    public List<Begeni> getList() {
        this.list = this.getDao().getBegeniList(page, pageSize);
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(this.list.get(i).getId());
        }
        return list;
    }

    public void setList(List<Begeni> list) {
        this.list = list;
    }
    
    
}
