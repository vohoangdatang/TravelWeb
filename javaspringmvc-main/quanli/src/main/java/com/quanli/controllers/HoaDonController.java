package com.quanli.controllers;


import com.quanli.pojos.DonPhong;
import com.quanli.pojos.DonTour;
import com.quanli.service.CTDTService;
import com.quanli.service.CTDonPhongService;
import com.quanli.service.DonPhongService;
import com.quanli.service.DonTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AD
 */
@Controller
public class HoaDonController {
    @Autowired
    private CTDonPhongService cTDonPhongService;
    @Autowired
    private DonPhongService donPhongService;
    @Autowired
    private DonTourService donTourService;
    @Autowired
    private CTDTService cTDTService;
    @RequestMapping("/admin/hoadon")
    public String showhoadon(Model model)
    {
      
        model.addAttribute("hoadon", this.donPhongService.getAllDonPhong());
       model.addAttribute("dontour", this.donTourService.getAllDonTour());
     return "hoadon";   
    }
    @RequestMapping("/admin/hoadon/xoa/{id}")
    public String xoahoadon(@PathVariable(value="id")int id)
    {
        this.donPhongService.xoa(id);
        return "redirect:/admin/hoadon";
    }
    @RequestMapping("/admin/hoadon/update/{id}")
    public String updatehoadon(@PathVariable(value="id")int id,Model model)
    {
        DonPhong donphong =this.donPhongService.getDPById(id);
        model.addAttribute("hoadon",donphong );
        
        return "updatehoadon";
    }
    @PostMapping("/admin/hoadon/update")
    public String update(@ModelAttribute(name="hoadon") DonPhong donphong)
    {
        this.donPhongService.update(donphong);
        return "redirect:/admin/hoadon";
    }
    @RequestMapping("/admin/hoadon/detail/{id}")
    public String detail(@PathVariable(value="id")int id,Model model)
    {
        model.addAttribute("hoadon", this.cTDonPhongService.getCTByIdDP(id));
        return "detaildp";
    }
     @RequestMapping("/admin/hoadon/tour/xoa/{id}")
    public String xoahoadonTour(@PathVariable(value="id")int id)
    {
        this.donTourService.xoa(id);
        return "redirect:/admin/hoadon";
    }
     @RequestMapping("/admin/hoadon/tour/update/{id}")
    public String updatehoadonTour(@PathVariable(value="id")int id,Model model)
    {
        DonTour dontour =this.donTourService.getDTById(id);
        model.addAttribute("hoadon",dontour );
        
        return "updatehoadontour";
    }
     @PostMapping("/admin/hoadon/tour/update")
    public String updateTour(@ModelAttribute(name="hoadon") DonTour dontour)
    {
        this.donTourService.update(dontour);
        return "redirect:/admin/hoadon";
    }
    @RequestMapping("/admin/hoadon/tour/detail/{id}")
    public String detailTour(@PathVariable(value="id")int id,Model model)
    {
        model.addAttribute("hoadon", this.cTDTService.getCTByIdDP(id));
        return "detaildt";
    }
}
