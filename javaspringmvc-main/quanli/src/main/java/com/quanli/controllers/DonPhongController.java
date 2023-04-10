/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.pojos.DonPhong;
import com.quanli.service.UserService;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Query;
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
@Transactional
public class DonPhongController {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Autowired
    private UserService userDetailsService;

    @RequestMapping("/don/{username}")
    public String Don(Model model,@PathVariable(name="username") String username)
    {
        model.addAttribute("donphong", new DonPhong());
        model.addAttribute("user", this.userDetailsService.getUsers(username));
        return "checkout";
    }
     @RequestMapping("/don")
    public String Don(Model model)
    {
        model.addAttribute("donphong", new DonPhong());
        
        return "checkout";
    }
    @PostMapping("/don/add")
    public String ThemDon(@ModelAttribute(name="donphong")DonPhong donphong)
    {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        session.save(donphong);
        return "redirect:/don/view";
        
    }
}
