package com.example.instructors.Gym;

import com.example.instructors.Gym.dto.GymRequest;
import com.example.instructors.Gym.dto.GymResponse;
import com.example.instructors.Gym.dto.JoinGymResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GymService {
    GymResponse createGym(GymRequest gymRequest);
    GymResponse getGym(Long gymId);
    Page<GymResponse> getAllGyms(Pageable pageable);
    List<GymResponse> getAllGymsByCity(Long cityId);
    JoinGymResponse joinGym(Long gymId);
    GymResponse updateGym(Long gymId, GymRequest gymRequest);
    void deleteGym(Long gymId);
}
