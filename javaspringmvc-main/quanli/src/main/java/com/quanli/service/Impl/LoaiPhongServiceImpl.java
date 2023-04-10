/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.quanli.pojos.LoaiPhong;
import com.quanli.repository.LoaiPhongRepository;
import com.quanli.service.LoaiPhongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class LoaiPhongServiceImpl implements LoaiPhongService{

    @Autowired
    private LoaiPhongRepository loaiPhongRepository;
    @Override
    public List<LoaiPhong> getLP() {
        return this.loaiPhongRepository.getLP();
    }

    @Override
    public void addLP(LoaiPhong lp) {
        this.loaiPhongRepository.addLP(lp);
    }

    @Override
    public void update(LoaiPhong lp) {
        this.loaiPhongRepository.update(lp);
    }

    @Override
    public void delete(int id) {
       this.loaiPhongRepository.delete(id);
    }
    
}
