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
import javax.persistence.Table;

/**
 *
 * @author AD
 */
@Entity
@Table(name="thanhpho")
public class ThanhPho implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idthanhpho;
    private String tentp;

    /**
     * @return the idthanhpho
     */
    public int getIdthanhpho() {
        return idthanhpho;
    }

    /**
     * @param idthanhpho the idthanhpho to set
     */
    public void setIdthanhpho(int idthanhpho) {
        this.idthanhpho = idthanhpho;
    }

    /**
     * @return the tentp
     */
    public String getTentp() {
        return tentp;
    }

    /**
     * @param tentp the tentp to set
     */
    public void setTentp(String tentp) {
        this.tentp = tentp;
    }
}
