/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;


import com.google.gson.Gson;
import com.mservice.allinone.models.CaptureMoMoResponse;
import com.mservice.allinone.models.PayGateResponse;
import com.mservice.allinone.models.PaymentResponse;
import com.mservice.allinone.models.QueryStatusTransactionResponse;
import com.mservice.allinone.processor.allinone.CaptureMoMo;
import com.mservice.allinone.processor.allinone.PaymentResult;
import com.mservice.allinone.processor.allinone.QueryStatusTransaction;
import com.mservice.shared.sharedmodels.Environment;
import com.mservice.shared.sharedmodels.HttpResponse;
import com.mservice.shared.utils.Execute;
import com.mservice.shared.utils.LogUtils;
import com.quanli.pojos.CartXe;
import com.quanli.utils.utils;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AD
 */
@Controller
public class MomoController {
     public static String encode(String key, String data) throws Exception {
    Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
    SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
    sha256_HMAC.init(secret_key);

    return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
     }
    @RequestMapping("/momo")
    public String momo(HttpSession session,Model model) throws Exception 
    {
        Map<Integer, CartXe> cart = (Map<Integer, CartXe>) session.getAttribute("cart");
        if(cart !=null)
            model.addAttribute("carts",cart.values());
        else
            model.addAttribute("carts",null);
        String endpoint = "https://test-payment.momo.vn/gw_payment/transactionProcessor";
        String partnerCode = "MOMOBWEX20210917";
        String accessKey = "UhmXBQrWPA8dfho6";
        String secretKey = "WRKLP6rgXmNxwPGCpKj4oZ9UXMgt4llG";
        String orderInfo = "pay with MoMo";
        String redirectUrl = "https://webhook.site/b3088a6a-2d17-4f8d-a383-71389a6c600b";
        String ipnUrl = "https://webhook.site/b3088a6a-2d17-4f8d-a383-71389a6c600b";
        String amount = String.valueOf(utils.sumAmount(cart));
        String orderId = String.valueOf(System.currentTimeMillis());
        String requestId = String.valueOf(System.currentTimeMillis());
        String requestType = "captureWallet";
        String extraData = ""; 
        String raw = "accessKey="+accessKey+"&amount="+amount+"&extraData="+extraData+"&ipnUrl="+ipnUrl+"&orderId="+orderId+"&orderInfo="+orderInfo+"&partnerCode="+partnerCode+"&redirectUrl="+redirectUrl+"&requestId="+requestId+"&requestType="+requestType;
        String signature = encode(secretKey, raw);
        model.addAttribute("partnerCode",partnerCode);
        model.addAttribute("accessKey",accessKey);
        model.addAttribute("secretKey",secretKey);
        model.addAttribute("orderInfo",orderInfo);
        model.addAttribute("redirectUrl",redirectUrl);
        model.addAttribute("ipnUrl",ipnUrl);
        model.addAttribute("amount",amount);
        model.addAttribute("orderId",orderId);
        model.addAttribute("requestId",requestId);
        model.addAttribute("requestType",requestType);
        model.addAttribute("signature",signature);
        return "momo";
    }
    @GetMapping("/momo/pay")
    public String momosdda(HttpSession session,Model model) throws Exception
    {
         Map<Integer, CartXe> cart = (Map<Integer, CartXe>) session.getAttribute("cart");
        if(cart !=null)
            model.addAttribute("carts",cart.values());
        else
            model.addAttribute("carts",null);
         LogUtils.init();
        String requestId = String.valueOf(System.currentTimeMillis());
        String orderId = String.valueOf(System.currentTimeMillis());
        String amount = String.valueOf(utils.sumAmount(cart));

        String orderInfo = "Pay With MoMo";
        String returnURL = "https://google.com.vn";
        String notifyURL = "https://google.com.vn";
        String extraData = "";
        String bankCode = "SML";

        Environment environment = Environment.selectEnv("dev", Environment.ProcessType.PAY_GATE);


//      Remember to change the IDs at enviroment.properties file

//        Payment Method- Phương thức thanh toán
        CaptureMoMoResponse captureMoMoResponse = CaptureMoMo.process(environment, orderId, requestId, amount, orderInfo, returnURL, notifyURL, "");

//        Transaction Query - Kiểm tra trạng thái giao dịch
        QueryStatusTransactionResponse queryStatusTransactionResponse = QueryStatusTransaction.process(environment, orderId, requestId);
       
        
//      Process Payment Result - Xử lý kết quả thanh toán
        PayGateResponse payGateResponse = PaymentResult.process(environment,new PayGateResponse());
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        CaptureMoMoResponse target2 = gson.fromJson(captureMoMoResponse.getJsonObject(), CaptureMoMoResponse.class); 
        
        return "redirect:"+target2.getPayUrl();

    }
   
    
}
