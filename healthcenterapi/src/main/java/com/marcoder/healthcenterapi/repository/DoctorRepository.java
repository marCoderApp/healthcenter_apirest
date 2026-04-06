package com.marcoder.healthcenterapi.repository;

import com.marcoder.healthcenterapi.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    @Override
    Optional<Doctor> findById(Long id);

}
