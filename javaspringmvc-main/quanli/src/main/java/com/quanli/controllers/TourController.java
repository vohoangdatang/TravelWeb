/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.pojos.Tour;
import com.quanli.service.ThanhPhoService;
import com.quanli.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TourController {
    
    @Autowired
    private TourService tourService;
    @Autowired
   private ThanhPhoService thanhPhoService;
    @RequestMapping("/admin/tour")
    public String showtour(Model model)
    {
       model.addAttribute("tour",  this.tourService.showtour());
       
        return "qltour";
    }
    @RequestMapping("/tour")
    public String showtour1(Model model,@RequestParam(name="name", required = false,defaultValue = "")String name)
    {
        model.addAttribute("tour", this.tourService.showtour());
        model.addAttribute("tour", this.tourService.getTourByTP(name));
        model.addAttribute("thanhpho", this.thanhPhoService.getAllTP());
        return "tour";
    }
    @RequestMapping("/tour/detail/{id}")
    public String showdetailtour(@PathVariable(name="id")int id,Model model)
    {
        Tour tour = this.tourService.getTourById(id);
        model.addAttribute("tour", tour);
        return "detailtour";
    }
    @RequestMapping("/admin/add/tour")
    public String addTour(Model model)
    {
        model.addAttribute("tours", new Tour());
        return "addtour";
    }
    @PostMapping("/admin/tours")
    public String addTourAction(@ModelAttribute(name="tours")Tour tour)
    {
        this.tourService.addtour(tour);
        return "redirect:/admin/tour";
    }
    @RequestMapping("/admin/tour/delete/{id}")
    public String deleteTour(@PathVariable(name="id")int id,Model model)
    {
        this.tourService.delete(id);
        return "redirect:/admin/tour";
    }
    @RequestMapping("/admin/tour/update/{id}")
    public String showUpdate(@PathVariable(name="id")int id,Model model)
    {
        Tour tour = this.tourService.getTourById(id);
        model.addAttribute("tours", tour);
        return "updatetour";
    }
    @PostMapping("/admin/tour/update")
    public String Update(@ModelAttribute(name="tours")Tour tour)
    {
        this.tourService.update(tour);
        return "redirect:/admin/tour";
    }
}
