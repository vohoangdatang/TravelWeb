/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.pojos;

import java.math.BigDecimal;

/**
 *
 * @author AD
 */
public class Cart {
    private Phong phong;
    private int soluong;
    private int phongid;
    private String name;
    private BigDecimal gia;
    private Tour tour;
    public Cart(){
        
    }
    public Cart(Tour tour ,int soluong)
    {
        this.tour=tour;
        this.soluong=soluong;
    }
    public Cart(Phong phong ,int soluong)
    {
        this.phong=phong;
        this.soluong=soluong;
    }

    /**
     * @return the phong
     */
    public Phong getPhong() {
        return phong;
    }

    /**
     * @param phong the phong to set
     */
    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    /**
     * @return the soluong
     */
    public int getSoluong() {
        return soluong;
    }

    /**
     * @param soluong the soluong to set
     */
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    /**
     * @return the phongid
     */
    public int getPhongid() {
        return phongid;
    }

    /**
     * @param phongid the phongid to set
     */
    public void setPhongid(int phongid) {
        this.phongid = phongid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gia
     */
    public BigDecimal getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    /**
     * @return the tour
     */
    public Tour getTour() {
        return tour;
    }

    /**
     * @param tour the tour to set
     */
    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
