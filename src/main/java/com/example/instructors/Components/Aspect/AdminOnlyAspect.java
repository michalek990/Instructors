package com.example.instructors.Components.Aspect;

import com.example.instructors.Entity.User;
import com.example.instructors.Entity.enums.Role;
import com.example.instructors.Exception.ForbiddenException;
import com.example.instructors.Exception.NotFoundException;
import com.example.instructors.Exception.UnauthorizedException;
import com.example.instructors.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class AdminOnlyAspect {

    private final UserRepository userRepository;

    @Before("@annotation(AdminOnly)")
    public void checkAdminRole(JoinPoint joinPoint){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UnauthorizedException("User is not logged in");
        }

        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        if (user.getRoles() != Role.ADMIN){
            throw new ForbiddenException("User not perform to do this");
        }
    }
}
