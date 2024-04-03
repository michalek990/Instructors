package com.example.instructors.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cities")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
