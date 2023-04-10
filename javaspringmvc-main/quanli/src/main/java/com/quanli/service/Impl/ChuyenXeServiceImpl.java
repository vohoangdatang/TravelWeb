/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.quanli.pojos.ChuyenXe;
import com.quanli.repository.ChuyenXeRepository;
import com.quanli.service.ChuyenXeService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class ChuyenXeServiceImpl implements ChuyenXeService{

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ChuyenXeRepository chuyenXeRepository;
    @Override
    public void addCX(ChuyenXe chuyenxe) {
         try{
          Map r = cloudinary.uploader().upload(chuyenxe.getFile().getBytes(),
                ObjectUtils.asMap("resource_type","auto"));
            String img = (String) r.get("secure_url");
            System.err.println(img);
            chuyenxe.setHinhanh(img);
            this.chuyenXeRepository.addCX(chuyenxe);
            }catch(IOException ex)
        {
            System.err.println("loi:" + ex.getMessage());
        }
    }

    @Override
    public List<ChuyenXe> getKS() {
        return this.chuyenXeRepository.getKS();
    }

    @Override
    public void deleteCX(int id) {
        this.chuyenXeRepository.deleteCX(id);
    }

    @Override
    public List<ChuyenXe> getChuyenXeByTP(String string) {
        return this.chuyenXeRepository.getChuyenXeByTP(string);
    }

    @Override
    public List<ChuyenXe> getChuyenXediByTP(int string) {
        return this.getChuyenXediByTP(string);
    }

    @Override
    public ChuyenXe getChuyenXeById(int i) {
        return this.chuyenXeRepository.getChuyenXeById(i);
    }

    @Override
    public void updateCX(ChuyenXe cx) {
        this.chuyenXeRepository.updateCX(cx);
    }

    @Override
    public List<ChuyenXe> getKSTop4(int page) {
        return this.chuyenXeRepository.getKSTop4(page);
    }
    
}
