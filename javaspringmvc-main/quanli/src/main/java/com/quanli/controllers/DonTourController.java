/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.pojos.DonTour;
import com.quanli.pojos.Tour;
import com.quanli.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AD
 */
@Controller
public class DonTourController {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Autowired
    private UserService userDetailsService;
    @RequestMapping("/dontour")
    public String showdon(Model model)
    {
        model.addAttribute("dontour", new DonTour());
        return "checkouttour";
    }
    @RequestMapping("/dontour/{username}")
    public String showdon(Model model,@PathVariable(name="username") String username)
    {
         model.addAttribute("user", this.userDetailsService.getUsers(username));
        model.addAttribute("dontour", new DonTour());
        return "checkouttour";
    }
    @PostMapping("/dontour/add")
    @Transactional
    public String ThemDon(@ModelAttribute(name="dontour")DonTour dontour)
    {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        dontour.setPhuongthuc("offine");
        dontour.setTongtien(200000);
        session.save(dontour);
        return "redirect:/";
        
    }
}
