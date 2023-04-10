/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;



import com.quanli.pojos.User;
import com.quanli.repository.LoaiPhongRepository;
import com.quanli.service.ChuyenXeService;
import com.quanli.service.KhachSanService;
import com.quanli.service.PhongService;
import com.quanli.service.ThanhPhoService;
import com.quanli.service.TourService;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author AD
 */
@Controller
@Transactional
public class HomeController {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private PhongService phongService;
    @Autowired
    private KhachSanService khachSanService;
   @Autowired
   private LoaiPhongRepository loaiPhongRepository;
   @Autowired
   private ThanhPhoService thanhPhoService;
   @Autowired
   private TourService tourService;
   @Autowired
   private ChuyenXeService chuyenXeService;
    @RequestMapping("/")
    public String index(Model model)
    {
       model.addAttribute("khachsan", this.khachSanService.getKSTop8(1));
       model.addAttribute("tour", this.tourService.getKSTop8(1));
       model.addAttribute("chuyenxe",this.chuyenXeService.getKSTop4(1));
        return "index";
    }
    
    @RequestMapping("/khachsan")
    public String showPhong(Model model,@RequestParam(name="name", required = false,defaultValue = "")String name   )
    {
       model.addAttribute("khachsan", this.khachSanService.getKS());
      // model.addAttribute("phong", this.phongService.getPhong());
       model.addAttribute("khachsan", this.khachSanService.getKhachSanByTP(name));
       model.addAttribute("thanhpho", this.thanhPhoService.getAllTP());
       model.addAttribute("loaiphong", this.loaiPhongRepository.getLP());
        return "khachsan";
    }
    @RequestMapping("/khachsanparam")
    public String showKSByTP(@RequestParam(name="name")String name,Model model)
    {
        model.addAttribute("loaiphong", this.loaiPhongRepository.getLP());
        model.addAttribute("khachsan", this.khachSanService.getKhachSanByTP(name));
        model.addAttribute("thanhpho", this.thanhPhoService.getAllTP());
        return "khachsanByLP";
    }
    
    @RequestMapping("/khachsanparamlp")
    public String showKSByLP(@RequestParam(name="name")String name,Model model)
    {
        model.addAttribute("loaiphong", this.loaiPhongRepository.getLP());
        model.addAttribute("phong", this.phongService.getPhongByLP(name));
        model.addAttribute("thanhpho", this.thanhPhoService.getAllTP());
        return "khachsanByLP";
    }
    @RequestMapping("/khachsan/{page}")
    public String showKSByLP(@PathVariable(name="page")int page,Model model)
    {
        model.addAttribute("loaiphong", this.loaiPhongRepository.getLP());
       model.addAttribute("khachsan", this.khachSanService.getksmoinhat(page));
        model.addAttribute("thanhpho", this.thanhPhoService.getAllTP());
        return "khachsanByLP";
    }
    @RequestMapping("/returnUrl")
    public String returnUrl()
    {
        return "/khachsan";
    }
    @RequestMapping("/xacnhan")
    public String xacnhan()
    {
        return "/khachsan";
    }
    
    
}
