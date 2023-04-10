/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AD
 */
@Entity
@Table(name="tour")
public class Tour implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtour;
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nametour")
    private String nametour;
    @NotNull
    @Size(min = 1, max = 45)
    private String place;
    @NotNull
    @Size(min = 1, max = 500)
    private String description;
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date start;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date finish;
    @NotNull
    private long price;
    private Integer quantity;
    private String phuongtien;
    private String image;
    @Transient
    private MultipartFile file;

    /**
     * @return the idtour
     */
    public Integer getIdtour() {
        return idtour;
    }

    /**
     * @param idtour the idtour to set
     */
    public void setIdtour(Integer idtour) {
        this.idtour = idtour;
    }

    /**
     * @return the nametour
     */
    public String getNametour() {
        return nametour;
    }

    /**
     * @param nametour the nametour to set
     */
    public void setNametour(String nametour) {
        this.nametour = nametour;
    }

    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * @return the finish
     */
    public Date getFinish() {
        return finish;
    }

    /**
     * @param finish the finish to set
     */
    public void setFinish(Date finish) {
        this.finish = finish;
    }

    /**
     * @return the price
     */
    public long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(long price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the phuongtien
     */
    public String getPhuongtien() {
        return phuongtien;
    }

    /**
     * @param phuongtien the phuongtien to set
     */
    public void setPhuongtien(String phuongtien) {
        this.phuongtien = phuongtien;
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
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
}
