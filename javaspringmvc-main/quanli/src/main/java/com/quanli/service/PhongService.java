/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service;

import com.quanli.pojos.Phong;
import java.util.List;

/**
 *
 * @author AD
 */
public interface PhongService {
    List<Phong> getPhong();
    void addPhong(Phong phong);
    void update(Phong p);
    void delete(int id);
    Phong getPhongById(int id);
    List<Phong> getPhongByIdKS(int id);
    List<Phong> getPhongByLP(String lp);
    Phong phongDaDat(int id);
    Phong phongHuy(int id);
}
