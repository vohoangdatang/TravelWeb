/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository;

import com.quanli.pojos.DanhGia;
import java.util.List;

/**
 *
 * @author AD
 */
public interface DanhGiaRepository {
    void addDG(DanhGia danhgia);
    List<DanhGia>getDanhGiaByCX(int id);
}
