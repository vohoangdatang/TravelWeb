/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.quanli.pojos.CartXe;
import com.quanli.pojos.DonTour;
import com.quanli.repository.DonTourRepository;
import com.quanli.service.DonTourService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class DonTourServiceImpl implements DonTourService{

    @Autowired
    private DonTourRepository donTourRepository;
    @Override
    public List<DonTour> getDoanhThu() {
       return this.donTourRepository.getDoanhThu();
    }

    @Override
    public List<DonTour> getLishSuById(int id) {
        return this.donTourRepository.getLishSuById(id);
    }

    @Override
    public List<DonTour> getAllDonTour() {
        return this.donTourRepository.getAllDonTour();
    }

    @Override
    public void xoa(int id) {
        this.donTourRepository.xoa(id);
    }

    @Override
    public DonTour getDTById(int id) {
       return this.donTourRepository.getDTById(id);
    }

    @Override
    public void update(DonTour donphong) {
        this.donTourRepository.update(donphong);
    }

    @Override
    public boolean addDonCX(Map<Integer, CartXe> cart,int id) {
        if(cart !=null)
        return  this.donTourRepository.addDonCX(cart,id);
        else 
            return false;
    }

    @Override
    public List<DonTour> getDoanhThuTheoThang(int thang) {
       return this.donTourRepository.getDoanhThuTheoThang(thang);
    }

   
    
}
