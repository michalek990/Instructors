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
public class AdminOnlyAspect {

    private final UserService userService;

    @Before("@annotation(AdminOnly)")
    public void checkAdminRole(){
        UserDetails userDetails = userService.getLoggedUser();
        userService.ensureUserHasRole(userDetails, List.of("ADMIN"));
    }
}
