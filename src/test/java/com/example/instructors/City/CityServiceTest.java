package com.example.instructors.City;

import com.example.instructors.City.dto.CityRequest;
import com.example.instructors.City.dto.CityResponse;
import com.example.instructors.Country.CountryRepository;
import com.example.instructors.Entity.City;
import com.example.instructors.Entity.Country;
import com.example.instructors.Exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @Mock
    private CountryRepository countryRepository;

    @Mock
    private CityMapper cityMapper;

    @InjectMocks
    private CityServiceImpl cityService;

    @Test
    void createCity_ShouldReturnCityResponse() {
        City city = City.builder()
                .id(1L)
                .name("City1")
                .build();

        CityResponse cityResponse = CityResponse.builder()
                .id(1L)
                .name("City1")
                .build();

        CityRequest cityRequest = CityRequest.builder()
                .name("City1")
                .countryName("Country1")
                .build();

        when(cityMapper.mapToCity(cityRequest)).thenReturn(city);
        when(countryRepository.getCountryByName("Country1")).thenReturn(Optional.of(Country.builder().id(1L).name("Country1").build()));
        when(cityRepository.save(city)).thenReturn(city);
        when(cityMapper.mapToResponse(city)).thenReturn(cityResponse);

        CityResponse result = cityService.createCity(cityRequest);

        assertEquals(cityResponse, result);
    }

    @Test
    void createCity_ShouldThrowNotFoundException_WhenCountryIsInvalid() {
        String invalidCountryName = "Unknown Country";
        CityRequest cityRequest = new CityRequest("Test City", invalidCountryName);

        when(countryRepository.getCountryByName(invalidCountryName)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> cityService.createCity(cityRequest));
    }

    @Test
    void getAllCities_ShouldReturnAllCities() {
        City city1 = City.builder().id(1L).name("City1").build();
        City city2 = City.builder().id(2L).name("City2").build();
        CityResponse cityResponse1 = CityResponse.builder().id(1L).name("City1").build();
        CityResponse cityResponse2 = CityResponse.builder().id(2L).name("City2").build();

        List<City> cities = Arrays.asList(city1, city2);
        Page<City> cityPage = new PageImpl<>(cities);

        when(cityRepository.findAll(PageRequest.of(0, 10))).thenReturn(cityPage);
        when(cityMapper.mapToResponse(city1)).thenReturn(cityResponse1);
        when(cityMapper.mapToResponse(city2)).thenReturn(cityResponse2);

        Page<CityResponse> result = cityService.getAllCities(PageRequest.of(0, 10));

        assertEquals(2, result.getContent().size());
        assertEquals(cityResponse1, result.getContent().get(0));
        assertEquals(cityResponse2, result.getContent().get(1));
    }

    @Test
    void getAllCities_ShouldReturnEmptyList() {
        Page<City> cityPage = new PageImpl<>(List.of());

        when(cityRepository.findAll(PageRequest.of(0, 10))).thenReturn(cityPage);

        Page<CityResponse> result = cityService.getAllCities(PageRequest.of(0, 10));

        assertEquals(0, result.getContent().size());
    }
}