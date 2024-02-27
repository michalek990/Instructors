package com.example.instructors.Country;

import com.example.instructors.Country.dto.CountryRequest;
import com.example.instructors.Country.dto.CountryResponse;

import java.util.List;

public interface CountryService {

    CountryResponse createCountry(CountryRequest countryRequest);
    List<CountryResponse> getAllCountries();
}
