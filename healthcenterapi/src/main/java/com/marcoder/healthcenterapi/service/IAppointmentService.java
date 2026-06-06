package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.AppointmentDTO;
import com.marcoder.healthcenterapi.dto.UpdateAppointmentDTO;

import java.util.List;

public interface IAppointmentService {

List<AppointmentDTO> getAllAppointments();
List<AppointmentDTO> getAppointmentsByPatientId(Long patient_id);
List<AppointmentDTO> getAppointmentsByDoctorId(Long doctor_id);
List<AppointmentDTO> getAppointmentsByConsultingRoomId(Long consulting_room_id);
List<AppointmentDTO> getAppointmentsByDate(String date);
AppointmentDTO getAppointmentById(Long id);
List<AppointmentDTO> getAppointmentsByStatus(String status);
AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO);
AppointmentDTO updateAppointment(Long id, UpdateAppointmentDTO
        UpdateAppointmentDTO);
String deleteAppointment(Long id,
                         String updatedBy);


}
