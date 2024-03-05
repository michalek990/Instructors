package com.example.instructors.City;

import com.example.instructors.City.dto.CityRequest;
import com.example.instructors.City.dto.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<CityResponse> createCity(@RequestBody CityRequest cityRequest){
        CityResponse response = cityService.createCity(cityRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<CityResponse>> getAllCities(Pageable pageable){
        return ResponseEntity.ok(cityService.getAllCities(pageable));
    }
}
