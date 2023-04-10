/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.quanli.pojos.CTDonTour;
import com.quanli.repository.CTDTRepository;
import com.quanli.service.CTDTService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class CTDTServiceImpl implements CTDTService{

    @Autowired
    private CTDTRepository cTDTRepository;
    @Override
    public List<CTDonTour> getCTByIdDP(int id) {
      return this.cTDTRepository.getCTByIdDP(id);
    }
    
}
