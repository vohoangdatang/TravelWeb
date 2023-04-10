/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.quanli.pojos.KhachSan;
import com.quanli.repository.KhachSanRepository;
import com.quanli.service.KhachSanService;
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
public class KhachSanServiceImpl implements KhachSanService{

    @Autowired
    private KhachSanRepository khachSanRepository;
    @Autowired
    private Cloudinary cloudinary;
    @Override
    public List<KhachSan> getKS() {
        return this.khachSanRepository.getKS();
    }

    @Override
    public void addPhong(KhachSan ks) {
         try{
          Map r = cloudinary.uploader().upload(ks.getFile().getBytes(),
                ObjectUtils.asMap("resource_type","auto"));
            String img = (String) r.get("secure_url");
            System.err.println(img);
            ks.setHinhanh(img);
            this.khachSanRepository.addPhong(ks);
            }catch(IOException ex)
        {
            System.err.println("loi:" + ex.getMessage());
        }
    }

    @Override
    public void update(KhachSan ks) {
      this.khachSanRepository.update(ks);
    }

    @Override
    public void delete(int id) {
        this.khachSanRepository.delete(id);
    }

    @Override
    public List<KhachSan> getKhachSanByTP(String lp) {
        return this.khachSanRepository.getKhachSanByTP(lp);
    }

    @Override
    public KhachSan getKSById(int i) {
     return this.khachSanRepository.getKSById(i);
    }

    @Override
    public List<KhachSan> getksmoinhat(int page) {
       return this.khachSanRepository.getksmoinhat(page);
    }

    @Override
    public boolean checkupdate(KhachSan ks) {
        this.khachSanRepository.update(ks);
        return true;
    }

    @Override
    public List<KhachSan> getKSTop8(int i) {
       return this.khachSanRepository.getKSTop8(i);
    }

   
    
}
