/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.quanli.pojos.Phong;
import com.quanli.repository.PhongRepository;
import com.quanli.service.PhongService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class PhongServiceImpl implements PhongService{

    @Autowired
    private PhongRepository phongRepository;
    @Override
    public List<Phong> getPhong() {
        return this.phongRepository.getPhong();
    }

    @Override
    public void addPhong(Phong phong) {
        phong.setTinhTrang(true);
        this.phongRepository.addPhong(phong);
       
       
    }

    @Override
    public void update(Phong phong) {
        phong.setTinhTrang(true);
        this.phongRepository.update(phong);
    }

    @Override
    public void delete(int i) {
           this.phongRepository.delete(i);
           
    }

    @Override
    public Phong getPhongById(int i) {
      return this.phongRepository.getPhongById(i);
    }

    @Override
    public List<Phong> getPhongByIdKS(int i) {
       return this.phongRepository.getPhongByIdKS(i);
    }

    @Override
    public List<Phong> getPhongByLP(String string) {
        return this.phongRepository.getPhongByLP(string);
    }

    @Override
    public Phong phongDaDat(int id) {
        return this.phongRepository.phongDaDat(id);
    }

    @Override
    public Phong phongHuy(int i) {
        return this.phongRepository.phongHuy(i);
    }

   
}
