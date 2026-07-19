package com.ats.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.entity.User;
import com.ats.exception.UserNotFoundException;
import com.ats.repository.UserRepository;
import com.ats.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //getAllUsers
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //saveUser
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public User getUserById(Integer userId) {
    	return userRepository.findById(userId).orElseThrow( () -> new UserNotFoundException("User with UserID : " +userId +" Doesn't Exist"));
    }
    
    @Override
    public String deleteById(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }

        userRepository.deleteById(userId);
        return "User Deleted Succesfully";
    }

    @Override
    public String updateUserData(Integer userId, User user){
    	User ogUserData = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Invalid UserID: "+userId));
    	ogUserData.setRoleId(user.getRoleId());
    	ogUserData.setFirstName(user.getFirstName());
    	ogUserData.setLastName(user.getLastName());
    	ogUserData.setEmailId(user.getEmailId());
    	ogUserData.setMobileNumber(user.getMobileNumber());
    	userRepository.save(ogUserData);
		return "User Data Updated Successfully";
    }

    
}