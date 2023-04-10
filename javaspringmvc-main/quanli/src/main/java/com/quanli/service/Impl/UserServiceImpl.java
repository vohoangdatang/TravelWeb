/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.quanli.pojos.User;
import com.quanli.repository.UserRepository;
import com.quanli.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service("userDetailsService")
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;
    @Override
    public List<User> getUsers(String username) {
       return this.userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
       if(users.isEmpty())
       {
           throw new UsernameNotFoundException ("khong tim thay user");
       }
       User user = users.get(0);
       Set<GrantedAuthority> auth = new HashSet<>();
       auth.add(new SimpleGrantedAuthority(user.getUserRole()));
       return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),auth);
    }

    @Override
    public void addUser(User user) {
       String pass = user.getPassword();
       user.setPassword(this.passwordEncoder.encode(pass));
       user.setUserRole(user.USER);
       userRepository.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        
        String pass = user.getPassword();
       user.setPassword(this.passwordEncoder.encode(pass));
       
       
       userRepository.updateUser(user);
    }

    @Override
    public void delete(int i) {
        this.userRepository.delete(i);
    }

    @Override
    public User getUserById(int i) {
       return this.userRepository.getUserById(i);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.getAllUser();
    }

    @Override
    public void updateUserwAvatar(User user) {
         try{
          Map r = cloudinary.uploader().upload(user.getFile().getBytes(),
                ObjectUtils.asMap("resource_type","auto"));
            String img = (String) r.get("secure_url");
            System.err.println(img);
            user.setHinhanh(img);
            user.setUserRole(user.USER);
            String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));
       userRepository.updateUser(user);
         }catch(IOException ex)
        {
            System.err.println("loi:" + ex.getMessage());
        }
    }

    @Override
    public List<User> getAllUserByName(String string) {
       return this.userRepository.getAllUserByName(string);
    }

    @Override
    public User getAllUserByus(String string) {
        return this.userRepository.getAllUserByus(string);
    }

    @Override
    public List<User> getAllUserTaiXe() {
       return this.userRepository.getAllUserTaiXe();
    }

    
    
}
