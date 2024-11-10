package com.hungcqa.profile.mappers;

import com.hungcqa.profile.dtos.requests.UserProfileCreationRequest;
import com.hungcqa.profile.dtos.responses.UserProfileResponse;
import com.hungcqa.profile.entities.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(UserProfileCreationRequest userProfileCreationRequest);
    UserProfileResponse toUserProfileResponse(UserProfile userProfile);
}
