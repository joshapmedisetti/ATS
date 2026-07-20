package com.ats.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.dto.LoginRequestDTO;
import com.ats.dto.LoginResponseDTO;
import com.ats.entity.User;
import com.ats.repository.UserRepository;
import com.ats.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO) {

        // Step 1: Find user by username
        User user = userRepository.findByUsername(loginRequestDTO.getUserName());

        // Step 2: Check whether user exists
        if (user == null) {
            throw new RuntimeException("Invalid Username");
        }

        // Step 3: Compare password
        if (!user.getPassword().equals(loginRequestDTO.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        // Step 4: Check user status
        if (!"A".equals(user.getStatus())) {
            throw new RuntimeException("User is Inactive");
        }

        // Step 5: Create response
        LoginResponseDTO response = new LoginResponseDTO();

        response.setUserId(user.getUserId());
        response.setUsername(user.getUsername());
        response.setRole(String.valueOf(user.getRoleId())); // Temporary

        // JWT will be added later
        response.setToken("khdiiu,jkjgkiuiughiuiugiuhfgeiuijomorhubyutto764nhiehlgvnuhu");
        response.setTokenType("Bearer");

        return response;
    }
}