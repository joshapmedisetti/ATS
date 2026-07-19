package com.ats.service;

import java.util.List;

import com.ats.entity.User;

public interface UserService {

	//Get all Users
    List<User> getAllUsers();
    
    //Insert user Data
    User saveUser(User user);
    
    //Get User By Id
    User getUserById(Integer userId);

}