package com.example.instructors.City;

import com.example.instructors.City.dto.CityRequest;
import com.example.instructors.City.dto.CityResponse;
import com.example.instructors.Components.Aspect.AdminOnly;
import com.example.instructors.Country.CountryRepository;
import com.example.instructors.Entity.City;
import com.example.instructors.Entity.Country;
import com.example.instructors.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AdminOnly
@RequiredArgsConstructor
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    private final CountryRepository countryRepository;

    @Override
    public CityResponse createCity(CityRequest cityRequest) {
        City city = cityMapper.mapToCity(cityRequest);
        Country country = countryRepository.getCountryByName(cityRequest.getCountryName())
                .orElseThrow(() -> new NotFoundException("Country not found with name " + cityRequest.getCountryName()));
        City cityToSave = cityRepository.save(city);
        return cityMapper.mapToResponse(cityToSave);
    }

    @Override
    public Page<CityResponse> getAllCities(Pageable pageable) {
        Page<City> cities = cityRepository.findAll(pageable);
        return cities.map(cityMapper::mapToResponse);
    }
}
