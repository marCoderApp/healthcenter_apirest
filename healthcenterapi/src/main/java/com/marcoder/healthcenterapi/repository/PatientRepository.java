package com.marcoder.healthcenterapi.repository;

import com.marcoder.healthcenterapi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query("SELECT p FROM Patient p WHERE p.national_id_number = " +
            ":national_id_number")
    Patient findByNationalIdNumber(@Param("national_id_number") String national_id_number);

}

