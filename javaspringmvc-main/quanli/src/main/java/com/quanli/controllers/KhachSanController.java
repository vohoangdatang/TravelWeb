/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.quanli.pojos.KhachSan;
import com.quanli.service.KhachSanService;
import com.quanli.service.LoaiPhongService;
import com.quanli.service.PhongService;
import com.quanli.service.ThanhPhoService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author AD
 */
@Controller
public class KhachSanController {
    
     @Autowired
    private KhachSanService khachSanService;
     @Autowired
     private PhongService phongService;
     @Autowired
     private LoaiPhongService loaiPhongService;
     @Autowired
     private ThanhPhoService thanhPhoService;
     
     @RequestMapping("/admin/khachsan")
    public String showkhachsan(Model model,@RequestParam(name="name", required = false,defaultValue = "")String name   )
    {
       model.addAttribute("khachsan", this.khachSanService.getKS());
        model.addAttribute("khachsan", this.khachSanService.getKhachSanByTP(name));
        return "qlkhachsan";
    }
    
   
    @RequestMapping("/admin/khachsan/delete/{id}")
    public String deleteKhachsan(@PathVariable(value="id")int id){
        this.khachSanService.delete(id);
        return "redirect:/admin/khachsan";
    }
    @RequestMapping("/khachsan/detail/{id}")
    public String showdetailKS(@PathVariable(name="id")int id,Model model)
    {
        KhachSan ks = this.khachSanService.getKSById(id);
        model.addAttribute("khachsan", ks);
        model.addAttribute("phong", this.phongService.getPhongByIdKS(id));
        model.addAttribute("loaiphong", this.loaiPhongService.getLP());
        model.addAttribute("thanhpho", this.thanhPhoService.getAllTP());
        return "detailKS";
    }
    @GetMapping("/admin/khachsan/add")
    public String img(Model model)
    {
        model.addAttribute("khachsan", new KhachSan());
        return "themks";
    }
   
    @PostMapping("/admin/khachsan/add")
    public String addimg(@ModelAttribute(name="khachsan") KhachSan khachsan) 
    {
       
            this.khachSanService.addPhong(khachsan);
            return "redirect:/admin/khachsan";
        
    }
    @RequestMapping("/admin/khachsan/update/{id}")
    public String updateKhachSan(@PathVariable(name="id")int id, Model model)
    {
        KhachSan khachsan = this.khachSanService.getKSById(id);
        model.addAttribute("khachsan", khachsan);
        return "updateKhachSan";
    }
    @PostMapping("/admin/khachsan/update")
    public String updateKhachSanAction(@ModelAttribute(name="khachsan") KhachSan khachsan)
    {
       if(this.khachSanService.checkupdate(khachsan))
       {
            System.err.println("update thanh cong");
            return "redirect:/admin/khachsan";
       }
       else
       {
            System.err.println("That bai");
            return "updateKhachSan";
       }
           
         
    }
}
    
