package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.PatientDTO;

import java.util.List;

public interface IPatientService{

    List<PatientDTO> getPatients();
    PatientDTO getPatientById(Long id);
    PatientDTO getPatientByNationalIdNumber(String national_id_number);
    PatientDTO savePatient(PatientDTO patientDTO);
    String updatePatient(PatientDTO patientDTO, Long id);
    String deletePatient(Long id);

}
