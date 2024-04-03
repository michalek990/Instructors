package com.example.instructors.Gym;

import com.example.instructors.Entity.Gym;
import com.example.instructors.Gym.dto.GymInstructor;
import com.example.instructors.Gym.dto.GymRequest;
import com.example.instructors.Gym.dto.GymResponse;
import com.example.instructors.Gym.dto.JoinGymResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GymMapper {

    Gym maptoGym(GymRequest gymRequest);

    @Mapping(target = "address.cityId", source = "address.city.id")
    GymResponse mapToGymResponse(Gym gym);

    @Mapping(target = "gymName", source = "gym.name")
    @Mapping(target = "gymEmail", source = "gym.email")
    @Mapping(target = "gymPhoneNumber", source = "gym.phoneNumber")
    @Mapping(target = "instructorFirstname", source = "instructor.firstname")
    @Mapping(target = "instructorLastname", source = "instructor.lastname")
    @Mapping(target = "instructorEmail", source = "instructor.email")
    @Mapping(target = "address", source = "gym.address")
    JoinGymResponse mapToJoinGymResponse(GymInstructor gymInstructorResponse);
}
