package com.marcoder.healthcenterapi.controller;

import com.marcoder.healthcenterapi.dto.PrescriptionDTO;
import com.marcoder.healthcenterapi.dto.UpdateAppointmentDTO;
import com.marcoder.healthcenterapi.dto.UpdatePrescriptionDTO;
import com.marcoder.healthcenterapi.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    //GET ALL PRESCRIPTIONS
    @GetMapping("/all")
    public ResponseEntity<List<PrescriptionDTO>> getAllPrescriptions(){
        return ResponseEntity.ok(prescriptionService.getPrescriptions());
    }

    //GET PRESCRIPTION BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDTO> getPrescriptionById(@PathVariable Long id){
        return ResponseEntity.ok(prescriptionService.getPrescriptionById(id));
    }

    //GET PRESCRIPTION BY MEDICAL RECORD ID
    @GetMapping("/by_medical_record_id/{id}")
    public ResponseEntity<PrescriptionDTO> getPrescriptionByMedicalRecordId(@PathVariable Long id){
        return ResponseEntity.ok(prescriptionService.findByMedicalRecord_Medical_Record_Id(id));
    }

    //SAVE PRESCRIPTION
    @PostMapping("/save")
    public ResponseEntity<PrescriptionDTO> savePrescription(@RequestBody PrescriptionDTO prescriptionDTO){
        return ResponseEntity.ok(prescriptionService.savePrescription(prescriptionDTO));
    }

    //UPDATE PRESCRIPTION BY ID
    @PatchMapping("/update/{id}")
    public ResponseEntity<PrescriptionDTO> updatePrescription(
            @RequestBody UpdatePrescriptionDTO dto, @PathVariable Long id){
        return ResponseEntity.ok(prescriptionService.updatePrescription(dto, id));
    }

    //DELETE PRESCRIPTION BY ID
    @PatchMapping("/delete/{id}")
    public ResponseEntity<String> deletePrescription(@PathVariable Long id){
        return ResponseEntity.ok(prescriptionService.deletePrescription(id));
    }


}
