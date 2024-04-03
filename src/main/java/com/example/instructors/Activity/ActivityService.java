package com.example.instructors.Activity;

import com.example.instructors.Activity.dto.ActivityRequest;
import com.example.instructors.Activity.dto.ActivityResponse;
import com.example.instructors.Activity.dto.AddParticipantResponse;
import com.example.instructors.Activity.dto.ParticipantsOfActivityResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface ActivityService {
    ActivityResponse createActivity(ActivityRequest activityRequest);
    AddParticipantResponse addParticipant(Long id, Long participantId);
    AddParticipantResponse attendActivity(Long id);
    ActivityResponse getActivity(Long id);
    Page<ActivityResponse> getAllActivities(Pageable pageable);
    Set<ParticipantsOfActivityResponse> getParticipantsOfActivity(Pageable pageable, Long id);
    ActivityResponse updateActivity(Long id, ActivityRequest activityRequest);
    void deleteActivity(Long id);
}
