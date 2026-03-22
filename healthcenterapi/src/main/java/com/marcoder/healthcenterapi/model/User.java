package com.marcoder.healthcenterapi.model;

import com.marcoder.healthcenterapi.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String password;

    @Enumerated(jakarta.persistence.EnumType.STRING)
    private UserRole role;

    private String address;
    private String phone;
    private String national_id_number;

}
