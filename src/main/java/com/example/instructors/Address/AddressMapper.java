package com.example.instructors.Address;

import com.example.instructors.Address.dto.AddressRequest;
import com.example.instructors.Address.dto.AddressResponse;
import com.example.instructors.Entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "city", ignore = true) // Ignoruj pole city podczas mapowania
    Address mapToAddress(AddressRequest addressRequest);

    @Mapping(target = "cityId", source = "city.id")
    AddressResponse mapToAddressResponse(Address address);
}
