package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.DoctorDTO;
import com.marcoder.healthcenterapi.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    //GET ALL DOCTORS
    @Override
    public List<DoctorDTO> getDoctors(){
        return null;
    }

    //GET DOCTOR BY ID
    @Override
    public DoctorDTO getDoctorById(Long id){
        return null;
    }

    //GET DOCTOR BY SPECIALTY ID
    @Override
    public List<DoctorDTO> getDoctorsBySpecialtyId(Long specialty_id){
        return null;
    }

    //GET DOCTOR BY CONSULTING ROOM ID
    @Override
    public List<DoctorDTO> getDoctorsByConsulting_RoomId(Long consulting_room_id){
        return null;
    }

    //GET DOCTOR BY NATIONAL ID NUMBER
    @Override
    public DoctorDTO getDoctorByNationalIdNumber(String national_id_number){
        return null;
    }

    //GET DOCTOR BY EMAIL
    @Override
    public DoctorDTO getDoctorByEmail(String email){
        return null;
    }

    //SAVE DOCTOR
    @Override
    public DoctorDTO saveDoctor(DoctorDTO doctorDTO){
        return null;
    }

    //UPDATE DOCTOR BY ID
    @Override
    public String updateDoctor(DoctorDTO doctorDTO, Long id){
        return "";
    }

    //DELETE DOCTOR BY ID
    @Override
    public String deleteDoctor(Long id){
        return "";
    }
}
