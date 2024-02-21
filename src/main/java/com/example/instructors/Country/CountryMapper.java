package com.example.instructors.Country;

import com.example.instructors.Country.dto.CountryRequest;
import com.example.instructors.Country.dto.CountryResponse;
import com.example.instructors.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mapping(source = "name", target = "name")
    Country mapToCountry(CountryRequest countryRequest);

    CountryResponse mapToResposne(Country country);
}
