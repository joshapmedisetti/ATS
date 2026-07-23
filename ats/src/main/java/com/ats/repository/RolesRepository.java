package com.ats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {

}
