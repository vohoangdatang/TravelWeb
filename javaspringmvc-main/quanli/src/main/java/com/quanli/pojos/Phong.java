/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author AD
 */
@Entity
@Table(name="phong")
@JsonRootName(value = "phongs")
public class Phong implements Serializable{

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhong;
    private String tenPhong;
    private long giaPhong;
    private boolean tinhTrang;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idLoaiPhong")
    private LoaiPhong loaiphong;
   
    @ManyToOne
    @JoinColumn(name="idKhachSan")
    private KhachSan khachsan;
    @OneToMany(mappedBy = "idphong")
    private List<CTDonPhong> phongct;
    /**
     * @return the idPhong
     */
    public int getIdPhong() {
        return idPhong;
    }

    /**
     * @param idPhong the idPhong to set
     */
    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    /**
     * @return the tenPhong
     */
    public String getTenPhong() {
        return tenPhong;
    }

    /**
     * @param tenPhong the tenPhong to set
     */
    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    /**
     * @return the giaPhong
     */
    public long getGiaPhong() {
        return giaPhong;
    }

    /**
     * @param giaPhong the giaPhong to set
     */
    public void setGiaPhong(long giaPhong) {
        this.giaPhong = giaPhong;
    }

    /**
     * @return the tinhTrang
     */
    public boolean isTinhTrang() {
        return tinhTrang;
    }

    /**
     * @param tinhTrang the tinhTrang to set
     */
    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    /**
     * @return the loaiphong
     */
    public LoaiPhong getLoaiphong() {
        return loaiphong;
    }

    /**
     * @param loaiphong the loaiphong to set
     */
    public void setLoaiphong(LoaiPhong loaiphong) {
        this.loaiphong = loaiphong;
    }

    /**
     * @return the khachsan
     */
    public KhachSan getKhachsan() {
        return khachsan;
    }

    /**
     * @param khachsan the khachsan to set
     */
    public void setKhachsan(KhachSan khachsan) {
        this.khachsan = khachsan;
    }

   

    
}
