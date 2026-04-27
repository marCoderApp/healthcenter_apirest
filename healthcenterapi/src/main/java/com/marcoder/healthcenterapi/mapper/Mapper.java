package com.marcoder.healthcenterapi.mapper;


import com.marcoder.healthcenterapi.dto.*;
import com.marcoder.healthcenterapi.model.*;

public class Mapper {

    //BRANCH TO DTO
    public static BranchDTO branchToDTO(Branch branch){
        if(branch == null) return null;

        BranchDTO branchDTO = BranchDTO.builder()
                .id(branch.getBranch_id())
                .branch_name(branch.getName())
                .address(branch.getAddress())
                .build();
        return branchDTO;
    }

    //DEPARTMENT TO DTO
    public static DepartmentDTO departmentToDTO(Department department){
        if(department == null) return null;

        DepartmentDTO departmentDTO = DepartmentDTO.builder()
                .department_id(department.getDepartment_id())
                .name(department.getName())
                .branch_id(String.valueOf(department.getBranch().getBranch_id()))
                .build();
        return departmentDTO;
    }

    //CONSULTING_ROOM TO DTO
    public static Consulting_RoomDTO consultingRoomToDTO(Consulting_Room consultingRoom){
        if(consultingRoom == null) return null;

        Consulting_RoomDTO consultingRoomDTO = Consulting_RoomDTO.builder()
                .consulting_room_id(consultingRoom.getConsulting_room_id())
                .room_number(consultingRoom.getRoom_number())
                .department_id(consultingRoom.getDepartment().getDepartment_id())
                .build();

        return consultingRoomDTO;
    }

    //DOCTOR TO DTO
    public static DoctorDTO doctorToDTO(Doctor doctor){
        if(doctor == null) return null;

        DoctorDTO doctorDTO = DoctorDTO.builder()
                .doctor_id(doctor.getDoctor_id())
                .license_number(doctor.getLicense_number())
                .national_id_number(doctor.getNational_id_number())
                .email(doctor.getEmail())
                .start_at(doctor.getStarted_at())
                .end_at(doctor.getEnded_at())
                .specialty_id(doctor.getSpeciallty().getSpeciallty_id().toString())
                .user_id(doctor.getUser().getUser_id().toString())
                .consulting_room_id(doctor.getConsulting_room().getConsulting_room_id().toString())
                .status(String.valueOf(doctor.getStatus()))
                .build();

        return doctorDTO;
    }

    //SPECIALTY TO DTO
    public static SpecialltyDTO specialtyToDTO(Speciallty speciallty){
        if(speciallty == null) return null;

        SpecialltyDTO specialltyDTO = SpecialltyDTO.builder()
                .speciallty_id(speciallty.getSpeciallty_id())
                .name(speciallty.getName())
                .build();

        return specialltyDTO;
    }

    //USER TO DTO

    public static UserDTO userToDTO(User user){
        return UserDTO.builder()
                .user_id(user.getUser_id())
                .username(user.getUsername())
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole() != null ? user.getRole().name() : null)
                .address(user.getAddress())
                .phone(user.getPhone())
                .national_id_number(user.getNational_id_number())
                .build();
    }

    //DTO TO USER ENTITY
    public static User dtoToUserEntity(RegisterUserDTO userDTO){
        return User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .lastname(userDTO.getLastname())
                .address(userDTO.getAddress())
                .phone(userDTO.getPhone())
                .national_id_number(userDTO.getNational_id_number())
                .build();
    }

    //PATIENT TO DTO
    public static PatientDTO patientToDTO(Patient patient){
        if(patient == null) return null;

        return PatientDTO.builder()
                .patient_id(patient.getPatient_id())
                .name(patient.getName())
                .lastname(patient.getLastname())
                .national_id_number(patient.getNational_id_number())
                .email(patient.getEmail())
                .phone(patient.getPhone())
                .address(patient.getAddress())
                .gender(patient.getGender())
                .blood_type(patient.getBlood_type().name())
                .born_date(patient.getBorn_date())
                .build();
    }

}
