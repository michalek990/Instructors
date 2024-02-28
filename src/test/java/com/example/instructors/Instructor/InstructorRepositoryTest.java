package com.example.instructors.Instructor;

import com.example.instructors.Entity.Instructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class InstructorRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.1");

    InstructorRepository instructorRepository;

    @Autowired
    public InstructorRepositoryTest(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Test
    void connectionEstablished() {
        assertThat(postgres.isCreated()).isTrue();
        assertThat(postgres.isRunning()).isTrue();
    }

    @BeforeEach
    void setUp() {
        Instructor instructor = new Instructor();
        instructor.setFirstName("Laszlo");
        Instructor instructor1 = new Instructor();
        instructor1.setFirstName("Istvan");
        instructorRepository.saveAll(List.of(instructor,instructor1));
    }

    @Test
    void shouldReturnPostByTitle() {
        Instructor instructor = instructorRepository.findById(1L).orElseThrow();
        assertEquals("Laszlo", instructor.getFirstName(), "First name should be 'Laszlo'");
    }

}