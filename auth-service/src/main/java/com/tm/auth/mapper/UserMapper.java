package com.tm.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.tm.auth.dtos.request.UserCreationRequest;
import com.tm.auth.dtos.request.UserUpdateRequest;
import com.tm.auth.dtos.response.UserResponse;
import com.tm.auth.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
