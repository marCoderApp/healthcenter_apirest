package com.marcoder.healthcenterapi.repository;

import com.marcoder.healthcenterapi.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

    @Query("SELECT p FROM Prescription p WHERE p.medical_record.medical_record_id = " +
            ":medical_record_id")
    Prescription findByMedicalRecord_Medical_Record_Id(Long medical_record_id);

}
