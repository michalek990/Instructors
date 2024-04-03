package com.example.instructors.Activity;

import com.example.instructors.Activity.dto.ActivityParticipant;
import com.example.instructors.Activity.dto.ActivityRequest;
import com.example.instructors.Activity.dto.ActivityResponse;
import com.example.instructors.Activity.dto.AddParticipantResponse;
import com.example.instructors.Activity.dto.ParticipantsOfActivityResponse;
import com.example.instructors.Entity.Activity;
import com.example.instructors.Entity.User;
import com.example.instructors.Exception.NotFoundException;
import com.example.instructors.User.UserRepository;
import com.example.instructors.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public ActivityResponse createActivity(ActivityRequest activityRequest) {
        UserDetails loggedInstructor = userService.getLoggedUser();
        Activity activity = activityMapper.mapToActivity(activityRequest);
        activity.setInstructor((User) loggedInstructor);

        activityRepository.save(activity);
        return activityMapper.mapToResponse(activity);
    }

    @Override
    public AddParticipantResponse addParticipant(Long activityId, Long participantId) {
        User participant = userRepository.findById(participantId)
                .orElseThrow(() -> new NotFoundException("User not found"));
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new NotFoundException("Activity not found"));

        if(activity.getNumberOfParticipants() == activity.getParticipants().size()) {
            throw new RuntimeException("Activity is full");
        }

        activity.getParticipants().add(participant);
        activityRepository.save(activity);
        ActivityParticipant activityParticipant = new ActivityParticipant(activity, participant);

        return activityMapper.mapToAddParticipantResponse(activityParticipant);
    }

    @Override
    public AddParticipantResponse attendActivity(Long activityId) {
        User loggedUser = (User) userService.getLoggedUser();
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new NotFoundException("Activity not found"));

        if(activity.getNumberOfParticipants() == activity.getParticipants().size()){
            throw new RuntimeException("Activity is full");
        }
        activity.getParticipants().add(loggedUser);
        activityRepository.save(activity);
        ActivityParticipant activityParticipant = new ActivityParticipant(activity, loggedUser);

        return activityMapper.mapToAddParticipantResponse(activityParticipant);
    }

    @Override
    public ActivityResponse getActivity(Long activityId) {
        return activityRepository.findById(activityId)
                .map(activityMapper::mapToResponse)
                .orElseThrow(() -> new NotFoundException("Activity not found"));
    }

    @Override
    public Page<ActivityResponse> getAllActivities(Pageable pageable) {
        return activityRepository.findAll(pageable)
                .map(activityMapper::mapToResponse);
    }

    @Override
    public Set<ParticipantsOfActivityResponse> getParticipantsOfActivity(Pageable pageable, Long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found!"));

        return activity.getParticipants().stream()
                .map(activityMapper::mapToParticipantsOfActivityResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public ActivityResponse updateActivity(Long activityId, ActivityRequest activityRequest) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new NotFoundException("Activity not found"));
        activity.setName(activityRequest.getName());
        activity.setDescription(activityRequest.getDescription());
        activity.setDate(activityRequest.getDate());
        activity.setNumberOfParticipants(activityRequest.getNumberOfParticipants());
        activityRepository.save(activity);

        return activityMapper.mapToResponse(activity);
    }

    @Override
    public void deleteActivity(Long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new NotFoundException("Activity not found"));
        activityRepository.delete(activity);
    }
}
