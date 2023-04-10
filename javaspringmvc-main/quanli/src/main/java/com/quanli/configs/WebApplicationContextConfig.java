/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.quanli.formatter.DanhGiaCXFormatter;
import com.quanli.formatter.KhachSanFormatter;
import com.quanli.formatter.LoaiPhongFormatter;
import com.quanli.formatter.UserFormatter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author AD
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages={"com.quanli.controllers","com.quanli.repository","com.quanli.service","com.quanli.validate"})
public class WebApplicationContextConfig implements WebMvcConfigurer{
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }   
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }
    @Bean
    public LocalValidatorFactoryBean validator()
    {
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        return v;
    }
    
    
     @Bean
    public MessageSource messageSource() 
    {
        ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
        resource.setBasename("messages");
        return resource;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new LoaiPhongFormatter());
        registry.addFormatter(new KhachSanFormatter());
        registry.addFormatter(new UserFormatter());
        registry.addFormatter(new DanhGiaCXFormatter());
    }
    @Bean
    public CommonsMultipartResolver multipartResolver()
    {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }
}
