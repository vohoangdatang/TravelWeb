/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.pojos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author AD
 */
@Entity
@Table(name="ctdonphong")
public class CTDonPhong implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="iddonphong")
    private DonPhong donphong;
    @ManyToOne
    @JoinColumn(name="idphong")
    private Phong  idphong;
    private int soluong;
    private double gia;
    private boolean tinhtrang;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the donphong
     */
    public DonPhong getDonphong() {
        return donphong;
    }

    /**
     * @param donphong the donphong to set
     */
    public void setDonphong(DonPhong donphong) {
        this.donphong = donphong;
    }

    /**
     * @return the phong
     */
    public Phong getPhong() {
        return idphong;
    }

    /**
     * @param phong the phong to set
     */
    public void setPhong(Phong phong) {
        this.idphong = phong;
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
     * @return the gia
     */
    public double getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(double gia) {
        this.gia = gia;
    }

    /**
     * @return the tinhtrang
     */
    public boolean isTinhtrang() {
        return tinhtrang;
    }

    /**
     * @param tinhtrang the tinhtrang to set
     */
    public void setTinhtrang(boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
            
    
}
