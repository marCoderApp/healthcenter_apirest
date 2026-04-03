package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.Consulting_RoomDTO;
import com.marcoder.healthcenterapi.exception.NotFoundException;
import com.marcoder.healthcenterapi.mapper.Mapper;
import com.marcoder.healthcenterapi.model.Consulting_Room;
import com.marcoder.healthcenterapi.repository.Consulting_RoomRepository;
import com.marcoder.healthcenterapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marcoder.healthcenterapi.model.Department;

import java.util.List;

@Service
public class Consulting_RoomService implements IConsulting_RoomService {

    @Autowired
    private Consulting_RoomRepository consulting_RoomRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    //GET CONSULTING ROOMS
    @Override
    public List<Consulting_RoomDTO> getConsulting_Rooms(){
        return consulting_RoomRepository.findAll()
                .stream()
                .map(Mapper::consultingRoomToDTO)
                .toList();
    }

    //GET CONSULTING ROOM BY ID
    @Override
    public Consulting_RoomDTO getConsulting_RoomById(Long id){

        if (id == null){
            return null;
        }

        return Mapper.consultingRoomToDTO(consulting_RoomRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Consulting room not found with id: " + id)));

    }

    //SAVE CONSULTING ROOM
    @Override
    public Consulting_RoomDTO saveConsulting_Room(Consulting_RoomDTO
                                                  consulting_roomDTO){

        if(consulting_roomDTO == null){
            return null;
        }

        if (consulting_roomDTO.getDepartment_id() == null){
            throw new IllegalArgumentException("Department id is required");
        }

        Department department = departmentRepository.findById(consulting_roomDTO.getDepartment_id()).orElseThrow(
                () -> new NotFoundException("Department not found with id: " + consulting_roomDTO.getDepartment_id())
        );

        Consulting_Room consultingRoom = Consulting_Room.builder()
                .room_number(consulting_roomDTO.getRoom_number())
                .department(department)
                .build();

        Consulting_Room consultingRoomSaved = consulting_RoomRepository.save(consultingRoom);
        return Mapper.consultingRoomToDTO(consultingRoomSaved);
    }

    //UPDATE CONSULTING ROOM
    @Override
    public String updateConsulting_Room(Consulting_RoomDTO consultingRoomDTO, Long id){
        if (consultingRoomDTO == null){
            return "Wrong input!";
        }

        Consulting_Room consultingRoom = consulting_RoomRepository.
                findById(id).orElseThrow(
                        () -> new NotFoundException("Consulting room not found with id: " + consultingRoomDTO.getConsulting_room_id())
                );

        consultingRoom.setRoom_number(consultingRoomDTO.getRoom_number());
        consulting_RoomRepository.save(consultingRoom);
        return "Consulting room updated successfully";
    }

    //GET CONSULTING ROOM BY DEPARTMENT ID
    @Override
    public Consulting_RoomDTO getConsulting_RoomByDepartmentId(Long department_id){
        if (department_id == null){
            return null;
        }

        Consulting_Room consultingRoom = consulting_RoomRepository
                .getReferenceById(department_id);

        if (consultingRoom == null){
            throw new NotFoundException("Consulting room not found with id: " + department_id);
        }

        Consulting_RoomDTO consultingRoomDTO = Consulting_RoomDTO.builder()
                .consulting_room_id(consultingRoom.getConsulting_room_id())
                .room_number(consultingRoom.getRoom_number())
                .department_id(consultingRoom.getDepartment().getDepartment_id())
                .build();

        return consultingRoomDTO;
    }

    //DELETE CONSULTING ROOM BY ID
    @Override
    public String deleteConsulting_Room(Long id){
        if (id == null){
            return "Wrong id";
        }

        consulting_RoomRepository.deleteById(id);
        return "Consulting room deleted successfully";
    }

    //GET CONSULTING ROOM BY ROOM NUMBER
    @Override
    public Consulting_RoomDTO getConsulting_RoomByRoomNumber(int room_number){
        if (room_number < 0){
            return null;
        }

        Consulting_Room consultingRoom = consulting_RoomRepository.
                findByRoomNumber(room_number);

        if (consultingRoom == null){
            throw new NotFoundException("Consulting room not found with room number: " + room_number);
        }

        return Mapper.consultingRoomToDTO(consultingRoom);
    }
}
