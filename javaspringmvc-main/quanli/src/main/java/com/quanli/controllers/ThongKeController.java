/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.repository.DonPhongRepository;
import com.quanli.service.DonPhongService;
import com.quanli.service.DonTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AD
 */
@Controller
public class ThongKeController {
    @Autowired
    private DonPhongService donPhongService;
    @Autowired
    private DonTourService donTourService;
    @RequestMapping("/admin/thongke")
    public String showthongke(Model model){
        
         model.addAttribute("dontour", this.donTourService.getDoanhThu());
         for(int i = 1 ; i<13; i++)
         {
              model.addAttribute("doanhthuthang"+i,this.donTourService.getDoanhThuTheoThang(i));
         }
        
        return "thongke";
    }
    
}
