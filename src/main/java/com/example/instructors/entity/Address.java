package com.example.instructors.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "zipcode")
    private String zipcode;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}
