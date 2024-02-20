package com.example.instructors.Country;

import com.example.instructors.Country.dto.CountryRequest;
import com.example.instructors.Country.dto.CountryResponse;
import com.example.instructors.entity.Country;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;
    public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository) {
        this.countryMapper = countryMapper;
        this.countryRepository = countryRepository;
    }


    @Override
    public CountryResponse createCountry(CountryRequest countryRequest) {
        Country country = countryMapper.mapToCountry(countryRequest);
        Country savedCountry = countryRepository.save(country);
        return countryMapper.mapToResposne(savedCountry);
    }
}
