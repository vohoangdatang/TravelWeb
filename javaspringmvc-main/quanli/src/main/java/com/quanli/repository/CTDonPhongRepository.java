package com.quanli.repository;

import com.quanli.pojos.CTDonPhong;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AD
 */
public interface CTDonPhongRepository {
    List<CTDonPhong> getCTDonPhong();
    List<CTDonPhong> getCTByIdDP(int id);
}
