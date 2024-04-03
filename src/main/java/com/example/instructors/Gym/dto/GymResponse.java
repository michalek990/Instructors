package com.example.instructors.Gym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GymResponse {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String description;
    private String price;
    private String latitude;
    private String longitude;
}
