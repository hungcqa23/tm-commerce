package com.tm.auth.mapper;

import org.mapstruct.Mapper;

import com.tm.auth.dto.request.PermissionRequest;
import com.tm.auth.dto.response.PermissionResponse;
import com.tm.auth.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
