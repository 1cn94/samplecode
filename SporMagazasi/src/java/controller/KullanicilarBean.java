/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KullanicilarDAO;
import entity.Kullanicilar;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Named(value = "kullanicilarBean")
@SessionScoped
public class KullanicilarBean implements Serializable {

    private Kullanicilar entity;
    private KullanicilarDAO dao;
    private List<Kullanicilar> list;

    private int page = 1;
    private int pageSize = 3;
    private int pageCount;

    public KullanicilarBean() {
    }

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

    public String getKuladi(int id) {
        Kullanicilar c = this.getDao().findByID(id);
        return c.getKuladi();

    }

    public String getSifre(int id) {
        Kullanicilar c = this.getDao().findByID(id);
        return c.getSifre();

    }

    public String getAdi(int id) {
        Kullanicilar c = this.getDao().findByID(id);
        return c.getAdi();

    }

    public String getSoyadi(int id) {
        Kullanicilar c = this.getDao().findByID(id);
        return c.getSoyadi();

    }

    public String getMail(int id) {
        Kullanicilar c = this.getDao().findByID(id);
        return c.getMail();

    }

    public void create() {
        this.getDao().create(entity);
        entity = new Kullanicilar();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kullanicilar();
    }

    public void delete(Kullanicilar c) {
        this.getDao().delete(c);
        entity = new Kullanicilar();
    }

    public Kullanicilar getEntity() {
        if (entity == null) {
            entity = new Kullanicilar();
        }
        return entity;
    }

    public void setEntity(Kullanicilar entity) {
        this.entity = entity;
    }

    public KullanicilarDAO getDao() {
        if (dao == null) {
            dao = new KullanicilarDAO();
        }
        return dao;
    }

    public void setDao(KullanicilarDAO dao) {
        this.dao = dao;
    }

    public List<Kullanicilar> getList() {
        this.list = this.getDao().getKullanicilarList(page, pageSize);
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(this.list.get(i).getId());
        }
        return list;
    }

    public void setList(List<Kullanicilar> list) {
        this.list = list;
    }

}
