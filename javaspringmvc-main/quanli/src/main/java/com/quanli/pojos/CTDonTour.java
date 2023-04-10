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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author AD
 */
@Entity
@Table(name="ctdontour")
public class CTDonTour implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="iddontour")
    private DonTour dontour;
    @ManyToOne
    @JoinColumn(name="idtour")
    private ChuyenXe chuyenxe;
    private int soluong;
    private long gia;

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
     * @return the dontour
     */
    public DonTour getDontour() {
        return dontour;
    }

    /**
     * @param dontour the dontour to set
     */
    public void setDontour(DonTour dontour) {
        this.dontour = dontour;
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
    public long getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(long gia) {
        this.gia = gia;
    }

    /**
     * @return the chuyenxe
     */
    public ChuyenXe getChuyenxe() {
        return chuyenxe;
    }

    /**
     * @param chuyenxe the chuyenxe to set
     */
    public void setChuyenxe(ChuyenXe chuyenxe) {
        this.chuyenxe = chuyenxe;
    }
    
}
