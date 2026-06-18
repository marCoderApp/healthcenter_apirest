package com.marcoder.healthcenterapi.service;


import com.marcoder.healthcenterapi.dto.PrescriptionDTO;
import com.marcoder.healthcenterapi.dto.UpdatePrescriptionDTO;

import java.util.List;

public interface IPrescriptionService {


    List<PrescriptionDTO> getPrescriptions();
    PrescriptionDTO getPrescriptionById(Long id);
    PrescriptionDTO savePrescription(PrescriptionDTO prescriptionDTO);
    PrescriptionDTO updatePrescription(UpdatePrescriptionDTO dto, Long id);
    PrescriptionDTO findByMedicalRecord_Medical_Record_Id(Long medical_record_id);
    String deletePrescription(Long id);

}
