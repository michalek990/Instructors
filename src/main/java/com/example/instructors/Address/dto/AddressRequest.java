package com.example.instructors.Address.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressRequest {
    private String street;
    private String number;
    private String zipcode;
    private String latitude;
    private String longitude;
    private String cityName;
}
