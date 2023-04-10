/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.formatter;

import com.quanli.pojos.ThanhPho;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author AD
 */
public class ChuyenXeFormatter implements Formatter<ThanhPho>{

    @Override
    public String print(ThanhPho t, Locale locale) {
        return String.valueOf(t.getIdthanhpho());
    }

    @Override
    public ThanhPho parse(String string, Locale locale) throws ParseException {
        ThanhPho tp = new ThanhPho( );
        tp.setIdthanhpho(Integer.parseInt(string));
        return tp;
    }
    
}
