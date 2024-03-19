package com.example.instructors.User;

import com.example.instructors.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    User findByVerificationCode(String verificationCode);

    Optional<User> findByLastnameAndFirstname(String lastname, String firstname);
}
