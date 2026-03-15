package com.marcoder.healthcenterapi.enums;

public enum UserRole {

    ADMIN("Admin"),
    DOCTOR("Doctor"),
    RECEPCIONIST("Recepcionist");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}
