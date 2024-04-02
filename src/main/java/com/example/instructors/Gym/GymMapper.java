package com.example.instructors.Gym;

import com.example.instructors.Entity.Gym;
import com.example.instructors.Gym.dto.GymRequest;
import com.example.instructors.Gym.dto.GymResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GymMapper {

    Gym maptoGym(GymRequest gymRequest);

    GymResponse mapToGymResponse(Gym gym);
}
