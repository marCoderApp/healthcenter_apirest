package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.AuthRequestDTO;
import com.marcoder.healthcenterapi.dto.AuthResponseDTO;
import com.marcoder.healthcenterapi.dto.RegisterUserDTO;
import com.marcoder.healthcenterapi.enums.UserRole;
import com.marcoder.healthcenterapi.exception.NotFoundException;
import com.marcoder.healthcenterapi.model.User;
import com.marcoder.healthcenterapi.repository.UserRepository;
import com.marcoder.healthcenterapi.security.JwtUtils;
import com.marcoder.healthcenterapi.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String register(RegisterUserDTO registerUserDTO) {

        if (userRepository.findByEmail(registerUserDTO.getEmail()).isPresent()) {
            throw new NotFoundException("Email already exists");
        }

        User user = User.builder()
                .username(registerUserDTO.getUsername())
                .name(registerUserDTO.getName())
                .lastname(registerUserDTO.getLastname())
                .email(registerUserDTO.getEmail())
                .password(passwordEncoder.encode(registerUserDTO.getPassword()))
                .address(registerUserDTO.getAddress())
                .phone(registerUserDTO.getPhone())
                .national_id_number(registerUserDTO.getNational_id_number())
                .role(UserRole.RECEPCIONIST)
                .build();

        userRepository.save(user);

        return "User successfully registered";
    }

    @Override
    public AuthResponseDTO login(AuthRequestDTO authRequestDTO){

        Authentication authentication = authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        authRequestDTO.getEmail(),
                        authRequestDTO.getPassword()
                )
        );

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String role = userDetails.getAuthorities()
                .iterator()
                .next().
                getAuthority();

        AuthResponseDTO authResponseDTO = AuthResponseDTO.builder()
                .id(userDetails.getId())
                .token(jwt)
                .email(userDetails.getEmail())
                .username(userDetails.getUsername())
                .role(role)
                .build();

        return authResponseDTO;
    }
}
