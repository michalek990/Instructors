package com.example.instructors.Country;

import com.example.instructors.Country.dto.CountryRequest;
import com.example.instructors.Country.dto.CountryResponse;
import com.example.instructors.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;

    @Override
    public CountryResponse createCountry(CountryRequest countryRequest) {
        Country country = countryMapper.mapToCountry(countryRequest);
        Country savedCountry = countryRepository.save(country);
        return countryMapper.mapToResposne(savedCountry);
    }
}
