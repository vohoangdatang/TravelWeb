/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository.impl;

import com.quanli.pojos.ChuyenXe;
import com.quanli.pojos.KhachSan;
import com.quanli.repository.ChuyenXeRepository;
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
public class ChuyenXeRepositoryImpl implements ChuyenXeRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public void addCX(ChuyenXe chuyenxe) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        session.save(chuyenxe);
    }

    @Override
    public List<ChuyenXe> getKS() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("From ChuyenXe ");
        
        return q.getResultList();
    }

    @Override
    public void deleteCX(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        ChuyenXe chuyenxe = session.get(ChuyenXe.class,id);
        session.delete(chuyenxe);
    }

    @Override
    public List<ChuyenXe> getChuyenXeByTP(String string) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
          Query q =session.createQuery("From ChuyenXe cx Where cx.diemden like CONCAT('%', :lp, '%')");
          q.setParameter("lp", string);
          return q.getResultList();
    }

    @Override
    public List<ChuyenXe> getChuyenXediByTP(int string) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
          Query q =session.createQuery("From ChuyenXe cx Where cx.user.id =:lp");
          q.setParameter("lp", string);
          return q.getResultList();
    }

    @Override
    public ChuyenXe getChuyenXeById(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        ChuyenXe chuyenxe = session.get(ChuyenXe.class,id);
        return chuyenxe;
    }

    @Override
    public void updateCX(ChuyenXe cx) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         session.update(cx);
    }

    @Override
    public List<ChuyenXe> getKSTop4(int page) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("From ChuyenXe ");
        int max = 4;
         q.setMaxResults(max);
        q.setFirstResult((page-1) * max);
        return q.getResultList();
    }
    
}
