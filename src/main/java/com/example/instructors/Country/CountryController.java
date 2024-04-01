package com.example.instructors.Country;

import com.example.instructors.Country.dto.CountryRequest;
import com.example.instructors.Country.dto.CountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/countries")
@CrossOrigin(origins = "http://localhost:3000")
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryResponse> createCountry(@RequestBody CountryRequest countryRequest){
        CountryResponse response = countryService.createCountry(countryRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CountryResponse>> getAllCountries(){
        return ResponseEntity.ok(countryService.getAllCountries());
    }
}
