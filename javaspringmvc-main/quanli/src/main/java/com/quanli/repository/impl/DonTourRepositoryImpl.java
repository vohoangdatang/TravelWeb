/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository.impl;

import com.quanli.pojos.CTDonTour;
import com.quanli.pojos.CartXe;
import com.quanli.pojos.ChuyenXe;
import com.quanli.pojos.DonTour;
import com.quanli.repository.ChuyenXeRepository;
import com.quanli.repository.DonTourRepository;
import com.quanli.repository.UserRepository;
import com.quanli.utils.utils;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AD
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class DonTourRepositoryImpl implements DonTourRepository{

      @Autowired
    private UserRepository userRepository;
      @Autowired
      private ChuyenXeRepository chuyenXeRepository;
     @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public List<DonTour> getDoanhThu() {
       Session session = this.sessionFactoryBean.getObject().getCurrentSession();
       String query = "select dp.ngaytao, sum(dp.tongtien) from DonTour as dp group by dp.ngaytao";
              
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<DonTour> getLishSuById(int id) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         String query = "From CTDonTour dp where dp.dontour.user.id =:id";
         Query q = session.createQuery(query);
         q.setParameter("id", id);
         return q.getResultList();
    }

    @Override
    public List<DonTour> getAllDonTour() {
       Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         Query q = session.createQuery("From DonTour ");
        return q.getResultList(); }

    @Override
    public void xoa(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
      DonTour donphong = session.get(DonTour.class, id);
      session.remove(donphong);}

    @Override
    public DonTour getDTById(int id) {
       Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        DonTour donphong = session.get(DonTour.class, id);
        return donphong;
    }

    @Override
    public void update(DonTour donphong) {
       Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        session.update(donphong);
    }

    @Override
    public boolean addDonCX(Map<Integer, CartXe> cart,int id) {
        try{
            Session session = this.sessionFactoryBean.getObject().getCurrentSession();
            DonTour order = new DonTour();
            System.out.println("bat dau");
            order.setUser(this.userRepository.getUserById(id));
            System.out.println("OK");
            order.setNgaytao(new Date());
            order.setTongtien(utils.sumAmount(cart));
            order.setPhuongthuc("offline");
            order.setTinhtrang("chưa thanh toán");
            session.save(order);
            for(CartXe c: cart.values())
            {
                CTDonTour d = new CTDonTour();
                d.setDontour(order);
                d.setChuyenxe(this.chuyenXeRepository.getChuyenXeById(c.getId()));
                d.setGia(c.getGia());
                d.setSoluong(c.getSoluong());
                ChuyenXe cx = this.chuyenXeRepository.getChuyenXeById(c.getId());
                cx.setSoluong(cx.getSoluong() - c.getSoluong());
                this.chuyenXeRepository.updateCX(cx);
                session.save(d);
            }
            return true;
        }catch(HibernateException ex)
        {
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public List<DonTour> getDoanhThuTheoThang(int thang) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
       String query = "select dp.ngaytao, sum(dp.tongtien) from DonTour as dp where month(dp.ngaytao)=:thang group by dp.ngaytao";
              
        Query q = session.createQuery(query);
        q.setParameter("thang", thang);
        return q.getResultList();
    }

   
    
}
