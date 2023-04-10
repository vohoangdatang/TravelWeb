/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.service.ChuyenXeService;
import com.quanli.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AD
 */
@Controller
public class TaiXeController {
    @Autowired
    private UserService userDetailService;
    @Autowired
    private ChuyenXeService chuyenXeService;
    @RequestMapping("/admin/taixe")
    public String qlTaiXe(Model model)
    {
        
        model.addAttribute("user",this.userDetailService.getAllUserTaiXe());
        return "TaiXe";
    }
    @RequestMapping("/taixe/info/{id}")
    public String taixe(Model model,HttpSession session,@PathVariable(value="id")int id)
    {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        //model.addAttribute("taixe",this.userDetailService.getUserById(id));
        //model.addAttribute("chuyenxe",this.chuyenXeService.getChuyenXediByTP(id));
        return "TaiXeInfo";
    }
    
}
