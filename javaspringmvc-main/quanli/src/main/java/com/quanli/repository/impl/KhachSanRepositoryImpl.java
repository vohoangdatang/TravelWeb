/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository.impl;

import com.quanli.pojos.KhachSan;
import com.quanli.pojos.Phong;
import com.quanli.repository.KhachSanRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class KhachSanRepositoryImpl implements KhachSanRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public List<KhachSan> getKS() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("From KhachSan ");
        
        return q.getResultList();
    }

    @Override
    public void addPhong(KhachSan ks) {
          Session session = this.sessionFactoryBean.getObject().getCurrentSession();
          session.save(ks);
    }

    @Override
    public void update(KhachSan ks) {
          Session session = this.sessionFactoryBean.getObject().getCurrentSession();
          session.update(ks);
    }

    @Override
    public void delete(int id) {
          Session session = this.sessionFactoryBean.getObject().getCurrentSession();
          KhachSan ks = session.get(KhachSan.class, id);
          session.delete(ks);
    }

  

    @Override
    public List<KhachSan> getKhachSanByTP(String lp) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
          Query q =session.createQuery("From KhachSan ks Where ks.thanhPho like CONCAT('%', :lp, '%')");
          q.setParameter("lp", lp);
          return q.getResultList();
    }

    @Override
    public KhachSan getKSById(int i) {
      Session session = this.sessionFactoryBean.getObject().getCurrentSession();
      KhachSan ks = session.get(KhachSan.class, i);
      return ks;
    }

    @Override
    public List<KhachSan> getksmoinhat(int page) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KhachSan> query =  builder.createQuery(KhachSan.class);
        Root root = query.from(KhachSan.class);
        query = query.select(root);
        query = query.orderBy(builder.desc(root.get("idkhachsan")));
        Query q =session.createQuery(query);
        int max = 3;
        q.setMaxResults(max);
        q.setFirstResult((page-1) * max);
        return q.getResultList();
    }

    @Override
    public boolean checkupdate(KhachSan ks) {
          Session session = this.sessionFactoryBean.getObject().getCurrentSession();
          session.update(ks);
          return true;
    }

    @Override
    public List<KhachSan> getKSTop8(int page) {
       Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("From KhachSan ");
        int max = 8;
         q.setMaxResults(max);
        q.setFirstResult((page-1) * max);
        return q.getResultList();
    }

    
    
}
