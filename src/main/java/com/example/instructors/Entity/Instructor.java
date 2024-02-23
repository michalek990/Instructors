package com.example.instructors.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="instructors")
@Getter
@Setter
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "phoneNumber")
    @Pattern(regexp = "^(\\d{3}-){2}\\d{4}$", message = "Invalid phone number format")
    private String phoneNumber;

    @OneToOne(mappedBy = "instructor", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;
}
