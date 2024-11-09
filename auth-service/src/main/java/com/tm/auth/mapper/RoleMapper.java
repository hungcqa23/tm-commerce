package com.tm.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tm.auth.dtos.request.RoleRequest;
import com.tm.auth.dtos.response.RoleResponse;
import com.tm.auth.entities.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
