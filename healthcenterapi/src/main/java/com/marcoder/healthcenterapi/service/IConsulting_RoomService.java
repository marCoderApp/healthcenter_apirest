package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.Consulting_RoomDTO;
import com.marcoder.healthcenterapi.model.Consulting_Room;

import java.util.List;

public interface IConsulting_RoomService {

    List<Consulting_RoomDTO> getConsulting_Rooms();
    Consulting_RoomDTO getConsulting_RoomById(Long id);
    Consulting_RoomDTO saveConsulting_Room(Consulting_RoomDTO
                                                   consulting_roomDTO);
    String updateConsulting_Room(Consulting_RoomDTO consulting_Room, Long id);
    Consulting_RoomDTO getConsulting_RoomByDepartmentId(Long department_id);
    String deleteConsulting_Room(Long id);
    Consulting_RoomDTO getConsulting_RoomByRoomNumber(int room_number);
}
