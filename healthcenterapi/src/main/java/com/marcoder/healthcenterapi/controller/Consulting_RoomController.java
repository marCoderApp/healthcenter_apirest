package com.marcoder.healthcenterapi.controller;


import com.marcoder.healthcenterapi.dto.Consulting_RoomDTO;
import com.marcoder.healthcenterapi.service.Consulting_RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulting_room")
public class Consulting_RoomController {

    @Autowired
    private Consulting_RoomService consulting_RoomService;

    //GET CONSULTING ROOMS
    @GetMapping
    public ResponseEntity<List<Consulting_RoomDTO>> getConsulting_Rooms(){
        return ResponseEntity.ok(consulting_RoomService.getConsulting_Rooms());
    }

    //GET CONSULTING ROOM BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Consulting_RoomDTO> getConsulting_RoomById(@PathVariable Long id){
        return ResponseEntity.ok(consulting_RoomService.getConsulting_RoomById(id));
    }

    //SAVE CONSULTING ROOM
    @PostMapping
    public ResponseEntity<Consulting_RoomDTO> saveConsulting_Room(@RequestBody Consulting_RoomDTO consultingRoomDTO){
        return ResponseEntity.ok(consulting_RoomService.saveConsulting_Room(consultingRoomDTO));
    }

    //UPDATE CONSULTING ROOM
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateConsulting_Room(@RequestBody Consulting_RoomDTO consultingRoomDTO, @PathVariable Long id){
        return ResponseEntity.ok(consulting_RoomService.updateConsulting_Room(consultingRoomDTO, id));
    }

    //GET CONSULTING ROOM BY ID
    @GetMapping("/department/{department_id}")
    public ResponseEntity<Consulting_RoomDTO> getConsulting_RoomByDepartmentId(@PathVariable Long department_id){
        return ResponseEntity.ok(consulting_RoomService.getConsulting_RoomByDepartmentId(department_id));
    }

    //GET CONSULTING ROOM BY ROOM NUMBER
    @GetMapping("/room_number/{room_number}")
    public ResponseEntity<Consulting_RoomDTO> getConsulting_RoomByRoomNumber(@PathVariable int room_number){
        return ResponseEntity.ok(consulting_RoomService.getConsulting_RoomByRoomNumber(room_number));
    }

    //DELETE CONSULTING ROOM BY ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteConsulting_Room(@PathVariable Long id){
        return ResponseEntity.ok(consulting_RoomService.deleteConsulting_Room(id));
    }
}
