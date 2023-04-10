/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.quanli.pojos.User;
import com.quanli.service.UserService;
import com.quanli.validate.username;
import java.io.IOException;
import java.util.Map;
import javax.persistence.Query;
import javax.validation.Valid;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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

public class UserController {
    @Autowired
    private UserService userDetailsService;
   @Autowired
   private username username;
   @InitBinder
   public void innitBinder(WebDataBinder binder)
   {
        binder.setValidator(username);
   }
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/register")
    public String registerPage(Model model)
    {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute(name ="user")@Valid User user, BindingResult result,Model model)
    {
        if(!result.hasErrors())
        {
             userDetailsService.addUser(user);
            return "redirect:/login";
           
        }
        else{
            
            model.addAttribute("error", "ten dang nhap nay da duoc su dung");
            return "register";
        }
    }
    @RequestMapping("/admin/users/delete/{id}")
    public String delUser(@PathVariable(name="id")int id )
    {
        userDetailsService.delete(id);
        return "redirect:/admin/user";
    }
    
   @RequestMapping("/admin/users/edit/{id}")
    public String editpage(@PathVariable(name="id")int id, Model model)
    {
        User user = userDetailsService.getUserById(id);
        model.addAttribute("user", user);
        return "updateUsers";
    }
    @PostMapping("/admin/edit")
    public String edit(@ModelAttribute(name="user") User user){
        this.userDetailsService.updateUser(user); 
        return "redirect:/admin/user";  
    }
    @RequestMapping("/admin/user")
    @Transactional
    public String qluser(Model model,@RequestParam(name="name", required = false,defaultValue = "")String name)
    {
        model.addAttribute("mess", this.userDetailsService.getAllUserByName(name));
        model.addAttribute("mess", this.userDetailsService.getAllUser());
        return "qluser";
    }
     @RequestMapping("/admin/users/profile/{id}")
    public String userProfile(@PathVariable(name="id")int id ,Model model)
    {
        User user = userDetailsService.getUserById(id);
        model.addAttribute("user", user);
        return "userprofile";
    }
    @RequestMapping("/profile/{username}")
    public String userProfileByUsername(@PathVariable(value="username") String username,Model model)
    {
        model.addAttribute("user", this.userDetailsService.getUsers(username));
        return "profile";
    }
    @RequestMapping("/profile/update/{username}")
    public String updateUserProfileByUsername(@PathVariable(value="username") String username,Model model)
    {
        
        model.addAttribute("user", this.userDetailsService.getUsers(username));
        return "updateprofile";
    }
    @PostMapping("/profile/update")
    public String updateUser(@ModelAttribute(name="user") User user)
    {
        
            this.userDetailsService.updateUserwAvatar(user);
            return "redirect:/";
      
    }
    
}
