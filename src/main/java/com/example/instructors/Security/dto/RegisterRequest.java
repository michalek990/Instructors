package com.example.instructors.Security.dto;

import com.example.instructors.Address.dto.AddressRequest;
import com.example.instructors.Entity.Address;
import com.example.instructors.Entity.enums.Role;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private Role role;
    private AddressRequest address;
}
