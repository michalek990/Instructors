package com.example.instructors.GymPass;

import com.example.instructors.GymPass.dto.GymPassRequest;
import com.example.instructors.GymPass.dto.GymPassResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gym-passess")
@AllArgsConstructor
public class GymPassController {

    private final GymPassService gymPassService;

    @PostMapping
    public ResponseEntity<GymPassResponse> createGymPass(@RequestBody GymPassRequest gymPassRequest){
        GymPassResponse response = gymPassService.createGymPass(gymPassRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GymPassResponse>> getAllGymPasses(){
        return ResponseEntity.ok(gymPassService.getAllGymPasess());
    }

    @GetMapping("/{gymPassId}")
    public ResponseEntity<GymPassResponse> getGymPassById(@PathVariable Long gymPassId){
        GymPassResponse response = gymPassService.getGymPassById(gymPassId);
        return ResponseEntity.ok(response);
    }
}
