package com.tm.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tm.auth.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {}
