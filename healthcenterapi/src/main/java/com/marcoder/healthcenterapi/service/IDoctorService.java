package com.marcoder.healthcenterapi.service;


import com.marcoder.healthcenterapi.dto.DoctorDTO;

import java.util.List;

public interface IDoctorService {

    List<DoctorDTO> getDoctors();
    DoctorDTO getDoctorById(Long id);
    List<DoctorDTO> getDoctorsBySpecialtyId(Long specialty_id);
    List<DoctorDTO> getDoctorsByConsulting_RoomId(Long consulting_room_id);
    DoctorDTO getDoctorByNationalIdNumber(String national_id_number);
    DoctorDTO getDoctorByEmail(String email);
    DoctorDTO saveDoctor(DoctorDTO doctorDTO);
    String updateDoctor(DoctorDTO doctorDTO, Long id);
    String deleteDoctor(Long id);

}
