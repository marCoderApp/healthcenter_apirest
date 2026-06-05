package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.AppointmentDTO;
import com.marcoder.healthcenterapi.exception.NotFoundException;
import com.marcoder.healthcenterapi.mapper.Mapper;
import com.marcoder.healthcenterapi.model.*;
import com.marcoder.healthcenterapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private Consulting_RoomRepository consulting_RoomRepository;

    @Autowired
    private UserRepository userRepository;

    //GET ALL APPOINTMENTS
    @Override
    public List<AppointmentDTO> getAllAppointments(){
        List<AppointmentDTO> allAppointments =
                appointmentRepository.findAll()
                        .stream()
                        .map(Mapper::appointmentToDTO)
                        .toList();

        return allAppointments;
    };

    //GET APPOINTMENT BY ID
    @Override
    public AppointmentDTO getAppointmentById(Long id){

        if(id == null){
            throw new IllegalArgumentException("Appointment id is required");
        }

        return Mapper.appointmentToDTO(appointmentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Appointment not found with id: " + id)));

    }

    //SAVE APPOINTMENT
    public AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO){
        if(appointmentDTO == null){
            throw new IllegalArgumentException("Appointment is required");
        }

        Patient patient = patientRepository.findById(Long.valueOf(appointmentDTO.getPatient_id())).orElseThrow(
                () -> new RuntimeException("Patient not found with id: " + appointmentDTO.getPatient_id())
        );

        Doctor doctor = doctorRepository.findById(Long.valueOf(appointmentDTO.getDoctor_id())).orElseThrow(
                () -> new RuntimeException("Doctor not found with id: " + appointmentDTO.getDoctor_id())
        );

        Consulting_Room consultingRoom = consulting_RoomRepository.findById(Long.valueOf(appointmentDTO.getConsulting_room_id())).orElseThrow(
                () -> new RuntimeException("Consulting room not found with id: " + appointmentDTO.getConsulting_room_id())
        );

        User user = userRepository.findById(Long.valueOf(appointmentDTO.getUser_id())).orElseThrow(
                ()-> new RuntimeException("User not found with id: " + appointmentDTO.getUser_id())
        );

        Appointment appointment = Appointment.builder()
                .date(appointmentDTO.getDate())
                .time(appointmentDTO.getTime())
                .status(appointmentDTO.getStatus())
                .reason(appointmentDTO.getReason())
                .patient(patient)
                .doctor(doctor)
                .consulting_room(consultingRoom)
                .user(user)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return Mapper.appointmentToDTO(savedAppointment);
    }

    //UPDATE APPOINTMENT BY ID
    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO){
        return null;
    }

    //GET APPOINTMENTs BY DATE

    //GET APPOINTMENT BY STATUS

    //GET APPOINTMENT BY DOCTOR
    @Override
    public List<AppointmentDTO> getAppointmentsByDoctorId(Long doctor_id){
        if (doctor_id == null){
            throw new IllegalArgumentException("Doctor is empty");
        }

        List<Appointment> appointments = appointmentRepository
                .getAppointmentsByDoctorId(doctor_id);

        if (appointments == null){
            throw new NotFoundException("No appointments found with doctor " +
                    "id: " + doctor_id);
        }

        List<AppointmentDTO> dtos = appointments
                .stream()
                .map(Mapper::appointmentToDTO)
                .toList();

        return dtos;
    }

    //GET APPOINTMENT BY PATIENT
    @Override
    public List<AppointmentDTO> getAppointmentsByPatientId(Long patient_id){
        if(patient_id == null){
            throw new IllegalArgumentException("Patient id is required");
        }

        List<Appointment> appointments = appointmentRepository
                .getAppointmentsByPatientId(patient_id);

        if (appointments == null){
            throw new IllegalArgumentException("Patient not found with id: " + patient_id);
        }

        List<AppointmentDTO> dtos = appointments.stream()
                .map(Mapper::appointmentToDTO)
                .toList();

        return dtos;
    }

    //GET APPOINTMENT BY CONSULTING ROOM
    @Override
    public List<AppointmentDTO> getAppointmentsByConsultingRoomId(Long consulting_room_id){

        if (consulting_room_id == null){
            throw new IllegalArgumentException("Consulting Room Id is not correct");
        }

        List<Appointment> appointments = appointmentRepository
                .getAppointmentsByDate(String.valueOf(consulting_room_id));

        if (appointments == null){
            throw new NotFoundException("No appointments found for" +
                    " consulting room with id: " + consulting_room_id);
        }

        List<AppointmentDTO> dtos = appointments
                .stream()
                .map(Mapper::appointmentToDTO)
                .toList();

        return dtos;
    }

    //DELETE APPOINTMENT BY ID
    @Override
    public String deleteAppointment(Long id){
        if(id == null){
            throw new IllegalArgumentException("Appointment id is required");
        }

        appointmentRepository.deleteById(id);
        return "Appointment deleted successfully";
    }

}
