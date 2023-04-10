/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.pojos.DanhGia;
import com.quanli.service.DanhGiaService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AD
 */
@Controller
public class DanhGiaController {
    @Autowired
    private DanhGiaService danhGiaService;
    @GetMapping("/danhgia/{id}")
    public String show(@PathVariable(name="id")int id,Model model,HttpSession session)
    {
        model.addAttribute("danhgia", new DanhGia());
        model.addAttribute("user", session.getAttribute("currentUser"));
        return "addDanhGia";
    }
    @PostMapping("/danhgia/add/action")
    public String action(@ModelAttribute(name="danhgia")@Valid DanhGia danhgia,BindingResult result)
    {
        if(result.hasErrors())
            return "addDanhGia";
        this.danhGiaService.addDG(danhgia);
        return "redirect:/";
    }
}
