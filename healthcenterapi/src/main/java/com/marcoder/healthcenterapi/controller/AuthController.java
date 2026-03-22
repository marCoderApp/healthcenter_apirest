package com.marcoder.healthcenterapi.controller;

import com.marcoder.healthcenterapi.dto.AuthRequestDTO;
import com.marcoder.healthcenterapi.dto.AuthResponseDTO;
import com.marcoder.healthcenterapi.dto.RegisterUserDTO;
import com.marcoder.healthcenterapi.model.User;
import com.marcoder.healthcenterapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterUserDTO registerUserDTO) throws Exception {
        return ResponseEntity.ok(authService.register(registerUserDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> loginUser(@RequestBody AuthRequestDTO authRequestDTO) throws Exception {
        return ResponseEntity.ok(authService.login(authRequestDTO));
    }

}
