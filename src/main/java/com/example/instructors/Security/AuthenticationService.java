package com.example.instructors.Security;

import com.example.instructors.Config.EmailService;
import com.example.instructors.Entity.User;
import com.example.instructors.Entity.enums.Role;
import com.example.instructors.Security.dto.AuthenticationRequest;
import com.example.instructors.Security.dto.AuthenticationResponse;
import com.example.instructors.Security.dto.RegisterRequest;
import com.example.instructors.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthenticationResponse register(RegisterRequest request) {
        String verificationCode = UUID.randomUUID().toString();

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .email(request.getEmail())
                .verificationCode(verificationCode)
                .active(false)
                .roles(Role.USER)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        String subject = "Potwierdzenie rejestracji";
        String content = "Kod weryfikacyjny do potwierdzenia konta: " + verificationCode;
        //emailService.sendVerificationEmail(user.getEmail(), subject, content);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .isActive(false)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public boolean verify(String verificationCode) {
        User user = userRepository.findByVerificationCode(verificationCode);
        if (user.isActive()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setActive(true);
            userRepository.save(user);
            return true;
        }
    }

}

