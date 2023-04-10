/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service;

import com.paypal.api.payments.Payment;

/**
 *
 * @author AD
 */
public interface PaypalService {
    public Payment createPayment(Double total,String intent, String cancelUrl, String successUrl);
    public Payment executePayment(String paymentId, String payerId);
}
