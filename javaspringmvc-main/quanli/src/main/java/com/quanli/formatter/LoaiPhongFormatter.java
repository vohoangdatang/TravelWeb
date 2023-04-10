/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.formatter;

import com.quanli.pojos.LoaiPhong;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author AD
 */
public class LoaiPhongFormatter implements Formatter<LoaiPhong>{

    @Override
    public String print(LoaiPhong t, Locale locale) {
       return String.valueOf(t.getIdloaiphong());
    }

    @Override
    public LoaiPhong parse(String idLP, Locale locale) throws ParseException {
        LoaiPhong lp = new LoaiPhong();
        lp.setIdloaiphong(Integer.parseInt(idLP));
        return lp;
    }
    
}
