package com.tm.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tm.auth.entities.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {}
