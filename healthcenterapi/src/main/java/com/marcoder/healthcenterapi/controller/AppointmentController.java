package com.marcoder.healthcenterapi.controller;

import com.marcoder.healthcenterapi.dto.AppointmentDTO;
import com.marcoder.healthcenterapi.dto.UpdateAppointmentDTO;
import com.marcoder.healthcenterapi.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    //GET ALL APPOINTMENTS
    @GetMapping("/all")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(appointmentService.getAllAppointments());
    }

    //GET APPOINTMENTS BY ID
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(appointmentService.getAppointmentById(id));
    }

    //SAVE APPOINTMENT
    @PostMapping("/save")
    public ResponseEntity<AppointmentDTO> saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appointmentService.saveAppointment(appointmentDTO));
    }

    //UPDATE APPOINTMENT BY ID
    @PatchMapping("/update/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Long id,
                                                            @RequestBody UpdateAppointmentDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(appointmentService.updateAppointment(id, dto));
    }

    //GET APPOINTMENTS BY DATE
    @GetMapping("/get_by_date/{date}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByDate(@PathVariable String date){
        return ResponseEntity.status(HttpStatus.OK)
                .body(appointmentService.getAppointmentsByDate(date));
    }

    //GET APPOINTMENTS BY STATUS
    @GetMapping("/get_by_status/{status}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByStatus(@PathVariable String status){
        return ResponseEntity.status(HttpStatus.OK)
                .body(appointmentService.getAppointmentsByStatus(status));
    }

    //DELETE APPOINTMENT BY ID (change to soft delete)
    @DeleteMapping("/delete/{id}/{updatedBy}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id,
                                                    @PathVariable String updatedBy){
        return ResponseEntity.ok(appointmentService.deleteAppointment(id,updatedBy ));
    }

    //GET APPOINTMENTS BY DOCTOR ID
    @GetMapping("/get_by_doctor/{doctorId}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByDoctorId(@PathVariable Long doctorId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(appointmentService.getAppointmentsByDoctorId(doctorId));
    }

    //GET APPOINTMENTS BY PATIENT ID
    @GetMapping("/get_by_patient/{patientId}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByPatientId(@PathVariable Long patientId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(appointmentService.getAppointmentsByPatientId(patientId));
    }

    //GET APPOINTMENTS BY CONSULTING ROOM ID
    @GetMapping("/get_by_consulting_room/{consultingRoomId}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByConsultingRoomId(@PathVariable Long consultingRoomId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(appointmentService.getAppointmentsByConsultingRoomId(consultingRoomId));
    }


}
