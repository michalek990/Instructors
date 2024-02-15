package com.example.instructors.Instructor;

import com.example.instructors.Instructor.dto.InstructorRequest;
import com.example.instructors.Instructor.dto.InstructorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<InstructorResponse> createInstructor(@RequestBody InstructorRequest instructorRequest) {
        InstructorResponse response = instructorService.createInstructor(instructorRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorResponse> getInstructorById(@PathVariable @Valid Long id){
        InstructorResponse instructor = instructorService.getInstructorById(id);
        return ResponseEntity.ok(instructor);
    }

    @GetMapping("/all")
    public ResponseEntity<List<InstructorResponse>> getAllInstructors(){
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorResponse> updateInstructor(@PathVariable Long id, @RequestBody InstructorRequest instructorRequest){
        InstructorResponse instructor = instructorService.updateInstructor(id, instructorRequest);
        return ResponseEntity.ok(instructor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id){
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }
}
