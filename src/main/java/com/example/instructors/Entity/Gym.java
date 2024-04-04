package com.example.instructors.Entity;

import com.example.instructors.Entity.enums.DayOfWeek;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "gyms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @Column(name = "open_hour")
    private String openingHours;

    @Column(name = "close_hour")
    private String closingHours;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL)
    private List<User> instructors;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL)
    private List<GymReview> reviews;
}
