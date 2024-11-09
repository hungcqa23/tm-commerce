package com.tm.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tm.auth.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
