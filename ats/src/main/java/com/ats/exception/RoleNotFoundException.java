package com.ats.exception;

// Role Not found Custom exception
@SuppressWarnings("serial")
public class RoleNotFoundException extends RuntimeException {
	
	public RoleNotFoundException(String message) {
		super(message);
	}
}
