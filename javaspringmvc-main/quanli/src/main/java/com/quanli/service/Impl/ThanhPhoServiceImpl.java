/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.quanli.pojos.ThanhPho;
import com.quanli.repository.ThanhPhoRepository;
import com.quanli.service.ThanhPhoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class ThanhPhoServiceImpl implements ThanhPhoService{

    @Autowired
    private ThanhPhoRepository thanhPhoRepository;
    @Override
    public List<ThanhPho> getAllTP() {
        return this.thanhPhoRepository.getAllTP();
    }
    
}
