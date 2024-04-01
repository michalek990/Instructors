package com.example.instructors.Components.Aspect;

import com.example.instructors.User.UserService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@RequiredArgsConstructor
public class InstructorOnlyAspect {

    private final UserService userService;

    @Before("within(@InstructorOnly *)")
    public void checkInstructorRole(){
        UserDetails userDetails = userService.getLoggedUser();
        userService.ensureUserHasRole(userDetails, List.of("ADMIN", "INSTRUCTOR"));
    }
}
