package com.example.instructors.Gym;

import com.example.instructors.Gym.dto.GymRequest;
import com.example.instructors.Gym.dto.GymResponse;
import com.example.instructors.Gym.dto.JoinGymResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Join;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gym")
public class GymController {

    private final GymService gymService;

    @PostMapping
    public ResponseEntity<GymResponse> createGym(@RequestBody GymRequest gymRequest) {
        return new ResponseEntity<>(gymService.createGym(gymRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{gymId}")
    public ResponseEntity<GymResponse> getGym(@PathVariable Long gymId) {
        return ResponseEntity.ok(gymService.getGym(gymId));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<GymResponse>> getGyms(Pageable pageable) {
        return ResponseEntity.ok(gymService.getAllGyms(pageable));
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<GymResponse>> getAllGymsByCity(@PathVariable Long cityId) {
        return ResponseEntity.ok(gymService.getAllGymsByCity(cityId));
    }

    @PutMapping("/join/{gymId}")
    public ResponseEntity<JoinGymResponse> joinGym(@PathVariable Long gymId) {
        JoinGymResponse response = gymService.joinGym(gymId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{gymId}")
    public ResponseEntity<GymResponse> updateGym(@PathVariable Long gymId, @RequestBody GymRequest gymRequest) {
        return ResponseEntity.ok(gymService.updateGym(gymId, gymRequest));
    }

    @DeleteMapping("/{gymId}")
    public ResponseEntity<Void> deleteGym(@PathVariable Long gymId) {
        gymService.deleteGym(gymId);
        return ResponseEntity.noContent().build();
    }
}
