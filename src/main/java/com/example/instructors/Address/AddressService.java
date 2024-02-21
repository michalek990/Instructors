package com.example.instructors.Address;

import com.example.instructors.Address.dto.AddressRequest;
import com.example.instructors.Address.dto.AddressResponse;
import com.example.instructors.City.CityRepository;
import com.example.instructors.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final CityRepository cityRepository;

    public AddressResponse createAddress(AddressRequest addressRequest){
        Address address = addressMapper.mapToAddress(addressRequest);
        address.setCity(cityRepository.findById(addressRequest.getCityId())
                .orElseThrow(() -> new RuntimeException("City not found with id " + addressRequest.getCityId())));
        Address savedAddress = addressRepository.save(address);
        return addressMapper.mapToAddressResponse(savedAddress);
    }
}
