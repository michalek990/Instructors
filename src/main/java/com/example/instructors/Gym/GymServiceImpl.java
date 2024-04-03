package com.example.instructors.Gym;

import com.example.instructors.Address.AddressMapper;
import com.example.instructors.Address.AddressRepository;
import com.example.instructors.City.CityRepository;
import com.example.instructors.Components.Aspect.InstructorOnly;
import com.example.instructors.Entity.Address;
import com.example.instructors.Entity.City;
import com.example.instructors.Entity.Gym;
import com.example.instructors.Entity.User;
import com.example.instructors.Exception.NotFoundException;
import com.example.instructors.Gym.dto.GymInstructor;
import com.example.instructors.Gym.dto.GymRequest;
import com.example.instructors.Gym.dto.GymResponse;
import com.example.instructors.Gym.dto.JoinGymResponse;
import com.example.instructors.User.UserRepository;
import com.example.instructors.User.UserService;
import com.zaxxer.hikari.util.SuspendResumeLock;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {

    private final GymRepository gymRepository;
    private final GymMapper gymMapper;
    private final AddressMapper addressMapper;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public GymResponse createGym(GymRequest gymRequest) {
        Address address = addressMapper.mapToAddress(gymRequest.getAddress());
        City city = cityRepository.findByName(gymRequest.getAddress().getCityName())
                .orElseThrow(() -> new NotFoundException("City not found"));

        Gym gym = gymMapper.maptoGym(gymRequest);

        address.setCity(city);
        gym.setAddress(address);

        addressRepository.save(address);
        gymRepository.save(gym);
        return gymMapper.mapToGymResponse(gym);
    }

    @Override
    public GymResponse getGym(Long gymId) {
        return gymRepository.findById(gymId)
                .map(gymMapper::mapToGymResponse)
                .orElseThrow(() -> new NotFoundException("Gym not found"));
    }

    @Override
    public Page<GymResponse> getAllGyms(Pageable pageable) {
        return gymRepository.findAll(pageable)
                .map(gymMapper::mapToGymResponse);
    }

    @Override
    public List<GymResponse> getAllGymsByCity(Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new NotFoundException("City not found"));
        return gymRepository.findAllByAddress_City(city).stream()
                .map(gymMapper::mapToGymResponse)
                .collect(Collectors.toList());
    }

    @Override
    public JoinGymResponse joinGym(Long gymId) {
        Gym gym = gymRepository.findById(gymId)
                .orElseThrow(() -> new NotFoundException("Gym not found"));
        User instructor = (User) userService.getLoggedUser();

        instructor.setGym(gym);
        GymInstructor gymInstructor = new GymInstructor(gym, instructor);

        userRepository.save(instructor);
        return gymMapper.mapToJoinGymResponse(gymInstructor);
    }

    @Override
    public GymResponse updateGym(Long gymId, GymRequest gymRequest) {
        Gym gymToUpdate = gymRepository.findById(gymId)
                .orElseThrow(() -> new NotFoundException("Gym not found"));
        Address address = addressMapper.mapToAddress(gymRequest.getAddress());
        City city = cityRepository.findByName(gymRequest.getAddress().getCityName())
                .orElseThrow(() -> new NotFoundException("City not found"));

        gymToUpdate.setName(gymRequest.getName());
        gymToUpdate.setEmail(gymRequest.getEmail());
        gymToUpdate.setPhoneNumber(gymRequest.getPhoneNumber());
        gymToUpdate.setDayOfWeek(gymRequest.getDayOfWeek());
        gymToUpdate.setOpeningHours(gymRequest.getOpeningHours());
        gymToUpdate.setClosingHours(gymRequest.getClosingHours());

        address.setCity(city);
        gymToUpdate.setAddress(address);

        addressRepository.save(address);
        gymRepository.save(gymToUpdate);
        return gymMapper.mapToGymResponse(gymToUpdate);
    }

    @Override
    public void deleteGym(Long gymId) {
        Gym gymToDelete = gymRepository.findById(gymId)
                .orElseThrow(() -> new NotFoundException("Gym not found"));
        gymRepository.delete(gymToDelete);
    }
}
