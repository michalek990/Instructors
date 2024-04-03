package com.example.instructors.Activity;

import com.example.instructors.Activity.dto.*;
import com.example.instructors.Entity.Activity;
import com.example.instructors.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    Activity mapToActivity(ActivityRequest activityRequest);

    @Mapping(target = "instructorEmail", source = "instructor.email")
    @Mapping(target = "instructorFirstname", source = "instructor.firstname")
    @Mapping(target = "instructorLastname", source = "instructor.lastname")
    ActivityResponse mapToResponse(Activity activity);

    @Mapping(target = "activityName", source = "activity.name")
    @Mapping(target = "activityDate", source = "activity.date")
    @Mapping(target = "firstname", source = "participant.firstname")
    @Mapping(target = "lastname", source = "participant.lastname")
    @Mapping(target = "email", source = "participant.email")
    @Mapping(target = "id", source = "participant.id")
    AddParticipantResponse mapToAddParticipantResponse(ActivityParticipant activityParticipant);


    @Mapping(target = "firstname", source = "firstname")
    @Mapping(target = "lastname", source = "lastname")
    @Mapping(target = "email", source = "email")
    ParticipantsOfActivityResponse mapToParticipantsOfActivityResponse(User participant);
}
