package com.marcoder.healthcenterapi.enums;

public enum DoctorStatus {

    AVAILABLE("Available"),
    NOT_AVAILABLE("Not_Available");

    private String status;

    DoctorStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
