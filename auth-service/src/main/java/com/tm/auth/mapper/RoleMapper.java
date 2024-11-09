package com.tm.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tm.auth.dto.request.RoleRequest;
import com.tm.auth.dto.response.RoleResponse;
import com.tm.auth.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
