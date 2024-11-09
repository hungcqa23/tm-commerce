package com.tm.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tm.auth.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
