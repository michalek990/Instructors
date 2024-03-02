package com.example.instructors.GymPass;

import com.example.instructors.Entity.GymPass;
import com.example.instructors.Entity.Instructor;
import com.example.instructors.Entity.User;
import com.example.instructors.Exception.NotFoundException;
import com.example.instructors.GymPass.dto.GymPassRequest;
import com.example.instructors.GymPass.dto.GymPassResponse;
import com.example.instructors.Instructor.InstructorRepository;
import com.example.instructors.User.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GymPassServiceImpl implements GymPassService{

    private final GymPassRepository gymPassRepository;
    private final GymPassMapper gymPassMapper;
    private final InstructorRepository instructorRepository;
    private final UserRepository userRepository;

    @Override
    public GymPassResponse createGymPass(GymPassRequest gymPassRequest) {
        GymPass gymPass = gymPassMapper.mapToGymPass(gymPassRequest);
        Instructor instructor = instructorRepository.findByEmail(gymPassRequest.getInstructorEmail())
                .orElseThrow(() -> new NotFoundException("Intructor with this email not found"));
        User user = userRepository.findByEmail(gymPassRequest.getUserEmail())
                .orElseThrow(() -> new NotFoundException("User with this email not found"));
        gymPass.setInstructor(instructor);
        gymPass.setUser(user);
        GymPass savedGymPass = gymPassRepository.save(gymPass);
        return gymPassMapper.mapToResponse(savedGymPass);
    }

    @Override
    public List<GymPassResponse> getAllGymPasess() {
        return gymPassRepository.findAll()
                .stream()
                .map(gymPassMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GymPassResponse getGymPassById(Long gymPassId) {
        GymPass gymPass = gymPassRepository.findById(gymPassId)
                .orElseThrow(() -> new NotFoundException("Gym pass not found"));
        return gymPassMapper.mapToResponse(gymPass);
    }
}
