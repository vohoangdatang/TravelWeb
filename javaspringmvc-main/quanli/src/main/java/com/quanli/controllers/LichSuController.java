/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.service.DonPhongService;
import com.quanli.service.DonTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author AD
 */
@Controller
public class LichSuController {
    @Autowired
    private DonPhongService donPhongService;
    @Autowired
    private DonTourService donTourService;
    @RequestMapping("/lichsu")
    public String showLichSu(@RequestParam(name="id")int id ,Model model)
    {
        model.addAttribute("dontour", this.donTourService.getLishSuById(id));
        return "lichsu";
    }
}
