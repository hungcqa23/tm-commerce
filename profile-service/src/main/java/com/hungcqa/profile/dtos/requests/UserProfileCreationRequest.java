package com.hungcqa.profile.dtos.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileCreationRequest {

    String firstName;
    String lastName;
    String city;
    LocalDate dob;
}