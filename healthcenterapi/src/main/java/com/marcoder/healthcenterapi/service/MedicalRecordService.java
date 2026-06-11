package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.Medical_RecordDTO;
import com.marcoder.healthcenterapi.exception.NotFoundException;
import com.marcoder.healthcenterapi.mapper.Mapper;
import com.marcoder.healthcenterapi.model.Appointment;
import com.marcoder.healthcenterapi.model.Doctor;
import com.marcoder.healthcenterapi.model.Medical_Record;
import com.marcoder.healthcenterapi.model.Patient;
import com.marcoder.healthcenterapi.repository.AppointmentRepository;
import com.marcoder.healthcenterapi.repository.DoctorRepository;
import com.marcoder.healthcenterapi.repository.MedicalRecordRepository;
import com.marcoder.healthcenterapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicalRecordService implements IMedicalRecordService{

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;


    //GET ALL MEDICAL RECORDS
    @Override
    public List<Medical_RecordDTO> getMedicalRecords(){

        List<Medical_Record> medicalRecords = medicalRecordRepository.findAll();

        return medicalRecords.stream()
                .map(Mapper::medicalRecordToDTO)
                .toList();
    }

    //GET MEDICAL RECORD BY ID
    @Override
    public Medical_RecordDTO getMedicalRecordById(Long id){

        Medical_Record medicalRecord = medicalRecordRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Medical Record not found with id: " + id)
        );

        return Mapper.medicalRecordToDTO(medicalRecord);
    }

    //GET MEDICAL RECORD BY PATIENT ID
    @Override
    public Medical_RecordDTO getMedicalRecordByPatientId(Long patient_id){

        if (patient_id == null){
            throw new IllegalArgumentException("Patient id is required");
        }

        Medical_Record medicalRecord = medicalRecordRepository.findMedical_RecordByPatient_Patient_id(patient_id);

        if (medicalRecord == null){
            throw new NotFoundException("Medical record not found");
        }

        return Mapper.medicalRecordToDTO(medicalRecord);
    }

    //GET MEDICAL RECORD BY DOCTOR ID
    @Override
    public Medical_RecordDTO getMedicalRecordByDoctorId(Long doctor_id){

        if (doctor_id == null){
            throw new IllegalArgumentException("Doctor id is required");
        }

        Medical_Record medicalRecord = medicalRecordRepository.findMedical_RecordByDoctor_Doctor_id(doctor_id);


        return Mapper.medicalRecordToDTO(medicalRecord);

    }

    //SAVE MEDICAL RECORD
    @Override
    public Medical_RecordDTO saveMedicalRecord(Medical_RecordDTO medicalRecord){

        if(medicalRecord == null){
            throw new IllegalArgumentException("Medical Record cannot be null");
        }

        Doctor doctor = doctorRepository.findById(Long.valueOf(medicalRecord.getDoctor_id())).orElseThrow(
                () -> new NotFoundException("Doctor not found, check doctor id parameter.")
        );

        Patient patient = patientRepository.findById(Long.valueOf(medicalRecord.getPatient_id())).orElseThrow(
                () -> new NotFoundException("Patient not found, check patient id parameter.")
        );

        Appointment appointment = appointmentRepository.findById(Long.valueOf(medicalRecord.getAppointment_id())).orElseThrow(
                () -> new NotFoundException("Appointment not found, check appointment id parameter.")
        );

        Medical_Record newMedicalRecord = Medical_Record.builder()
                .symptoms(medicalRecord.getSymptoms())
                .diagnosis(medicalRecord.getDiagnosis())
                .treatment_notes(medicalRecord.getTreatment_notes())
                .observations(medicalRecord.getObservations())
                .createdAt(LocalDateTime.now())
                .updatedAt(null)
                .updatedBy("")
                .isActive(true)
                .doctor(doctor)
                .patient(patient)
                .appointment(appointment)
                .build();

        Medical_Record medicalRecordSaved = medicalRecordRepository.save(newMedicalRecord);

        return Mapper.medicalRecordToDTO(medicalRecordSaved);

    }

    //UPDATE MEDICAL RECORD
    @Override
    public Medical_RecordDTO updateMedicalRecord(Medical_RecordDTO dto,
                                                 Long id){

        if(dto == null || id == null){
            throw new IllegalArgumentException("Medical Record cannot be null");
        }

        Medical_Record medicalRecord = medicalRecordRepository.findById(id).orElseThrow(
                ()->new NotFoundException("Medical Record not found with id: " + id)
        );

        medicalRecord.setSymptoms(dto.getSymptoms());
        medicalRecord.setDiagnosis(dto.getDiagnosis());
        medicalRecord.setTreatment_notes(dto.getTreatment_notes());
        medicalRecord.setObservations(dto.getObservations());
        medicalRecord.setUpdatedAt(LocalDateTime.now());
        medicalRecord.setUpdatedBy(dto.getUpdatedBy());

        Medical_Record updatedMedicalRecord = medicalRecordRepository.save(medicalRecord);

        return Mapper.medicalRecordToDTO(updatedMedicalRecord);
    }

    //DELETE MEDICAL RECORD
    @Override
    public String deactivateMedicalRecord(Long id){

        if (id == null){
            throw new IllegalArgumentException("Medical Record id is required");
        }

        Medical_Record medicalRecord = medicalRecordRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Medical Record not found with id: " + id)
        );

        medicalRecord.setIsActive(false);

        medicalRecordRepository.save(medicalRecord);

        return "Medical Record deactivated successfully";
    }
}
