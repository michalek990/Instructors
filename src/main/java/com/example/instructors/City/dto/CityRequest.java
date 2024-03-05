package com.example.instructors.City.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CityRequest {
    private String name;
    private String countryName;
}
