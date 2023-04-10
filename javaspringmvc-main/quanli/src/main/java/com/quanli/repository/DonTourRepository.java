/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository;



import com.quanli.pojos.CartXe;
import com.quanli.pojos.DonTour;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AD
 */
public interface DonTourRepository {
    List<DonTour> getDoanhThu();
     List<DonTour> getLishSuById(int id);
    List<DonTour> getAllDonTour();
    void xoa(int  id);
    DonTour getDTById(int id);
    void update(DonTour donphong);
    boolean addDonCX(Map<Integer,CartXe> cart,int id);
    List<DonTour> getDoanhThuTheoThang(int thang);
     
}
