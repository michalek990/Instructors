package com.example.instructors.Country;

import com.example.instructors.Country.dto.CountryRequest;
import com.example.instructors.Country.dto.CountryResponse;

public interface CountryService {

    CountryResponse createCountry(CountryRequest countryRequest);
}
