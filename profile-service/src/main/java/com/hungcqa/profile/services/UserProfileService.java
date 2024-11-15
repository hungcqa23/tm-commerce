package com.hungcqa.profile.services;

import com.hungcqa.profile.dtos.requests.UserProfileCreationRequest;
import com.hungcqa.profile.dtos.responses.UserProfileResponse;
import com.hungcqa.profile.entities.UserProfile;
import com.hungcqa.profile.mappers.UserProfileMapper;
import com.hungcqa.profile.repositories.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    public UserProfileResponse createUserProfile(UserProfileCreationRequest userProfileCreationRequest) {
        UserProfile userProfile = userProfileMapper.toUserProfile(userProfileCreationRequest);
        userProfile = userProfileRepository.save(userProfile);

        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    public UserProfileResponse getProfileById(String id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User profile not found"));

        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    public List<UserProfile> getAllProfiles() {
        return userProfileRepository.findAll();
    }
}
