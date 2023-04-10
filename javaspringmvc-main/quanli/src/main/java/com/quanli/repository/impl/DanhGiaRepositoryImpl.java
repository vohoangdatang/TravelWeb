/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository.impl;

import com.quanli.pojos.DanhGia;
import com.quanli.repository.DanhGiaRepository;
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
public class DanhGiaRepositoryImpl implements DanhGiaRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public void addDG(DanhGia dg) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        
        session.save(dg);
    }

    @Override
    public List<DanhGia> getDanhGiaByCX(int i) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("From DanhGia dg Where dg.cx.idCX like CONCAT('%', :lp, '%')");
        q.setParameter("lp", i);
        return q.getResultList();
    }

   
    
}
