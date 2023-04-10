/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.quanli.pojos.DanhGia;
import com.quanli.repository.ChuyenXeRepository;
import com.quanli.repository.DanhGiaRepository;
import com.quanli.service.DanhGiaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class DanhGiaServiceImpl implements DanhGiaService{

    @Autowired
    private DanhGiaRepository danhGiaRepository;
    @Autowired
    private ChuyenXeRepository chuyenXeRepository;
    @Override
    public void addDG(DanhGia dg) {
        //dg.setChuyenxe(this.chuyenXeRepository.getChuyenXeById(7));
        dg.setNgaytao(new Date());
        this.danhGiaRepository.addDG(dg);
    }

    @Override
    public List<DanhGia> getDanhGiaByCX(int i) {
       return this.danhGiaRepository.getDanhGiaByCX(i);
    }

   
    
}
