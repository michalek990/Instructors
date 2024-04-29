package com.example.instructors.Country;

import com.example.instructors.Components.Aspect.AdminOnly;
import com.example.instructors.Country.dto.CountryRequest;
import com.example.instructors.Country.dto.CountryResponse;
import com.example.instructors.Entity.Country;
import com.example.instructors.Redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AdminOnly
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;
    private final RedisService redisService;

    @Override
    public CountryResponse createCountry(CountryRequest countryRequest) {
        Country country = countryMapper.mapToCountry(countryRequest);
        Country savedCountry = countryRepository.save(country);
        redisService.set(String.valueOf(savedCountry.getId()), savedCountry.getName());
        return countryMapper.mapToResposne(savedCountry);
    }

    @Override
    public List<CountryResponse> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(countryMapper::mapToResposne)
                .collect(Collectors.toList());
    }
}
