/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository;

import com.quanli.pojos.LoaiPhong;
import java.util.List;

/**
 *
 * @author AD
 */
public interface LoaiPhongRepository {
    List<LoaiPhong> getLP();
    void  addLP(LoaiPhong lp);
    void update(LoaiPhong lp);
    void delete(int id);
}
