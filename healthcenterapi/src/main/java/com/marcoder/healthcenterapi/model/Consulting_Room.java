package com.marcoder.healthcenterapi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Consulting_Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consulting_room_id;
    private int room_number;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

}
