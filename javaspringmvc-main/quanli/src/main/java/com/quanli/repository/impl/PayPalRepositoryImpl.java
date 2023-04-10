/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository.impl;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.quanli.repository.PayPalRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.RequestEntity.method;
import static org.springframework.http.RequestEntity.method;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AD
 */
@Repository
@Transactional
public class PayPalRepositoryImpl implements PayPalRepository{

    @Autowired
    private APIContext apiContext;
     @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public Payment createPayment(Double total,String intent, String cancelUrl, String successUrl)
    {
        
                Amount amount = new Amount();
                amount.setCurrency("USD");
		total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
		amount.setTotal(String.format("%.2f", total));
                Transaction transaction = new Transaction();
		transaction.setDescription("dat phong tai lu hanh huy toan");
		transaction.setAmount(amount);
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(transaction);
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");
		Payment payment = new Payment();
                payment.setIntent(intent.toString());
		payment.setPayer(payer);  
		payment.setTransactions(transactions);
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl(cancelUrl);
		redirectUrls.setReturnUrl(successUrl);
		payment.setRedirectUrls(redirectUrls);

        try {
            return payment.create(apiContext);
        } catch (PayPalRESTException ex) {
            Logger.getLogger(PayPalRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    @Override
    public Payment executePayment(String paymentId, String payerId){
       
            Payment payment = new Payment();
            payment.setId(paymentId);
            PaymentExecution paymentExecute = new PaymentExecution();
            paymentExecute.setPayerId(payerId);
        try {
           return payment.execute(apiContext, paymentExecute);
            
        } catch (PayPalRESTException ex) {
            Logger.getLogger(PayPalRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
