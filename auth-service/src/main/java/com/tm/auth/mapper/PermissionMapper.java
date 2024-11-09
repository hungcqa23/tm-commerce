package com.tm.auth.mapper;

import org.mapstruct.Mapper;

import com.tm.auth.dtos.request.PermissionRequest;
import com.tm.auth.dtos.response.PermissionResponse;
import com.tm.auth.entities.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
