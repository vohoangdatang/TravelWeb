/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author AD
 */
@Entity
@Table(name="danhgia")
public class DanhGia implements Serializable{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    private String noidung;
    @NotNull(message = "{notNull.Err}")
    @ManyToOne
    @JoinColumn(name="idU")
    private User user;
    @NotNull(message = "{notNull.Err}")
    @ManyToOne
    @JoinColumn(name="idCX")
    private ChuyenXe cx;
    private int sao;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date ngaytao;

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
     * @return the noidung
     */
    public String getNoidung() {
        return noidung;
    }

    /**
     * @param noidung the noidung to set
     */
    public void setNoidung(String noidung) {
        this.noidung = noidung;
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
     * @return the sao
     */
    public int getSao() {
        return sao;
    }

    /**
     * @param sao the sao to set
     */
    public void setSao(int sao) {
        this.sao = sao;
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
     * @return the cx
     */
    public ChuyenXe getCx() {
        return cx;
    }

    /**
     * @param cx the cx to set
     */
    public void setCx(ChuyenXe cx) {
        this.cx = cx;
    }
    
}
