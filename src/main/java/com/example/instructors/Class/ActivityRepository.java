package com.example.instructors.Class;

import com.example.instructors.Entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
