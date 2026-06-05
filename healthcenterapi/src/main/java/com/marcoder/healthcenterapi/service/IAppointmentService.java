package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.AppointmentDTO;

import java.util.List;

public interface IAppointmentService {

List<AppointmentDTO> getAllAppointments();
List<AppointmentDTO> getAppointmentsByPatientId(Long patient_id);
List<AppointmentDTO> getAppointmentsByDoctorId(Long doctor_id);
List<AppointmentDTO> getAppointmentsByConsultingRoomId(Long consulting_room_id);
List<AppointmentDTO> getAppointmentsByDate(String date);
AppointmentDTO getAppointmentById(Long id);
AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO);
AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO);
String deleteAppointment(Long id);


}
