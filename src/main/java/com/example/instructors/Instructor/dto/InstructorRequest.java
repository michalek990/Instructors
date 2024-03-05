package com.example.instructors.Instructor.dto;

import com.example.instructors.Address.dto.AddressRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InstructorRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private AddressRequest address;
}
