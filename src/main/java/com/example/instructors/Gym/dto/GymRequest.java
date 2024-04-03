package com.example.instructors.Gym.dto;

import com.example.instructors.Address.dto.AddressRequest;
import com.example.instructors.Entity.enums.DayOfWeek;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GymRequest {
    private String name;
    private String phoneNumber;
    private String email;
    private String description;
    private DayOfWeek dayOfWeek;
    private String openingHours;
    private String closingHours;
    private AddressRequest address;
}
