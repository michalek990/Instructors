package com.example.instructors.Address.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressResponse {
    private Long addressId;
    private String street;
    private String number;
    private String zipcode;
    private Long cityId;
}
