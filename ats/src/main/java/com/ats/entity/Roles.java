package com.ats.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ROLES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID")
	private Integer roleId;
	
	@Column(name = "ROLE_NAME", nullable = false, length = 100)
	private String roleName;
	
	@Column(name = "ROLE_DESCRIPTION", nullable = false, length=255)
	private String roleDescription;
	
	@Column(name = "STATUS",nullable=false, length=1)
	private Character status;
	
	@Column(name = "CREATED_BY",nullable=false, length=10)
	private Integer createdBy;
	
	@Column(name = "CREATED_DATE", insertable = false, updatable = false)
    private LocalDateTime createdDate; 

}
