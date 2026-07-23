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

import com.ats.entity.Roles;
import com.ats.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

	@Autowired
	private RoleService roleService;

	// Get All Roles
	@GetMapping("/getAllRoles")
	public List<Roles> getAllRoles() {
		return roleService.getAllRoles();
	}

	// Get Role By Id
	@GetMapping("/getRoleById/{roleId}")
	public ResponseEntity<Roles> getRoleById(@PathVariable Integer roleId) {
	    Roles role = roleService.getRoleById(roleId);
	    return ResponseEntity.ok(role);
	}

	// Insert Role
	@PostMapping("/insertRole")
	public String insertRole(@RequestBody Roles role) {
		roleService.insertRole(role);
		return "Role Added Successfully";
	}

	// Update Role
	@PutMapping("/updateRole/{roleId}")
	public ResponseEntity<String> updateRole(@PathVariable Integer roleId, @RequestBody Roles role) {
		String message = roleService.updateRole(roleId, role);
		return ResponseEntity.ok(message);
	}

	// deleteRole
	@DeleteMapping("deleteRole/{roleId}")
	public ResponseEntity<String> deleteRole(@PathVariable Integer roleId) {
		String message = roleService.deleteRoleById(roleId);
		return ResponseEntity.ok(message);
	}

}
