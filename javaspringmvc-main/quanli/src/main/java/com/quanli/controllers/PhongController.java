/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;


import com.quanli.pojos.Phong;
import com.quanli.service.KhachSanService;
import com.quanli.service.LoaiPhongService;
import com.quanli.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AD
 */
@Controller
@ControllerAdvice
public class PhongController {
    
    @Autowired
    private PhongService phongService;
    @Autowired
    private LoaiPhongService loaiPhongService;
    @Autowired
    private KhachSanService khachSanService;
    @RequestMapping("/admin/phong")
    public String showphong(Model model){
        model.addAttribute("phong", new Phong());
        model.addAttribute("getphong", this.phongService.getPhong());
         model.addAttribute("khachsan", this.loaiPhongService.getLP());
        model.addAttribute("khachsans", this.khachSanService.getKS());
        return "phong";
    }
    @PostMapping("/admin/addphong")
    public String addphong(@ModelAttribute(name="phong") Phong phong)
    {
       this.phongService.addPhong(phong);
        return "redirect:/admin/phong";
    }
    @RequestMapping("/admin/phong/delete/{id}")
    public String delPhong(@PathVariable(name="id")int id)
    {
        this.phongService.delete(id);
        return "redirect:/admin/phong";
    }
    @RequestMapping("/admin/phong/edit/{id}")
    public String showeditPhong(@PathVariable(name="id")int id,Model model)
    {
        Phong p = this.phongService.getPhongById(id);
        model.addAttribute("phong", p);
         model.addAttribute("khachsan", this.loaiPhongService.getLP());
        model.addAttribute("khachsans", this.khachSanService.getKS());
        return "editphong";
    }
    @RequestMapping("/admin/phong/edit")
    public String edit(@ModelAttribute(value="phong") Phong phong)
    {
        this.phongService.update(phong);
        return"redirect:/admin/phong";
    }
}
