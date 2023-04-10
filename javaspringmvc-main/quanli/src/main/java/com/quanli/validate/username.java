/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.validate;

import com.quanli.pojos.User;
import com.quanli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author AD
 */
@Component
public class username implements Validator{

    @Autowired
    private UserService userDetailsService;
    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
       User u = (User) o;
        if(!this.userDetailsService.getAllUserByName(u.getUsername()).isEmpty())
       {
            errors.rejectValue("username", "user nay da su dung");
       }
      
    }
    
}
