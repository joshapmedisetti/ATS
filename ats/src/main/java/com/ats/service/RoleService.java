package com.ats.service;

import java.util.List;

import com.ats.entity.Roles;

public interface RoleService {

	// Insert Role
	Roles insertRole(Roles role);

	// Get All Roles Data Service
	List<Roles> getAllRoles();

	// Get Role By Role ID
	Roles getRoleById(Integer roleId);

	// Delete Role By Role ID
	String deleteRoleById(Integer roleId);

	// Update Role By Role ID
	String updateRole(Integer roleId, Roles role);

}
