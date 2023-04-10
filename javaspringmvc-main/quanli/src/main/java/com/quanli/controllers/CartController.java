/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.google.gson.Gson;
import com.quanli.pojos.CTDonPhong;
import com.quanli.pojos.CTDonTour;
import com.quanli.pojos.Cart;
import com.quanli.pojos.CartXe;
import com.quanli.pojos.DonPhong;
import com.quanli.pojos.DonTour;
import com.quanli.pojos.Phong;
import com.quanli.pojos.Tour;
import com.quanli.service.DonPhongService;
import com.quanli.service.PhongService;
import com.quanli.service.TourService;
import com.quanli.service.UserService;
import com.quanli.utils.utils;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.json.Json;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.binary.Hex;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AD
 */
@Controller
@Transactional
public class CartController {
    @Autowired
    private PhongService phongService;
     @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private DonPhongService donPhongService;
    @Autowired
    private TourService tourService;
    @RequestMapping("/cart")
    public String showcart()
    {
        return "cart";
    }
    @RequestMapping("/carttour")
    public String showcartTour()
    {
        return "carttour";
    }
    @RequestMapping("/cart/add/{phongid}")
    public String addPhongToCart(@PathVariable(name="phongid")int phongid, HttpSession session)
    {
        HashMap<Integer,Cart> cartItems = (HashMap<Integer,Cart>) session.getAttribute("myCartItems");
        if(cartItems == null)
        {
            cartItems = new HashMap<>();
        }
        
       
        if(cartItems.containsKey(phongid)==true)
                {
                    Cart item = cartItems.get(phongid);
                    item.setSoluong(item.getSoluong()+ 1);
                }
                else
                {
                    
                     Phong phong  =this.phongService.getPhongById(phongid);
                    Cart item = new Cart();
                    item.setPhong(phong);
                    item.setSoluong(1);
                    cartItems.put(phongid, item);
                }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("giaTong", giaTong(cartItems));
        session.setAttribute("slItems", cartItems.size());
        this.phongService.phongDaDat(phongid);
       return "redirect:/cart";
        
    }
    @RequestMapping("/cart/add/tour/{tourid}")
    public String addTourToCart(@PathVariable(name="tourid")int tourid, HttpSession session)
    {
        HashMap<Integer,Cart> cartItems = (HashMap<Integer,Cart>) session.getAttribute("myCartItems");
        if(cartItems == null)
        {
            cartItems = new HashMap<>();
        }
        
       int sl = 0;
        if(cartItems.containsKey(tourid)==true)
                {
                    Cart item = cartItems.get(tourid);
                    item.setSoluong(item.getSoluong()+ 1);
                    sl=item.getSoluong();
                }
                else
                {
                     Tour tour  =this.tourService.getTourById(tourid);
                    Cart item = new Cart();
                    item.setTour(tour);
                    item.setSoluong(1);
                    cartItems.put(tourid, item);
                    sl=item.getSoluong();
                }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("giaTong", giaTour(cartItems));
        session.setAttribute("slItems", cartItems.size());
        session.setAttribute("soluong", sl);
        
       return "redirect:/carttour";
        
    }
    @RequestMapping("/cart/delete/{idphong}")
    public String deltephong(@PathVariable(name="idphong")int idphong , HttpSession session)
    {
        HashMap<Integer,Cart> cartItems = (HashMap<Integer,Cart>) session.getAttribute("myCartItems");
        if(cartItems == null)
        {
            cartItems = new HashMap<>();
        }
        if(cartItems.containsKey(idphong)==true)
        {
            cartItems.remove(idphong);
        }
         session.setAttribute("myCartItems", cartItems);
        session.setAttribute("giaTong", giaTong(cartItems));
        session.setAttribute("slItems", cartItems.size());
        this.phongService.phongHuy(idphong);
        return "redirect:/khachsan";
        
    }
    @RequestMapping("/cart/delete/tour/{idtour}")
    public String delteTour(@PathVariable(name="idtour")int idtour , HttpSession session)
    {
        HashMap<Integer,Cart> cartItems = (HashMap<Integer,Cart>) session.getAttribute("myCartItems");
        if(cartItems == null)
        {
            cartItems = new HashMap<>();
        }
        if(cartItems.containsKey(idtour)==true)
        {
            cartItems.remove(idtour);
        }
         session.setAttribute("myCartItems", cartItems);
        session.setAttribute("giaTong", giaTong(cartItems));
        session.setAttribute("slItems", cartItems.size());
        this.phongService.phongHuy(idtour);
        return "redirect:/tour";
        
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
    @PostMapping("/checkout")
    public String showcheckout(HttpSession session, @ModelAttribute(name="donphong")  DonPhong donphong)
    {
       
       
            HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
            if(cartItems == null)
            {
                cartItems = new HashMap<>();
            }
            donphong.setNgaytao(new Timestamp(new Date().getTime()));
            Session session1 = this.sessionFactoryBean.getObject().getCurrentSession();
            session1.save(donphong);
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
            donphong.setPhuongthuc("offline");
            session1.update(donphong);
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
            cartItems = new HashMap<>();
            session.setAttribute("myCartItems", cartItems);
            session.setAttribute("giaTong", 0);
            session.setAttribute("slItems", 0);
            
        return "datphongthanhcong";
    }
    @PostMapping("/checkout/tour")
    public String showcheckoutTour(HttpSession session, @ModelAttribute(name="dontour")  DonTour dontour)
    {
       
       
            HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
            if(cartItems == null)
            {
                cartItems = new HashMap<>();
            }
            dontour.setNgaytao(new Timestamp(new Date().getTime()));
            Session session1 = this.sessionFactoryBean.getObject().getCurrentSession();
            dontour.setPhuongthuc("offline");
            dontour.setTinhtrang("chưa thanh toán");
            dontour.setTongtien(giaTour(cartItems));
            session1.save(dontour);
            for(Map.Entry<Integer,Cart> entry: cartItems.entrySet())
            {
               CTDonTour ctdontour = new CTDonTour();
               ctdontour.setDontour(dontour);
               //ctdontour.setTour(entry.getValue().getTour());
               ctdontour.setGia(entry.getValue().getTour().getPrice());
               ctdontour.setSoluong(entry.getValue().getSoluong());
               session1.save(ctdontour);
            }
            cartItems = new HashMap<>();
            session.setAttribute("myCartItems", cartItems);
            session.setAttribute("giaTong", 0);
            session.setAttribute("slItems", 0);
            
        return "datphongthanhcong";
    }
    @RequestMapping("/khachsan/phuongthucthanhtoan")
    public String phuongthuc()
    {
        return "phuongthucthanhtoan";
    }
    @RequestMapping("/tour/phuongthucthanhtoan")
    public String phuongthuc2()
    {
        return "phuongthucthanhtoantour";
    }
    
    @RequestMapping("/chuyenxe/cart")
    public String cartCX(Model model, HttpSession session) throws NoSuchAlgorithmException, Exception
    {
        Map<Integer, CartXe> cart = (Map<Integer, CartXe>) session.getAttribute("cart");
        if(cart !=null)
            model.addAttribute("carts",cart.values());
        else
            model.addAttribute("carts",null);
        model.addAttribute("amount", utils.sumAmount(cart));
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        UUID uuid = UUID.randomUUID();
        model.addAttribute("requestId", uuid );
       model.addAttribute("secretKey","WRKLP6rgXmNxwPGCpKj4oZ9UXMgt4llG");
       model.addAttribute("accessKey","UhmXBQrWPA8dfho6");
       String rawsignature = "accessKey=UhmXBQrWPA8dfho6&amount=300000&extraData=&ipnUrl=https://momo.vn&orderId=1&orderInfo=toantran&partnerCode=MOMOBWEX20210917&redirectUrl=https://momo.vn&requestId=48446a13-951b-43fd-be49-b164de2cdfca&requestType=captureWallet";
       
       return "cartCX";
    }

   
}
