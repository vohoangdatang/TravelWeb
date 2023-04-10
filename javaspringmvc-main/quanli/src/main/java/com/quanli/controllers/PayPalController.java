/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.quanli.pojos.CTDonPhong;
import com.quanli.pojos.CTDonTour;
import com.quanli.pojos.Cart;
import com.quanli.pojos.DonPhong;
import com.quanli.pojos.DonTour;
import com.quanli.service.PaypalService;
import com.quanli.service.UserService;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author AD
 */
@Controller
@Transactional
public class PayPalController {
    @Autowired
    PaypalService service;
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Autowired
    private UserService userDetailsService;
    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";
    @PostMapping("/paypal")
	public String payment(HttpSession session, @ModelAttribute("donphong") DonPhong donphong) {
              HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
            if(cartItems == null)
            {
                cartItems = new HashMap<>();
            }
            donphong.setNgaytao(new Timestamp(new Date().getTime()));
            Session session1 = this.sessionFactoryBean.getObject().getCurrentSession();
            donphong.setPhuongthuc("paypal");
            System.err.println("da tao donphong");
            String pattern = "yyyy-mm-dd";
            DateFormat df = new SimpleDateFormat(pattern);
            Date ngaynhan = donphong.getNgaynhan();
            Date ngaytra = donphong.getNgaytra();
            String ngaynhanstr= df.format(ngaynhan);
            String ngaytrastr= df.format(ngaytra);
            LocalDate ngaynhan1 = LocalDate.parse(ngaynhanstr);
            LocalDate ngaytra1 = LocalDate.parse(ngaytrastr);
            long demngay = ChronoUnit.DAYS.between(ngaynhan1, ngaytra1);
            donphong.setTongtien(giaTong(cartItems)*demngay);
            donphong.setTinhtrang("đã thanh toán");
            session1.save(donphong);
            double total= donphong.getTongtien()/20000;
            for(Map.Entry<Integer,Cart> entry: cartItems.entrySet())
            {
                CTDonPhong ctdonphong = new CTDonPhong();
                ctdonphong.setDonphong(donphong);
                ctdonphong.setPhong(entry.getValue().getPhong());
                ctdonphong.setGia(entry.getValue().getPhong().getGiaPhong());
                ctdonphong.setSoluong(entry.getValue().getSoluong());
                ctdonphong.setTinhtrang(true);
                session1.save(ctdonphong);
            }
            Payment payment = service.createPayment(total,"sale", "http://localhost:8080/quanli/" + CANCEL_URL,"http://localhost:8080/quanli/" + SUCCESS_URL);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return "redirect:"+link.getHref();
                }
            }
		return "redirect:/";
	}
    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "paypalcancel";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId)
    {
        Payment payment = service.executePayment(paymentId, payerId);
        //payment.getState().equals("approved");
        return "paypalsuccess";
    }
    @RequestMapping("/checkout/paypal")
    public String showcheckout(Model model)
    {
        model.addAttribute("donphong", new DonPhong());
        return "checkoutpaypal";
    }
    @RequestMapping("/checkout/tour/paypal")
    public String showcheckoutTour(Model model)
    {
        model.addAttribute("dontour", new DonTour());
        return "checkoutpaypaltour";
    }
    @RequestMapping("/checkout/paypal/{username}")
    public String showcheckout(Model model, @PathVariable(name="username") String username)
    {
        
        model.addAttribute("donphong", new DonPhong());
        model.addAttribute("user", this.userDetailsService.getUsers(username));
        return "checkoutpaypal";
    }
    @RequestMapping("/checkout//tour/paypal/{username}")
    public String showcheckoutTour(Model model, @PathVariable(name="username") String username)
    {
        
        model.addAttribute("dontour", new DonTour());
        model.addAttribute("user", this.userDetailsService.getUsers(username));
        return "checkoutpaypaltour";
    }
    public long giaTong(HashMap<Integer,Cart> cartItems)
    {
        int count = 0;
        for(Map.Entry<Integer,Cart> List: cartItems.entrySet())
        {
            count+= List.getValue().getPhong().getGiaPhong()* List.getValue().getSoluong();
        }
        return count;
    }
    public long giaTour(HashMap<Integer,Cart> cartItems)
    {
        int count = 0;
        for(Map.Entry<Integer,Cart> List: cartItems.entrySet())
        {
            count+= List.getValue().getTour().getPrice()* List.getValue().getSoluong();
        }
        return count;
    }
    @PostMapping("/paypal/tour")
	public String paymentTour(HttpSession session, @ModelAttribute("dontour") DonTour dontour) {
              HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
            if(cartItems == null)
            {
                cartItems = new HashMap<>();
            }
            dontour.setNgaytao(new Timestamp(new Date().getTime()));
            Session session1 = this.sessionFactoryBean.getObject().getCurrentSession();
            dontour.setPhuongthuc("paypal");
            dontour.setTinhtrang("đã thanh toán");
            dontour.setTongtien(giaTour(cartItems));
            session1.save(dontour);
            double total= dontour.getTongtien()/20000;
            for(Map.Entry<Integer,Cart> entry: cartItems.entrySet())
            {
               CTDonTour ctdontour = new CTDonTour();
               ctdontour.setDontour(dontour);
              // ctdontour.setTour(entry.getValue().getTour());
               ctdontour.setGia(entry.getValue().getTour().getPrice());
               ctdontour.setSoluong(entry.getValue().getSoluong());
               session1.save(ctdontour);
            }
            Payment payment = service.createPayment(total,"sale", "http://localhost:8080/quanli/" + CANCEL_URL,"http://localhost:8080/quanli/" + SUCCESS_URL);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return "redirect:"+link.getHref();
                }
            }
		return "redirect:/";
	}
}
