/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.formatter;

import com.quanli.pojos.KhachSan;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author AD
 */
public class KhachSanFormatter implements Formatter<KhachSan>{

    @Override
    public String print(KhachSan t, Locale locale) {
        return String.valueOf(t.getIdkhachsan());
    }

    @Override
    public KhachSan parse(String idKS, Locale locale) throws ParseException {
        KhachSan ks = new KhachSan();
        ks.setIdkhachsan(Integer.parseInt(idKS));
        return ks;
    }
    
}
