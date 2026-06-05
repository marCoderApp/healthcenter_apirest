package com.marcoder.healthcenterapi.repository;

import com.marcoder.healthcenterapi.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    //GET ALL APPOINTMENTS BY PATIENT ID
    @Query("SELECT a FROM Appointment a WHERE a.patient.patient_id = :patient_id")
    List<Appointment> getAppointmentsByPatientId(@Param("patient_id") Long patient_id);

    //GET ALL APPOINTMENTS BY DOCTOR ID
    @Query("SELECT a FROM Appointment a WHERE a.doctor.doctor_id = :doctor_id")
    List<Appointment> getAppointmentsByDoctorId(@Param("doctor_id") Long doctor_id);

    //GET ALL APPOINTMENTS BY CONSULTING ROOM ID
    @Query("SELECT a FROM Appointment a WHERE a.consulting_room.consulting_room_id = :consulting_room_id")
    List<Appointment> getAppointmentsByConsultingRoomId(@Param("consulting_room_id") Long consulting_room_id);

    //GET ALL APPOINTMENTS BY DATE
    @Query("SELECT a FROM Appointment a WHERE a.date = :date")
    List<Appointment> getAppointmentsByDate(@Param("date") String date);

    //GET ALL APPOINTMENTS BY STATUS
    @Query()
}
