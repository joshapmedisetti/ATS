package com.ats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.entity.User;
import com.ats.service.UserService;

@RestController
@RequestMapping("/api/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping("saveUser")
    public User saveUser(@RequestBody User user) {
    	return userService.saveUser(user);
    }
    
  //getUserById
    @GetMapping("/getUserById/{userId}")
    public User getUserById(@PathVariable Integer userId) {
    	return userService.getUserById(userId);
    }

}