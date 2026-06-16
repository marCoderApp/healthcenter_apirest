package com.marcoder.healthcenterapi.controller;

import com.marcoder.healthcenterapi.dto.Medical_RecordDTO;
import com.marcoder.healthcenterapi.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical_records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    //GET ALL MEDICAL RECORDS
    @GetMapping("/all")
    public List<Medical_RecordDTO> getAllMedicalRecords(){
        List<Medical_RecordDTO> medicalRecords = medicalRecordService.getMedicalRecords();

        return medicalRecords;
    }

    //GET MEDICAL RECORD BY ID
    @GetMapping("/{id}")
    public Medical_RecordDTO getMedicalRecordById(@PathVariable Long id){
        return medicalRecordService.getMedicalRecordById(id);
    }

    //GET MEDICAL RECORD BY PATIENT ID
    @GetMapping("/by_patient_id/{patient_id}")
    public Medical_RecordDTO getMedicalRecordByPatientId(@PathVariable Long patient_id){
        return medicalRecordService.getMedicalRecordByPatientId(patient_id);
    }

    //GET MEDICAL RECORD BY DOCTOR ID
    @GetMapping("/by_doctor_id/{doctor_id}")
    public Medical_RecordDTO getMedicalRecordByDoctorId(@PathVariable Long doctor_id){
        return medicalRecordService.getMedicalRecordByDoctorId(doctor_id);
    }

    //SAVE MEDICAL RECORD
    @PostMapping("/save")
    public Medical_RecordDTO saveMedicalRecord(@RequestBody Medical_RecordDTO medicalRecord){
        return medicalRecordService.saveMedicalRecord(medicalRecord);
    }

    //UPDATE MEDICAL RECORD
    @PatchMapping("/update_medical_record/{id}")
    public Medical_RecordDTO updateMedicalRecord(@RequestBody Medical_RecordDTO medicalRecord,
                                                 @PathVariable Long id){
        return medicalRecordService.updateMedicalRecord(medicalRecord, id);
    }

    //DELETE MEDICAL RECORD
    @PatchMapping("/deactivate/{id}")
    public String deactivateMedicalRecord(@PathVariable Long id){
        return medicalRecordService.deactivateMedicalRecord(id);
    }

}
