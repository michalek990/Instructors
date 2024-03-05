package com.example.instructors.City;

import com.example.instructors.City.dto.CityRequest;
import com.example.instructors.City.dto.CityResponse;
import com.example.instructors.Entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City mapToCity(CityRequest cityRequest);

    @Mapping(target = "id", source = "id")
    CityResponse mapToResponse(City city);
}
