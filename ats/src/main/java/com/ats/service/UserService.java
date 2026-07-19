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
    
    //Delete by Id
    String deleteById(Integer userId);
    
    //Update user details by id
    String updateUserData(Integer userId, User user);

}