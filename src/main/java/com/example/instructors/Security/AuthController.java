package com.example.instructors.Security;

import com.example.instructors.Security.dto.JwtAuthenticationResponse;
import com.example.instructors.Security.dto.LoginRequest;
import com.example.instructors.User.UserService;
import com.example.instructors.User.dto.UserRequest;
import com.example.instructors.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public AuthController(CustomUserDetailsService customUserDetailsService, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/login")  
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        User user = userService.registerNewUserAccount(userRequest);
        return ResponseEntity.ok("User registered successfully");
    }
}