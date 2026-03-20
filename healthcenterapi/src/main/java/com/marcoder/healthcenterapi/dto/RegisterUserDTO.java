package com.marcoder.healthcenterapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserDTO {

    private String username;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String address;
    private String phone;
    private String national_id_number;
    private String role;

}
