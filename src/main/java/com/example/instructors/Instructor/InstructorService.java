package com.example.instructors.Instructor;

import com.example.instructors.Address.AddressMapper;
import com.example.instructors.City.CityRepository;
import com.example.instructors.Instructor.dto.InstructorRequest;
import com.example.instructors.Instructor.dto.InstructorResponse;
import com.example.instructors.entity.Address;
import com.example.instructors.entity.City;
import com.example.instructors.entity.Instructor;
import com.example.instructors.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;
    private final AddressMapper addressMapper;
    private final CityRepository cityRepository;

    public InstructorResponse createInstructor(InstructorRequest instructorRequest) {
        Instructor instructor = instructorMapper.mapToInstructor(instructorRequest);
        Address address = addressMapper.mapToAddress(instructorRequest.getAddress());
        City city = cityRepository.findById(instructorRequest.getAddress().getCityId())
                .orElseThrow(() -> new NotFoundException("City not found"));
        address.setCity(city);
        instructor.setAddress(address);
        address.setInstructor(instructor);
        Instructor savedInstructor = instructorRepository.save(instructor);
        return instructorMapper.mapToInstructorResponse(savedInstructor);
    }

    public InstructorResponse getInstructorById(Long instructorId){
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found"));
        return instructorMapper.mapToInstructorResponse(instructor);
    }

    public List<InstructorResponse> getAllInstructors(){
        return instructorRepository.findAll()
                .stream()
                .map(instructorMapper::mapToInstructorResponse)
                .collect(Collectors.toList());
    }

    public InstructorResponse updateInstructor(Long instructorId, InstructorRequest instructorRequest){
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found"));
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setEmail(instructorRequest.getEmail());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        Instructor savedInstructor = instructorRepository.save(instructor);

        return instructorMapper.mapToInstructorResponse(instructor);
    }

    public void deleteInstructor(Long instructorId){
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found"));
        instructorRepository.deleteById(instructorId);
    }
}
