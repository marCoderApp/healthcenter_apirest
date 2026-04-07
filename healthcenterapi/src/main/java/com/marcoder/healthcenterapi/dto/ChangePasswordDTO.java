package com.marcoder.healthcenterapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangePasswordDTO {

    private String current_password;
    private String new_password;
}
