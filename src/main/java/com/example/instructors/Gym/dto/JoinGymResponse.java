package com.example.instructors.Gym.dto;

import com.example.instructors.Address.dto.AddressResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoinGymResponse {
    private String instructorFirstname;
    private String instructorLastname;
    private String instructorEmail;
    private String gymName;
    private String gymEmail;
    private String gymPhoneNumber;
    private AddressResponse address;
}
