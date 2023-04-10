/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service;

import com.quanli.pojos.Tour;
import java.util.List;

/**
 *
 * @author AD
 */
public interface TourService {
     List<Tour>showtour();
      Tour getTourById(int id);
      void addtour(Tour tour);
      void delete(int id);
      void update(Tour tour);
      List<Tour> getTourByTP(String LP);
        List<Tour> getKSTop8(int page);
}
