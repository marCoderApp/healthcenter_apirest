package com.marcoder.healthcenterapi.controller;

import com.marcoder.healthcenterapi.dto.DoctorDTO;
import com.marcoder.healthcenterapi.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    //GET ALL DOCTORS
    @GetMapping("/all")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.getDoctors());
    }

    //GET DOCTOR BY ID
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    //GET DOCTOR BY SPECIALLTY ID
    @GetMapping("/speciallty/{id}")
    public ResponseEntity<List<DoctorDTO>> getDoctorBySpecialltyId(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getDoctorsBySpecialtyId(id));
    }

    //GET DOCTOR BY CONSULTING ROOM ID
    @GetMapping("/consulting_room/{id}")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByConsulting_RoomId(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getDoctorsByConsulting_RoomId(id));
    }

    //GET DOCTOR BY NATIONAL ID
    @GetMapping("/national_id/{national_id}")
    public ResponseEntity<DoctorDTO> getDoctorByNationalIdNumber(@PathVariable String national_id){
        return ResponseEntity.ok(doctorService.getDoctorByNationalIdNumber(national_id));
    }

    //GET DOCTOR BY EMAIL
    @GetMapping("/email/{email}")
    public ResponseEntity<DoctorDTO> getDoctorByEmail(@PathVariable String email){
        return ResponseEntity.ok(doctorService.getDoctorByEmail(email));
    }

    //SAVE DOCTOR
    @PostMapping("/save")
    public ResponseEntity<DoctorDTO> saveDoctor(@RequestBody DoctorDTO doctorDTO){
        return ResponseEntity.ok(doctorService.saveDoctor(doctorDTO));
    }

    //UPDATE DOCTOR BY ID
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateDoctorById(@RequestBody DoctorDTO doctorDTO, @PathVariable Long id){
        return ResponseEntity.ok(doctorService.updateDoctor(doctorDTO, id));
    }

    //DELETE DOCTOR BY ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.deleteDoctor(id));
    }

}
