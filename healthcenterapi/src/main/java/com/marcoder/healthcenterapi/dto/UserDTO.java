package com.marcoder.healthcenterapi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long user_id;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String role;
    private String address;
    private String phone;
    private String national_id_number;

}
