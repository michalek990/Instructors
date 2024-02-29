package com.example.instructors.GymPass;

import com.example.instructors.Entity.GymPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymPassRepository extends JpaRepository<GymPass, Long> {
    @Query("SELECT gp FROM GymPass gp WHERE gp.expireDate <= CURRENT_DATE")
    List<GymPass> findEndingGymPasses();
}
