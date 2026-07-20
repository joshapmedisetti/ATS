package com.ats.service;

import com.ats.dto.LoginRequestDTO;
import com.ats.dto.LoginResponseDTO;

public interface AuthService {
	
	LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO);

}
