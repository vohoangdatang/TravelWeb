/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository.impl;

import com.quanli.pojos.LoaiPhong;
import com.quanli.repository.LoaiPhongRepository;
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
public class LoaiPhongRepositoryImpl implements LoaiPhongRepository{

     @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public List<LoaiPhong> getLP() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("From LoaiPhong ");
        return q.getResultList();
    }

    @Override
    public void addLP(LoaiPhong lp) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         session.save(lp);
    }

    @Override
    public void update(LoaiPhong lp) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        session.update(lp);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        LoaiPhong lp = (LoaiPhong)session.get(LoaiPhong.class,id);
        session.delete(lp);
    }
    
}
