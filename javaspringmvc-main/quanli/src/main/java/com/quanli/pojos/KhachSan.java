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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AD
 */
@Entity
@Table(name="khachsan")
public class KhachSan implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idkhachsan;
    private String tenKS;
    private String thanhPho;
    private String diachi;
    private String hinhanh;
    @OneToMany(mappedBy="khachsan")
    private List<Phong> phongks;
    @Transient
    private MultipartFile file;
    /**
     * @return the idkhachsan
     */
    public int getIdkhachsan() {
        return idkhachsan;
    }

    /**
     * @param idkhachsan the idkhachsan to set
     */
    public void setIdkhachsan(int idkhachsan) {
        this.idkhachsan = idkhachsan;
    }

    /**
     * @return the tenKS
     */
    public String getTenKS() {
        return tenKS;
    }

    /**
     * @param tenKS the tenKS to set
     */
    public void setTenKS(String tenKS) {
        this.tenKS = tenKS;
    }

    /**
     * @return the thanhPho
     */
    public String getThanhPho() {
        return thanhPho;
    }

    /**
     * @param thanhPho the thanhPho to set
     */
    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    /**
     * @return the diachi
     */
    public String getDiachi() {
        return diachi;
    }

    /**
     * @param diachi the diachi to set
     */
    public void setDiachi(String diachi) {
        this.diachi = diachi;
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

    
   

}
