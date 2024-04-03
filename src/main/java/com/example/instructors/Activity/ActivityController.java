package com.example.instructors.Activity;

import com.example.instructors.Activity.dto.ActivityRequest;
import com.example.instructors.Activity.dto.ActivityResponse;
import com.example.instructors.Activity.dto.AddParticipantResponse;
import com.example.instructors.Activity.dto.ParticipantsOfActivityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/activity")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> createActivity(@RequestBody ActivityRequest activityRequest) {
        ActivityResponse response = activityService.createActivity(activityRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityResponse> getActivity(@PathVariable Long activityId) {
        ActivityResponse response = activityService.getActivity(activityId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ActivityResponse>> getAllActivities(Pageable pageable) {
        Page<ActivityResponse> response = activityService.getAllActivities(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/participants/{activityId}")
    public ResponseEntity<Set<ParticipantsOfActivityResponse>> getParticipantsOfActivity(Pageable pageable, @PathVariable Long activityId) {
        Set<ParticipantsOfActivityResponse> response = activityService.getParticipantsOfActivity(pageable, activityId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/addParticipant/{activityId}/{participantId}")
    public ResponseEntity<AddParticipantResponse> addParticipant(@PathVariable Long activityId, @PathVariable Long participantId) {
        AddParticipantResponse response = activityService.addParticipant(activityId, participantId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/attendActivity/{activityId}")
    public ResponseEntity<AddParticipantResponse> attendActivity(@PathVariable Long activityId) {
        AddParticipantResponse response = activityService.attendActivity(activityId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{activityId}")
    public ResponseEntity<ActivityResponse> updateActivity(@PathVariable Long activityId, @RequestBody ActivityRequest activityRequest) {
        ActivityResponse response = activityService.updateActivity(activityId, activityRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long activityId) {
        activityService.deleteActivity(activityId);
        return ResponseEntity.noContent().build();
    }
}
