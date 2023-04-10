/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.repository;

import com.quanli.pojos.User;
import java.util.List;

/**
 *
 * @author AD
 */
public interface UserRepository {
    List<User> getUsers(String username);
    void addUser(User user);
    void delete(int id);
    User getUserById(int id);
    List<User> getAllUser();  
    void updateUser(User user);
    void updateUserwAvatar(User user);
    List<User> getAllUserByName(String name);
     User getAllUserByus(String name);
     List<User> getAllUserTaiXe();
   
}
