package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.PatientDTO;
import com.marcoder.healthcenterapi.enums.BloodType;
import com.marcoder.healthcenterapi.mapper.Mapper;
import com.marcoder.healthcenterapi.model.Patient;
import com.marcoder.healthcenterapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService{

    @Autowired
    PatientRepository patientRepository;

    //GET PATIENTS
    @Override
    public List<PatientDTO> getPatients(){
        return patientRepository.findAll()
                .stream().map(Mapper::patientToDTO)
                .toList();
    }

    //GET PATIENT BY ID
    @Override
    public PatientDTO getPatientById(Long id){
        return Mapper.patientToDTO(patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id)));
    }

    //GET PATIENT BY NATIONAL ID NUMBER
    @Override
    public PatientDTO getPatientByNationalIdNumber(String national_id_number){
        return Mapper.patientToDTO(patientRepository.findByNationalIdNumber(national_id_number));
    }

    //SAVE PATIENT
    @Override
    public PatientDTO savePatient(PatientDTO patientDTO){
        if (patientDTO.getPatient_id() == null){
            throw new IllegalArgumentException("Patient id is required");
        }

        Patient patient = patientRepository.findByNationalIdNumber(patientDTO.getNational_id_number());

        if (patient != null){
            throw new IllegalArgumentException("Patient already exists");
        }

        Patient newPatient = Patient.builder()
                .name(patientDTO.getName())
                .lastname(patientDTO.getLastname())
                .national_id_number(patientDTO.getNational_id_number())
                .email(patientDTO.getEmail())
                .phone(patientDTO.getPhone())
                .address(patientDTO.getAddress())
                .gender(patientDTO.getGender())
                .blood_type(BloodType.valueOf(String.valueOf(patientDTO.getBlood_type())))
                .born_date(patientDTO.getBorn_date())
                .build();

        Patient savedPatient = patientRepository.save(newPatient);
        return Mapper.patientToDTO(savedPatient);

    }

    //UPDATE PATIENT BY ID
    @Override
    public String updatePatient(PatientDTO patientDTO, Long id){
        if (patientDTO == null){
            return "Wrong input!";
        }

        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Patient not found with id: " + id)
        );

        patient.setName(patientDTO.getName());
        patient.setLastname(patientDTO.getLastname());
        patient.setNational_id_number(patientDTO.getNational_id_number());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhone(patientDTO.getPhone());
        patient.setAddress(patientDTO.getAddress());
        patient.setGender(patientDTO.getGender());
        patient.setBlood_type(BloodType.valueOf(String.valueOf(patientDTO.getBlood_type())));
        patient.setBorn_date(patientDTO.getBorn_date());

        patientRepository.save(patient);
        return "Patient updated successfully";
    }

    //DELETE PATIENT BY ID
    @Override
    public String deletePatient(Long id){
        patientRepository.deleteById(id);
        return "Patient deleted successfully";
    }


}

