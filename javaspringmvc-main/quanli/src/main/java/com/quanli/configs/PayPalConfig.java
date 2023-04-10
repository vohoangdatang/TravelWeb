/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.configs;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author AD
 */
@Configuration
public class PayPalConfig {
    @Value("AfDY-WgoHfJ9J0v5kL_afnbel2jbpeJUUpzjhjSA_TLswFP7LhCcaobf4AyKAskS0Iz2oStmdSn_lR_g")
    String clientId;
    @Value("EG5Kb-Xm9Q0tgqTbMQz5LKRKTQk4Hh_x19XPhtn8sg71A25z7LNoJqKs6APFAjPe3U2S-lC39YM6m7vg")
    private String clientSecret;
    @Value("sandbox")
    private String mode;
    
    @Bean
	public Map<String, String> paypalSdkConfig() {
		Map<String, String> configMap = new HashMap<>();
		configMap.put("mode", mode);
		return configMap;
	}

	@Bean
	public OAuthTokenCredential oAuthTokenCredential() {
		return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
	}

	@Bean
	public APIContext apiContext() throws PayPalRESTException {
		APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
		context.setConfigurationMap(paypalSdkConfig());
		return context;
	}
}
