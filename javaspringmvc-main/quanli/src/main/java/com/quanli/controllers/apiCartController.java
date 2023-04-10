
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.pojos.Cart;
import com.quanli.pojos.CartXe;
import com.quanli.service.DonTourService;
import static com.quanli.utils.utils.countCart;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author AD
 */
@RestController
public class apiCartController {
    @Autowired
   private DonTourService donTourService;
    @PostMapping("/api/cart")
    public int  addToCart(@RequestBody CartXe param, HttpSession session )
    {
        Map<Integer,CartXe> cart = (Map<Integer,CartXe>) session.getAttribute("cart");
        if(cart == null)
            cart = new HashMap<>();
        int productId = param.getId();
        if(cart.containsKey(productId )== true)
        {
            CartXe  c = cart.get(productId);
            c.setSoluong(c.getSoluong()+1);
        }
        else
        {
            cart.put(productId, param);
        }
        session.setAttribute("cart", cart);
        return countCart(cart);
    }
    @DeleteMapping("/api/chuyenxe/delete/{id}")
    public int deleteCart(@PathVariable(value="id")int id,HttpSession session)
    {
        Map<Integer,CartXe> cart = (Map<Integer,CartXe>) session.getAttribute("cart");
        if(cart!=null && cart.containsKey(id))
        {
             cart.remove(id);
            session.setAttribute("cart", cart);
        }
       return countCart(cart);
    }
    @PostMapping("/api/chuyenxe/pay/{id}")
    public HttpStatus pay(HttpSession session,@PathVariable(value="id")int id)
    {
        if(this.donTourService.addDonCX((Map<Integer, CartXe>) session.getAttribute("cart"),id)==true)
        {
            session.removeAttribute("cart");
            return HttpStatus.OK;
            
        }
            
        return HttpStatus.BAD_REQUEST;
    }
   
    
   
            
            
            
   
    

}
