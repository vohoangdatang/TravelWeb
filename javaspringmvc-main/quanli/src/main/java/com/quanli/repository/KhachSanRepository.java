/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository;

import com.quanli.pojos.KhachSan;
import com.quanli.pojos.Phong;
import java.util.List;

/**
 *
 * @author AD
 */
public interface KhachSanRepository {
    List<KhachSan> getKS();
    void addPhong(KhachSan ks);
     void update(KhachSan ks);
    void delete(int id);
    List<KhachSan> getKhachSanByTP(String LP);
    KhachSan getKSById(int id);
    List<KhachSan> getksmoinhat(int page);
    boolean checkupdate(KhachSan ks);
    List<KhachSan> getKSTop8(int page);
    
}
