package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.Medical_RecordDTO;
import com.marcoder.healthcenterapi.model.Medical_Record;

import java.util.List;

public interface IMedicalRecordService {

    List<Medical_RecordDTO> getMedicalRecords();
    Medical_RecordDTO getMedicalRecordById(Long id);
    Medical_RecordDTO getMedicalRecordByPatientId(Long patient_id);
    Medical_RecordDTO getMedicalRecordByDoctorId(Long doctor_id);
    Medical_RecordDTO saveMedicalRecord(Medical_RecordDTO medicalRecord);

    Medical_RecordDTO updateMedicalRecord(Medical_RecordDTO dto,
                                          Long id);
    String deactivateMedicalRecord(Long id);

}
