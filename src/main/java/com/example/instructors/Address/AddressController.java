package com.example.instructors.Address;

import com.example.instructors.Address.dto.AddressRequest;
import com.example.instructors.Address.dto.AddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest addressRequest){
        AddressResponse response = addressService.createNewAddress(addressRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable Long addressId, @RequestBody AddressRequest addressRequest){
        AddressResponse response = addressService.updateAddress(addressId, addressRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<AddressResponse>> getAllAddresses(Pageable pageable){
        return ResponseEntity.ok(addressService.getAllAddresses(pageable));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress(Long addressId){
        addressService.deleteAddress(addressId);
        return ResponseEntity.noContent().build();
    }
}
