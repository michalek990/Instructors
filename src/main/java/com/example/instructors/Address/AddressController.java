package com.example.instructors.Address;

import com.example.instructors.Address.dto.AddressRequest;
import com.example.instructors.Address.dto.AddressResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest addressRequest){
        AddressResponse response = addressService.createAddress(addressRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
