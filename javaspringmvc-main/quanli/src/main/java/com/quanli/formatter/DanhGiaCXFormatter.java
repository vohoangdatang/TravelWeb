/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.formatter;

import com.quanli.pojos.ChuyenXe;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author AD
 */
public class DanhGiaCXFormatter implements Formatter<ChuyenXe>{

    @Override
    public String print(ChuyenXe t, Locale locale) {
        return String.valueOf(t.getIdCX());
    }

    @Override
    public ChuyenXe parse(String string, Locale locale) throws ParseException {
        ChuyenXe cx = new ChuyenXe();
        cx.setIdCX(Integer.parseInt(string));
        return cx;
    }
    
}
