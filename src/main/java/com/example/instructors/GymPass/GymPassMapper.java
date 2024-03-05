package com.example.instructors.GymPass;

import com.example.instructors.Entity.GymPass;
import com.example.instructors.GymPass.dto.GymPassRequest;
import com.example.instructors.GymPass.dto.GymPassResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GymPassMapper {

    GymPass mapToGymPass(GymPassRequest gymPassRequest);

    @Mapping(source = "user.email", target = "userEmail")
    @Mapping(source = "user.firstname", target = "userFirstname")
    @Mapping(source = "user.lastname", target = "userLastname")
    GymPassResponse mapToResponse(GymPass gymPass);
}
