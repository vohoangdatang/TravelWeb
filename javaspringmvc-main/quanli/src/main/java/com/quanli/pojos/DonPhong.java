/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author AD
 */
@Entity
@Table(name="donphong")
public class DonPhong implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="iduser")
    private User user;
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date ngaytao;
    private String hoten;
    private String email;
    private String sdt;
    @NotNull(message="không được để trống")
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date ngaynhan;
    @NotNull(message="không được để trống")
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date ngaytra;
    private double tongtien;
    private String phuongthuc;
    private String tinhtrang;
    @OneToMany(mappedBy = "donphong")
    private List<CTDonPhong> ctdonphong;

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
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the ngaytao
     */
    public Date getNgaytao() {
        return ngaytao;
    }

    /**
     * @param ngaytao the ngaytao to set
     */
    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    /**
     * @return the hoten
     */
    public String getHoten() {
        return hoten;
    }

    /**
     * @param hoten the hoten to set
     */
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    /**
     * @return the ngaynhan
     */
    public Date getNgaynhan() {
        return ngaynhan;
    }

    /**
     * @param ngaynhan the ngaynhan to set
     */
    public void setNgaynhan(Date ngaynhan) {
        this.ngaynhan = ngaynhan;
    }

    /**
     * @return the ngaytra
     */
    public Date getNgaytra() {
        return ngaytra;
    }

    /**
     * @param ngaytra the ngaytra to set
     */
    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }

    /**
     * @return the tongtien
     */
    public double getTongtien() {
        return tongtien;
    }

    /**
     * @param tongtien the tongtien to set
     */
    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    /**
     * @return the phuongthuc
     */
    public String getPhuongthuc() {
        return phuongthuc;
    }

    /**
     * @param phuongthuc the phuongthuc to set
     */
    public void setPhuongthuc(String phuongthuc) {
        this.phuongthuc = phuongthuc;
    }

    /**
     * @return the tinhtrang
     */
    public String getTinhtrang() {
        return tinhtrang;
    }

    /**
     * @param tinhtrang the tinhtrang to set
     */
    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
