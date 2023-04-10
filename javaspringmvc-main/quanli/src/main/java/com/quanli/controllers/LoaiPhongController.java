/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.pojos.LoaiPhong;
import com.quanli.service.LoaiPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class LoaiPhongController {
    @Autowired
     private LoaiPhongService loaiPhongService;
    @RequestMapping("/admin/loaiphong")
    public String showloaiphong(Model model )
    {
       model.addAttribute("khachsan", this.loaiPhongService.getLP());
       model.addAttribute("loaiphong", new LoaiPhong());
        return "loaiphong";
    }
    @PostMapping("/admin/addloaiphong")
    public String addLP(@ModelAttribute(name="loaiphong") LoaiPhong loaiphong)
    {
      this.loaiPhongService.addLP(loaiphong);
      
        return "redirect:/admin/loaiphong";
    }
    @RequestMapping("/admin/loaiphong/delete/{id}")
    public String deletelp(@PathVariable(name="id")int id)
    {
        this.loaiPhongService.delete(id);
        return "redirect:/admin/loaiphong";
    }
}
