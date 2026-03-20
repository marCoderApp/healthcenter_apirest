package com.marcoder.healthcenterapi.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponseDTO {

    private Long id;
    private String username;
    private String email;
    private String token;
    private String role;

}
