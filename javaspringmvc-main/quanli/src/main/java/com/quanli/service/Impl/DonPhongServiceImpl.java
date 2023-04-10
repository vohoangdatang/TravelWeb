/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.quanli.pojos.DonPhong;
import com.quanli.repository.DonPhongRepository;
import com.quanli.service.DonPhongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class DonPhongServiceImpl implements DonPhongService{

    @Autowired
    private DonPhongRepository donPhongRepository;

    @Override
    public List<DonPhong> getDonPhong() {
        return this.donPhongRepository.getDonPhong();
    }

    @Override
    public List<DonPhong> getDoanhThuTheoKS() {
      return this.donPhongRepository.getDoanhThuTheoKS();
    }

    @Override
    public List<DonPhong> getLishSuById(String id) {
       return this.donPhongRepository.getLishSuById(id);
    }

    @Override
    public List<DonPhong> getAllDonPhong() {
        return this.donPhongRepository.getAllDonPhong() ;
    }

    @Override
    public void xoa(int  id) {
       this.donPhongRepository.xoa(id);
    }

    @Override
    public DonPhong getDPById(int i) {
       return this.donPhongRepository.getDPById(i);
    }

    @Override
    public void update(DonPhong dp) {
        this.donPhongRepository.update(dp);
    }
    
    
}
