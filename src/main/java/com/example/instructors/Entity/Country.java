package com.example.instructors.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "countries")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> Cities;
}
