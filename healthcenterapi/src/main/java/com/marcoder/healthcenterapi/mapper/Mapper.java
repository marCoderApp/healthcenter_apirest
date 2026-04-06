package com.marcoder.healthcenterapi.mapper;


import com.marcoder.healthcenterapi.dto.BranchDTO;
import com.marcoder.healthcenterapi.dto.Consulting_RoomDTO;
import com.marcoder.healthcenterapi.dto.DepartmentDTO;
import com.marcoder.healthcenterapi.dto.DoctorDTO;
import com.marcoder.healthcenterapi.model.Branch;
import com.marcoder.healthcenterapi.model.Consulting_Room;
import com.marcoder.healthcenterapi.model.Department;
import com.marcoder.healthcenterapi.model.Doctor;

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
                .build();

        return doctorDTO;
    }

}
