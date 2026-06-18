package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.PrescriptionDTO;
import com.marcoder.healthcenterapi.dto.UpdatePrescriptionDTO;
import com.marcoder.healthcenterapi.mapper.Mapper;
import com.marcoder.healthcenterapi.model.Medical_Record;
import com.marcoder.healthcenterapi.model.Prescription;
import com.marcoder.healthcenterapi.repository.MedicalRecordRepository;
import com.marcoder.healthcenterapi.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PrescriptionService implements IPrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    //GET ALL PRESCRIPTIONS
    @Override
    public List<PrescriptionDTO> getPrescriptions(){
        return prescriptionRepository.findAll().stream()
                .map(Mapper::prescriptionToDTO)
                .toList();
    }

    //GET PRESCRIPTION BY ID
    @Override
    public PrescriptionDTO getPrescriptionById(Long id){
        return Mapper.prescriptionToDTO(prescriptionRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Prescription not found with id: " + id)
        ));
    }

    //GET PRESCRIPTION BY MEDICAL RECORD ID
    @Override
    public PrescriptionDTO findByMedicalRecord_Medical_Record_Id(Long medical_record_id){
        Prescription prescription = prescriptionRepository.findByMedicalRecord_Medical_Record_Id(medical_record_id);

        if (prescription == null){
            throw new RuntimeException("Prescription not found with medical record id: " + medical_record_id);
        }

        return Mapper.prescriptionToDTO(prescription);
    }

    //SAVE PRESCRIPTION
    @Override
    public PrescriptionDTO savePrescription(PrescriptionDTO dto){
        if (dto == null){
            throw new IllegalArgumentException("Prescription cannot be null");
        }

        Medical_Record medicalRecord = medicalRecordRepository.findById(Long.valueOf(dto.getMedical_record_id())).orElseThrow(
                ()-> new RuntimeException("Medical Record not found with id: " + dto.getMedical_record_id())
        );

        Prescription prescription = Prescription.builder()
                .medication_name(dto.getMedication_name())
                .dosage(dto.getDosage())
                .frequency(dto.getFrequency())
                .duration(dto.getDuration())
                .created_at(LocalDateTime.now())
                .medical_record(medicalRecord)
                .isValid(true)
                .build();

        Prescription savedPrescription = prescriptionRepository.save(prescription);

        return Mapper.prescriptionToDTO(savedPrescription);
    }

    //UPDATE PRESCRIPTION BY ID
    @Override
    public PrescriptionDTO updatePrescription(UpdatePrescriptionDTO dto, Long id){
        if (dto == null){
            throw new IllegalArgumentException("Prescription cannot be null");
        }

        Prescription prescription = prescriptionRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Prescription not found with id: " + id)
        );

        prescription.setDuration(dto.getDuration() == null ?
                prescription.getDuration() : dto.getDuration());
        prescription.setFrequency(dto.getFrequency() == null ?
                prescription.getFrequency() : dto.getFrequency());
        prescription.setDosage(dto.getDosage() == null ?
                prescription.getDosage() : dto.getDosage());
        prescription.setMedication_name(dto.getMedication_name() == null ?
                prescription.getMedication_name() : dto.getMedication_name());

        Prescription updatedPrescription = prescriptionRepository.save(prescription);
        return Mapper.prescriptionToDTO(updatedPrescription);

    }

    //DELETE PRESCRIPTION BY ID
    @Override
    public String deletePrescription(Long id){

        Prescription prescription = prescriptionRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Prescription not found with id: " + id)
        );

        prescription.setIsValid(false);
        prescriptionRepository.save(prescription);

        return "Prescription deleted successfully";

    }

}
