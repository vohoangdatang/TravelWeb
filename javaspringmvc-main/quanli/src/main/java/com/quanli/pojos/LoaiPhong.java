/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author AD
 */
@Entity
@Table(name="loaiphong")
public class LoaiPhong implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idloaiphong;
    private String tenLoaiPhong;
    private String hinhanh;
    @OneToMany(mappedBy="loaiphong")
    private List<Phong> phongs;

    /**
     * @return the idloaiphong
     */
    public int getIdloaiphong() {
        return idloaiphong;
    }

    /**
     * @param idloaiphong the idloaiphong to set
     */
    public void setIdloaiphong(int idloaiphong) {
        this.idloaiphong = idloaiphong;
    }

    /**
     * @return the tenLoaiPhong
     */
    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    /**
     * @param tenLoaiPhong the tenLoaiPhong to set
     */
    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    /**
     * @return the phongs
     */
    public List<Phong> getPhongs() {
        return phongs;
    }

    /**
     * @param phongs the phongs to set
     */
    public void setPhongs(List<Phong> phongs) {
        this.phongs = phongs;
    }

    /**
     * @return the hinhanh
     */
    public String getHinhanh() {
        return hinhanh;
    }

    /**
     * @param hinhanh the hinhanh to set
     */
    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
