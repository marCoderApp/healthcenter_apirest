package com.marcoder.healthcenterapi.repository;


import com.marcoder.healthcenterapi.model.Medical_Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicalRecordRepository extends JpaRepository<Medical_Record, Long> {

    @Query("SELECT m FROM Medical_Record m WHERE m.patient.patient_id = :patient_id")
    Medical_Record findMedical_RecordByPatient_Patient_id(@Param("patient_id") Long patient_id);

   @Query("SELECT m FROM Medical_Record m WHERE m.doctor.doctor_id = :doctor_id")
    Medical_Record findMedical_RecordByDoctor_Doctor_id(@Param("doctor_id") Long doctor_id);
}
