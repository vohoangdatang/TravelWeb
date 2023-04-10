/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service;

import com.quanli.pojos.CTDonTour;
import java.util.List;

/**
 *
 * @author AD
 */
public interface CTDTService {
      List<CTDonTour> getCTByIdDP(int id);
}
