package com.example.instructors.Instructor.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class InstructorResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String streetName;
    private String number;
    private String zipcode;
    private String cityName;
}
