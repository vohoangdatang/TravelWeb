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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AD
 */
@Entity
@Table(name="chuyenxe")
public class ChuyenXe implements Serializable {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int idCX;
    private String tenCX;
    private String mota;
    private String hinhanh;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date ngaydi;
    private String diemdi;
    private String diemden;
    private long giaghe;
    private int soluong;
    @ManyToOne
    @JoinColumn(name="idTX")
    private User user;
    @Transient
    private MultipartFile file;
     
    @OneToMany(mappedBy = "chuyenxe")
    private List<CTDonTour> doncx;
    @OneToMany(mappedBy = "cx")
    private List<DanhGia> dgchuyenxe;
    /**
     * @return the idCX
     */
    public int getIdCX() {
        return idCX;
    }

    /**
     * @param idCX the idCX to set
     */
    public void setIdCX(int idCX) {
        this.idCX = idCX;
    }

    /**
     * @return the tenCX
     */
    public String getTenCX() {
        return tenCX;
    }

    /**
     * @param tenCX the tenCX to set
     */
    public void setTenCX(String tenCX) {
        this.tenCX = tenCX;
    }

    /**
     * @return the mota
     */
    public String getMota() {
        return mota;
    }

    /**
     * @param mota the mota to set
     */
    public void setMota(String mota) {
        this.mota = mota;
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

    /**
     * @return the ngaydi
     */
    public Date getNgaydi() {
        return ngaydi;
    }

    /**
     * @param ngaydi the ngaydi to set
     */
    public void setNgaydi(Date ngaydi) {
        this.ngaydi = ngaydi;
    }

    /**
     * @return the diemdi
     */
    public String getDiemdi() {
        return diemdi;
    }

    /**
     * @param diemdi the diemdi to set
     */
    public void setDiemdi(String diemdi) {
        this.diemdi = diemdi;
    }

    /**
     * @return the diemden
     */
    public String getDiemden() {
        return diemden;
    }

    /**
     * @param diemden the diemden to set
     */
    public void setDiemden(String diemden) {
        this.diemden = diemden;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the giaghe
     */
    public long getGiaghe() {
        return giaghe;
    }

    /**
     * @param giaghe the giaghe to set
     */
    public void setGiaghe(long giaghe) {
        this.giaghe = giaghe;
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



   
    
    
}
