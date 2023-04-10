/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository;

import com.quanli.pojos.ChuyenXe;
import com.quanli.pojos.KhachSan;
import java.util.List;

/**
 *
 * @author AD
 */
public interface ChuyenXeRepository {
    void addCX(ChuyenXe chuyenxe);
    List<ChuyenXe> getKS();
    void deleteCX(int id);
    List<ChuyenXe> getChuyenXeByTP(String tp);
    List<ChuyenXe> getChuyenXediByTP(int tp);
    ChuyenXe getChuyenXeById(int id);
    void updateCX(ChuyenXe chuyenxe);
    List<ChuyenXe> getKSTop4(int page);
}
