package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.AuthRequestDTO;
import com.marcoder.healthcenterapi.dto.AuthResponseDTO;
import com.marcoder.healthcenterapi.dto.RegisterUserDTO;

public interface IAuthService {

    String register(RegisterUserDTO registerUserDTO);

    AuthResponseDTO login(AuthRequestDTO authRequestDTO);

}
