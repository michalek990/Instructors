package com.example.instructors.Instructor;

import com.example.instructors.Instructor.dto.InstructorRequest;
import com.example.instructors.Instructor.dto.InstructorResponse;
import com.example.instructors.Entity.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    Instructor mapToInstructor(InstructorRequest instructorRequest);

    @Mapping(source = "address.street", target = "streetName")
    @Mapping(source = "address.zipcode", target = "zipcode")
    @Mapping(source = "address.number", target = "number")
    @Mapping(source = "address.city.name", target = "cityName")
    InstructorResponse mapToResponse(Instructor instructor);
}