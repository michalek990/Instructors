package com.example.instructors.City.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityRequest {
    private String name;
    private String countryName;
}
