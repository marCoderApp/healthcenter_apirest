package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.Consulting_RoomDTO;
import com.marcoder.healthcenterapi.dto.DoctorDTO;
import com.marcoder.healthcenterapi.dto.SpecialltyDTO;
import com.marcoder.healthcenterapi.enums.DoctorStatus;
import com.marcoder.healthcenterapi.exception.NotFoundException;
import com.marcoder.healthcenterapi.mapper.Mapper;
import com.marcoder.healthcenterapi.model.Consulting_Room;
import com.marcoder.healthcenterapi.model.Doctor;
import com.marcoder.healthcenterapi.model.Speciallty;
import com.marcoder.healthcenterapi.model.User;
import com.marcoder.healthcenterapi.repository.Consulting_RoomRepository;
import com.marcoder.healthcenterapi.repository.DoctorRepository;
import com.marcoder.healthcenterapi.repository.SpecialltyRepository;
import com.marcoder.healthcenterapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SpecialltyService specialltyService;

    @Autowired
    private SpecialltyRepository specialltyRepository;

    @Autowired
    private Consulting_RoomService consulting_RoomService;
    @Autowired
    private Consulting_RoomRepository consulting_RoomRepository;

    @Autowired
    private UserRepository userRepository;

    //GET ALL DOCTORS
    @Override
    public List<DoctorDTO> getDoctors(){
        return doctorRepository.findAll()
                .stream()
                .map(Mapper::doctorToDTO)
                .toList();
    }

    //GET DOCTOR BY ID
    @Override
    public DoctorDTO getDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Doctor not found with id: " + id)
        );

        return Mapper.doctorToDTO(doctor);
    }

    //GET DOCTOR BY SPECIALTY ID
    @Override
    public List<DoctorDTO> getDoctorsBySpecialtyId(Long speciallty_id){

        List<Doctor> doctorRepositoryBySpecialltyId = doctorRepository.findBySpecialltyId(speciallty_id);

        if (doctorRepositoryBySpecialltyId.isEmpty()){
            throw new NotFoundException("Doctors not found with speciallty id: " + speciallty_id);
        }

        return doctorRepositoryBySpecialltyId.stream()
                .map(Mapper::doctorToDTO)
                .toList();

    }

    //GET DOCTOR BY CONSULTING ROOM ID
    @Override
    public List<DoctorDTO> getDoctorsByConsulting_RoomId(Long consulting_room_id){

        List<Doctor> doctorRepositoryByConsulting_RoomId = doctorRepository.findByConsulting_RoomId(consulting_room_id);
        if (doctorRepositoryByConsulting_RoomId.isEmpty()){
            throw new NotFoundException("Doctors not found with consulting room id: " + consulting_room_id);
        }


        return doctorRepositoryByConsulting_RoomId.stream()
                .map(Mapper::doctorToDTO)
                .toList();
    }

    //GET DOCTOR BY NATIONAL ID NUMBER
    @Override
    public DoctorDTO getDoctorByNationalIdNumber(String national_id_number){

        Doctor doctor = doctorRepository.findByNationalIdNumber(national_id_number);
        if (doctor == null){
            throw new NotFoundException("Doctor not found with national id number: " + national_id_number);
        }

        return Mapper.doctorToDTO(doctor);
    }

    //GET DOCTOR BY EMAIL
    @Override
    public DoctorDTO getDoctorByEmail(String email){
        Doctor doctor = doctorRepository.findByEmail(email);

        if (doctor == null){
            throw new NotFoundException("Doctor not found with email: " + email);
        }

        return Mapper.doctorToDTO(doctor);
    }

    //SAVE DOCTOR
    @Override
    public DoctorDTO saveDoctor(DoctorDTO doctorDTO){

        Speciallty speciallty = specialltyRepository.findBySpeciallty_Id(Long.valueOf(doctorDTO.getSpecialty_id()));
        Consulting_Room consultingRoom = consulting_RoomRepository.findByConsulting_RoomId(Long.valueOf(doctorDTO.getConsulting_room_id()));
        User user = userRepository.findById(Long.valueOf(doctorDTO.getUser_id())).orElseThrow(
                ()-> new NotFoundException("User not found with id: " + doctorDTO.getUser_id())
        );

        Doctor doctor = Doctor.builder()
                .license_number(doctorDTO.getLicense_number())
                .national_id_number(doctorDTO.getNational_id_number())
                .email(doctorDTO.getEmail())
                .started_at(doctorDTO.getStart_at())
                .ended_at(doctorDTO.getEnd_at())
                .status(DoctorStatus.valueOf(doctorDTO.getStatus()))
                .user(user)
                .consulting_room(consultingRoom)
                .speciallty(speciallty)
                .build();

        Doctor savedDoctor = doctorRepository.save(doctor);



        return Mapper.doctorToDTO(savedDoctor);
    }

    //UPDATE DOCTOR BY ID
    @Override
    public String updateDoctor(DoctorDTO doctorDTO, Long id){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Doctor not found with id: " + id)
        );

        doctor.setLicense_number(doctorDTO.getLicense_number());
        doctor.setNational_id_number(doctorDTO.getNational_id_number());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setStarted_at(doctorDTO.getStart_at());
        doctor.setEnded_at(doctorDTO.getEnd_at());
        doctor.setStatus(DoctorStatus.valueOf(doctorDTO.getStatus()));

        doctorRepository.save(doctor);
        return "Doctor updated successfully";
    }

    //DELETE DOCTOR BY ID
    @Override
    public String deleteDoctor(Long id){
        doctorRepository.deleteById(id);
        return "Doctor deleted successfully";
    }
}
