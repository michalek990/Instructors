package com.example.instructors.GymPass;

import com.example.instructors.GymPass.dto.GymPassRequest;
import com.example.instructors.GymPass.dto.GymPassResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GymPassService {
    GymPassResponse createGymPass(GymPassRequest gymPassRequest);
    List<GymPassResponse> getAllGymPasess();
    GymPassResponse getGymPassById(Long gymPassId);
}
