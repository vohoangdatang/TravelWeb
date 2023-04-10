/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository.impl;

import com.quanli.pojos.Tour;
import com.quanli.repository.TourRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AD
 */
@Controller
@Transactional
public class TourRepositoryImpl implements TourRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public List<Tour> showtour() {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
          Query q = session.createQuery("From Tour ");
        
        return q.getResultList();
    }

    @Override
    public Tour getTourById(int i) {
          Session session = this.sessionFactoryBean.getObject().getCurrentSession();
      Tour ks = session.get(Tour.class, i);
      return ks;
    }

    @Override
    public void addtour(Tour tour) {
          Session session = this.sessionFactoryBean.getObject().getCurrentSession();
          session.save(tour);
    }

    @Override
    public void delete(int i) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Tour tour = session.get(Tour.class, i);
        session.delete(tour);
    }

    @Override
    public void update(Tour tour) {
       Session session = this.sessionFactoryBean.getObject().getCurrentSession();
       session.update(tour);
    }

    @Override
    public List<Tour> getTourByTP(String LP) {
       Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q =session.createQuery("From Tour t Where t.place like CONCAT('%', :lp, '%')");
          q.setParameter("lp", LP);
          return q.getResultList();
    }

    @Override
    public List<Tour> getKSTop8(int page) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("From Tour ");
        int max = 8;
         q.setMaxResults(max);
        q.setFirstResult((page-1) * max);
        return q.getResultList();
    }

  
    
}
