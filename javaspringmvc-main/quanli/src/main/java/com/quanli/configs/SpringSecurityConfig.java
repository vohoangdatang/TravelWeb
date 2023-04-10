/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.quanli.configs.handlers.LoginSuccessHandlers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author AD
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages={"com.quanli.repository","com.quanli.service"})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public Cloudinary cloudinary()
    {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
        "cloud_name","ttfon1432","api_key","531531543342741","api_secret","1mP6Q4vga-KTUExqwwfvuh-DFh8","secure",true
        ));
        return cloudinary;
    }
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandlers()
    {
        return new LoginSuccessHandlers();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
        http.formLogin().successHandler(this.loginSuccessHandler);
        http.logout().logoutSuccessUrl("/login");
        http.exceptionHandling().accessDeniedPage("/login?accessDeined");
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/nhanvien/**").access("hasRole('ROLE_NV')");
        http.authorizeRequests().antMatchers("/taixe/**").access("hasRole('ROLE_TX')");
        http.csrf().disable();
    }
    
}
