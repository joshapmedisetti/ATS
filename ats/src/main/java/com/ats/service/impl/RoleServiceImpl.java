package com.ats.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.entity.Roles;
import com.ats.exception.RoleNotFoundException;
import com.ats.repository.RolesRepository;
import com.ats.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RolesRepository rolesRepository;

	// Insert Role
	public Roles insertRole(Roles role) {
		return rolesRepository.save(role);
	}

	// Get All Roles Data Service
	@Override
	public List<Roles> getAllRoles() {
		return rolesRepository.findAll();
	}

	// Get Role By ID
	@Override
	public Roles getRoleById(Integer roleID) {
		return rolesRepository.findById(roleID).orElseThrow(() -> new RoleNotFoundException("Role Id Not Exists"));
	}

	// Delete Role By Role ID
	@Override
	public String deleteRoleById(Integer roleId) {
		if (!rolesRepository.existsById(roleId)) {
			throw new RoleNotFoundException("Invalid Role ID");
		}
		rolesRepository.deleteById(roleId);
		return "Role Id Deleted ";
	}

	// Update Role
	@Override
	public String updateRole(Integer roleID, Roles role) {
		Roles ogRoleData = rolesRepository.findById(roleID)
				.orElseThrow(() -> new RoleNotFoundException("Invalid Role"));
		ogRoleData.setRoleName(role.getRoleName());
		ogRoleData.setRoleDescription(role.getRoleDescription());
		ogRoleData.setStatus(role.getStatus());
		// Need to add the User id which will fetch from the JWT (pending)
		return "Role Updated Successfully";
	}

}
