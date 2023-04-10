/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.quanli.pojos.Tour;
import com.quanli.repository.TourRepository;
import com.quanli.service.TourService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class TourServiceImpl implements TourService{

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private TourRepository tourRepository;
    @Override
    public List<Tour> showtour() {
        return this.tourRepository.showtour();
    }

    @Override
    public Tour getTourById(int i) {
        return this.tourRepository.getTourById(i);
    }

    @Override
    public void addtour(Tour tour) {
        try{
          Map r = cloudinary.uploader().upload(tour.getFile().getBytes(),
                ObjectUtils.asMap("resource_type","auto"));
            String img = (String) r.get("secure_url");
            System.err.println(img);
            tour.setImage(img);
            this.tourRepository.addtour(tour);
            }catch(IOException ex)
        {
            System.err.println("loi:" + ex.getMessage());
        }
    }

    @Override
    public void delete(int i) {
        this.tourRepository.delete(i);
    }

    @Override
    public void update(Tour tour) {
        try{
          Map r = cloudinary.uploader().upload(tour.getFile().getBytes(),
                ObjectUtils.asMap("resource_type","auto"));
            String img = (String) r.get("secure_url");
            System.err.println(img);
            tour.setImage(img);
            this.tourRepository.update(tour);
            }catch(IOException ex)
        {
            System.err.println("loi:" + ex.getMessage());
        }
    }

    @Override
    public List<Tour> getTourByTP(String string) {
        return this.tourRepository.getTourByTP(string);
    }

    @Override
    public List<Tour> getKSTop8(int i) {
       return this.tourRepository.getKSTop8(i);
    }

   
}
