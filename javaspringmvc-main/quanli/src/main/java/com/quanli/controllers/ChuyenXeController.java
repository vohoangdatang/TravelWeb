/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.pojos.CartXe;
import com.quanli.pojos.ChuyenXe;
import com.quanli.repository.DanhGiaRepository;
import com.quanli.repository.ThanhPhoRepository;
import com.quanli.service.ChuyenXeService;
import com.quanli.service.DanhGiaService;
import com.quanli.service.ThanhPhoService;
import com.quanli.service.UserService;
import static com.quanli.utils.utils.countCart;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class ChuyenXeController {
    
    @Autowired
    private ChuyenXeService chuyenXeService;
    @Autowired
    private ThanhPhoService thanhPhoService;
    @Autowired
    private UserService userDetailService;
    @Autowired
    private DanhGiaService danhGiaService;
    @RequestMapping("/admin/chuyenxe")
    public String quanlichuyenxe(Model model,@RequestParam(name="name", required = false,defaultValue = "")String name)
    {
        model.addAttribute("chuyenxe",this.chuyenXeService.getKS());
        model.addAttribute("chuyenxe",this.chuyenXeService.getChuyenXeByTP(name));
        /*model.addAttribute("chuyenxe1",this.chuyenXeService.getChuyenXediByTP(name));*/
        return "chuyenxe";
    }
    @RequestMapping("/admin/add/chuyenxe")
    public String addchuyenxe(Model model)
    {
       model.addAttribute("taixe",this.userDetailService.getAllUserTaiXe());
        model.addAttribute("thanhpho",this.thanhPhoService.getAllTP());
        model.addAttribute("chuyenxe",new ChuyenXe());
        return "addChuyenXe";
    }
    @PostMapping("/admin/add/chuyenxe/action")
    public String addchuyenxeaction(@ModelAttribute(name="chuyenxe")@Valid ChuyenXe chuyenxe,BindingResult result,Model model)
    {
        if(!result.hasErrors())
        {
            this.chuyenXeService.addCX(chuyenxe);
            return "redirect:/admin/chuyenxe";
        }
        else
        {
            model.addAttribute("loi","Đã có lỗi xảy ra!!! Hãy bấm Reload ở dưới");
            return "addChuyenXe";
        }
        
        
    }
    @RequestMapping("/admin/delete/chuyenxe/{id}")
    public String deleteChuyenXe(@PathVariable(name="id")int id,Model model)
    {
        this.chuyenXeService.deleteCX(id);
        return "redirect:/admin/chuyenxe";
    }
    @RequestMapping("/admin/edit/chuyenxe/{id}")
    public String editChuyenXe(@PathVariable(name="id")int id, Model model)
    {
         model.addAttribute("taixe",this.userDetailService.getAllUserTaiXe());
        ChuyenXe chuyenxe = this.chuyenXeService.getChuyenXeById(id);
        model.addAttribute("thanhpho",this.thanhPhoService.getAllTP());
        model.addAttribute("chuyenxe", chuyenxe);
        return "editChuyenXe";
    }
    @PostMapping("/admin/update/chuyenxe")
    public String updatechuyenxe(@ModelAttribute(name="chuyenxe")ChuyenXe chuyenxe)
    {
        this.chuyenXeService.updateCX(chuyenxe);
        return "redirect:/admin/chuyenxe";
    }
    @RequestMapping("/chuyenxe/detail/{id}")
    public String inforChuyenXe(@PathVariable(name="id")int id, Model model)
    {
        model.addAttribute("chuyenxe",this.chuyenXeService.getChuyenXeById(id));
        model.addAttribute("danhgia", this.danhGiaService.getDanhGiaByCX(id));
        return "detailCX";
    }
    @RequestMapping("/chuyenxe")
    public String inforChuyenXe( Model model,@RequestParam(name="name", required = false,defaultValue = "")String name,HttpSession session)
    {
       model.addAttribute("chuyenxe",this.chuyenXeService.getChuyenXeByTP(name));
       model.addAttribute("thanhpho", this.thanhPhoService.getAllTP());
      
        return "chuyenxeindex";
    }
     @ModelAttribute
    public void xetbientoancuc(Model model, HttpSession session)
    {
        model.addAttribute("cartCounter", countCart((Map<Integer, CartXe>) session.getAttribute("cart")));
         model.addAttribute("iduser", session.getAttribute("user"));
    }
}
