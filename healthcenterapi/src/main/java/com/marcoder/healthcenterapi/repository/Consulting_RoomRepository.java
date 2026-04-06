package com.marcoder.healthcenterapi.repository;

import com.marcoder.healthcenterapi.model.Consulting_Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface Consulting_RoomRepository extends JpaRepository<Consulting_Room,Long> {
    @Override
    Optional<Consulting_Room> findById(Long id);

    @Query("SELECT c FROM Consulting_Room c WHERE c.consulting_room_id = :consulting_room_id")
    Consulting_Room findByConsulting_RoomId(@Param("consulting_room_id") Long consulting_room_id);

    @Query("SELECT c FROM Consulting_Room c WHERE c.room_number = :room_number")
    Consulting_Room findByRoomNumber(@Param("room_number") int room_number);
}
