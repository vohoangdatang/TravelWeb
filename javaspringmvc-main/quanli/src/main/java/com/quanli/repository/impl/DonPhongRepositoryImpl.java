/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository.impl;

import com.quanli.repository.DonPhongRepository;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import com.quanli.pojos.DonPhong;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.mvel2.ast.DoNode;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AD
 */
@Repository
@Transactional
public class DonPhongRepositoryImpl implements DonPhongRepository{

     @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<DonPhong> getDonPhong() {
       Session session = this.sessionFactoryBean.getObject().getCurrentSession();
       String query = "select dp.ngaytao, sum(dp.tongtien) from DonPhong as dp group by dp.ngaytao";
              
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<DonPhong> getDoanhThuTheoKS() {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
       String query = "select p.khachsan.tenKS, sum(ct.gia) from CTDonPhong ct, Phong p where p.idPhong = ct.idphong group by p.khachsan.tenKS";
              
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<DonPhong> getLishSuById(String id) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         String query = "From CTDonPhong dp where dp.donphong.sdt =:id";
         Query q = session.createQuery(query);
         q.setParameter("id", id);
         return q.getResultList();
    }

    @Override
    public List<DonPhong> getAllDonPhong() {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         Query q = session.createQuery("From DonPhong ");
        return q.getResultList();
    }

    @Override
    public void xoa(int  id) {
      Session session = this.sessionFactoryBean.getObject().getCurrentSession();
      DonPhong donphong = session.get(DonPhong.class, id);
      session.remove(donphong);
    }

    @Override
    public DonPhong getDPById(int i) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
      DonPhong donphong = session.get(DonPhong.class, i);
      return donphong;
    }

    @Override
    public void update(DonPhong dp) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        session.update(dp);
    }
     
    
   
    
}
