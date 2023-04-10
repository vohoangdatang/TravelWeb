/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository.impl;

import com.quanli.pojos.Phong;
import com.quanli.repository.PhongRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AD
 */
@Repository
@Transactional
public class PhongRepositoryImpl implements PhongRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public List<Phong> getPhong() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("From Phong");
        return q.getResultList();
    }

    @Override
    public void addPhong(Phong phong) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try{
        session.save(phong);
        
        }catch(Exception ex)
        {
            System.err.println("them phong that bai" + ex.getMessage());
            ex.printStackTrace();
        }
            
    }

    @Override
    public void update(Phong p) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         session.update(p);
    }

    @Override
    public void delete(int id) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         Phong p = session.get(Phong.class, id);
         session.delete(p);
    }

    @Override
    public Phong getPhongById(int id) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         Phong p = session.get(Phong.class, id);
         return p;
    }

    @Override
    public List<Phong> getPhongByIdKS(int id) {
      Session session = this.sessionFactoryBean.getObject().getCurrentSession();
      Query q = session.createQuery("From Phong Where khachsan.idkhachsan=:id");
      q.setParameter("id", id);
      return q.getResultList();
    }

    @Override
    public List<Phong> getPhongByLP(String lp) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("From Phong p Where p.loaiphong.tenLoaiPhong like CONCAT('%', :lp, '%')");
        q.setParameter("lp", lp);
        return q.getResultList();
    }

    @Override
    public Phong phongDaDat(int id) {
           Session session = this.sessionFactoryBean.getObject().getCurrentSession();
           Phong p = session.get(Phong.class, id);
           p.setTinhTrang(false);
           return p;
    }

    @Override
    public Phong phongHuy(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
           Phong p = session.get(Phong.class, id);
           p.setTinhTrang(true);
           return p;
    }

   
    
}
