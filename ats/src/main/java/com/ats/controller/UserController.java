package com.ats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    //deleteById
    @DeleteMapping("deleteById/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {

        String message = userService.deleteById(userId);

        return ResponseEntity.ok(message);
    }
    
    //Update User Data //Joshap
    @PutMapping("updateUserData/{userId}")
    public ResponseEntity<String> updateUserData(@PathVariable Integer userId,@RequestBody User user){
    	String message=userService.updateUserData(userId, user);
    	return ResponseEntity.ok(message);
    }

}