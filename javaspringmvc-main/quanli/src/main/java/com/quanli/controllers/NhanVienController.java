/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.pojos.CartXe;
import com.quanli.pojos.DonTour;
import com.quanli.service.CTDTService;
import com.quanli.service.ChuyenXeService;
import com.quanli.service.DonTourService;
import com.quanli.service.TourService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class NhanVienController {
    @Autowired
    private CTDTService cTDTService;
    @Autowired
    private DonTourService donTourService;
    @Autowired
    private ChuyenXeService chuyenXeService;
    @RequestMapping("/nhanvien/index")
    public String index(Model model,@RequestParam(name="name", required = false,defaultValue = "")String name)
    {
        model.addAttribute("chuyenxe",this.chuyenXeService.getKS());
        model.addAttribute("chuyenxe",this.chuyenXeService.getChuyenXeByTP(name));
        return "NhanVienIndex";
    }
    @RequestMapping("/nhanvien/pay")
    public String infokhachhang(Model model,HttpSession session)
    {
        model.addAttribute("dontour", new DonTour());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        return "NhanVienCart";
    }
    @RequestMapping("/nhanvien/hoadon")
    public String hoadonnv(Model model,HttpSession session)
    {
        model.addAttribute("dontour", this.donTourService.getAllDonTour());
        return "HoaDonNV";
    }
    @PostMapping("/nhanvien/pay/add/{id}")
    public String payaction(HttpSession session,@PathVariable(value="id")int id,Model model)
    {
         if(this.donTourService.addDonCX((Map<Integer, CartXe>) session.getAttribute("cart"),id)==true)
        {
            session.removeAttribute("cart");
            
            return "redirect:/nhanvien/hoadon";  
            
        }
         return "NhanVienCart";
    }
      @RequestMapping("/nhanvien/hoadon/tour/xoa/{id}")
    public String xoahoadonTour(@PathVariable(value="id")int id)
    {
        this.donTourService.xoa(id);
        return "redirect:/nhanvien/hoadon";
    }
     @RequestMapping("/nhanvien/hoadon/tour/update/{id}")
    public String updatehoadonTour(@PathVariable(value="id")int id,Model model)
    {
        DonTour dontour =this.donTourService.getDTById(id);
        model.addAttribute("hoadon",dontour );
        
        return "updatehoadontour";
    }
     @PostMapping("/nhanvien/hoadon/tour/update")
    public String updateTour(@ModelAttribute(name="hoadon") DonTour dontour)
    {
        this.donTourService.update(dontour);
        return "redirect:/nhanvien/hoadon";
    }
    @RequestMapping("/nhanvien/hoadon/tour/detail/{id}")
    public String detailTour(@PathVariable(value="id")int id,Model model)
    {
        model.addAttribute("hoadon", this.cTDTService.getCTByIdDP(id));
        return "detaildt";
    }
}
