package com.marcoder.healthcenterapi.controller;


import com.marcoder.healthcenterapi.dto.PatientDTO;
import com.marcoder.healthcenterapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    //GET PATIENTS
    @GetMapping("/all")
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        return ResponseEntity.ok(patientService.getPatients());
    }

    //GET PATIENT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    //GET PATIENT BY NATIONAL ID NUMBER
    @GetMapping("/national_id/{national_id}")
    public ResponseEntity<PatientDTO> getPatientByNationalIdNumber(@PathVariable String national_id){
        return ResponseEntity.ok(patientService.getPatientByNationalIdNumber(national_id));
    }

    //SAVE PATIENT
    @PostMapping("/save")
    public ResponseEntity<PatientDTO> savePatient(@RequestBody PatientDTO patientDTO){
        return ResponseEntity.ok(patientService.savePatient(patientDTO));
    }

    //UPDATE PATIENT BY ID
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updatePatientById(@RequestBody PatientDTO patientDTO, @PathVariable Long id){
        return ResponseEntity.ok(patientService.updatePatient(patientDTO, id));
    }

    //DELETE PATIENT BY ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
        return ResponseEntity.ok(patientService.deletePatient(id));
    }

}
