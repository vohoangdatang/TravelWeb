/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service;

import com.quanli.pojos.KhachSan;
import java.util.List;

/**
 *
 * @author AD
 */
public interface KhachSanService {
    List<KhachSan> getKS();
     void addPhong(KhachSan ks);
     void update(KhachSan ks);
    void delete(int id);
     List<KhachSan> getKhachSanByTP(String lp);
     KhachSan getKSById(int id); 
      List<KhachSan> getksmoinhat(int page);
        boolean checkupdate(KhachSan ks);
        List<KhachSan> getKSTop8(int page);
}
