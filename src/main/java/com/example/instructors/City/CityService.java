package com.example.instructors.City;

import com.example.instructors.City.dto.CityRequest;
import com.example.instructors.City.dto.CityResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    CityResponse createCity(CityRequest cityRequest);
    Page<CityResponse> getAllCities(Pageable pageable);
}
