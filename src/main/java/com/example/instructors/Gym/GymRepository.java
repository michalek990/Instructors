package com.example.instructors.Gym;

import com.example.instructors.Entity.City;
import com.example.instructors.Entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GymRepository extends JpaRepository<Gym, Long> {
    List<Gym> findAllByAddress_City(City addressCity);
}
