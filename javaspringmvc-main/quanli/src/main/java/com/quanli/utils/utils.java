/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.utils;

import com.quanli.pojos.Cart;
import com.quanli.pojos.CartXe;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author AD
 */
public class utils {
     public static int countCart( Map<Integer,CartXe> cart)
    {
        int q = 0;
        if(cart != null)
        {
          for(CartXe c: cart.values())
            q+=c.getSoluong();
        }
       
        return q;
    }
    public static Long sumAmount(Map<Integer,CartXe> cart)
    {
        Long s = 0l;
        if(cart != null)
        {
          for(CartXe c: cart.values())
            s+=c.getSoluong()*c.getGia();
        }
       
        return s;
        
    }
  
  

   
}
