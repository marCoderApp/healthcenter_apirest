package com.marcoder.healthcenterapi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consulting_RoomDTO {

        private Long consulting_room_id;
        private Long room_number;
        private String department_id;

}
