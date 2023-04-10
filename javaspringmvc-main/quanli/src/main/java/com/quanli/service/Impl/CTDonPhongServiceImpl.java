/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.quanli.pojos.CTDonPhong;
import com.quanli.repository.CTDonPhongRepository;
import com.quanli.service.CTDonPhongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class CTDonPhongServiceImpl implements CTDonPhongService{

    @Autowired
    private CTDonPhongRepository cTDonPhongRepository;
    @Override
    public List<CTDonPhong> getCTDonPhong() {
       return this.cTDonPhongRepository.getCTDonPhong();
    }

    @Override
    public List<CTDonPhong> getCTByIdDP(int id) {
       return this.cTDonPhongRepository.getCTByIdDP(id);
    }
    
}
