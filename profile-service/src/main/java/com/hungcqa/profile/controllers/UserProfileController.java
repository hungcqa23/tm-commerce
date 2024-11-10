package com.hungcqa.profile.controllers;

import com.hungcqa.profile.dtos.requests.UserProfileCreationRequest;
import com.hungcqa.profile.dtos.responses.UserProfileResponse;
import com.hungcqa.profile.entities.UserProfile;
import com.hungcqa.profile.services.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/")
    UserProfileResponse createProfile(@RequestBody UserProfileCreationRequest userProfileCreationRequest) {
        return userProfileService.createUserProfile(userProfileCreationRequest);
    }

    @GetMapping("/")
    Map<String, Object> getAllProfiles() {
        List<UserProfile> userProfiles = userProfileService.getAllProfiles();
        System.out.println("Hello World!");
        Map<String, Object> response = new HashMap<>();
        response.put("userProfiles", userProfiles);
        
        return response;
    }

    @GetMapping("/{id}")
    UserProfileResponse getProfile(@PathVariable String id) {
        return userProfileService.getProfileById(id);
    }

}
