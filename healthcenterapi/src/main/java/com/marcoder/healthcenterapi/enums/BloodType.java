package com.marcoder.healthcenterapi.enums;

public enum BloodType {

    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    O_POSITIVE("0+"),
    O_NEGATIVE("0-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-");

    private String bloodType;

    BloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodType(){
        return this.bloodType;
    }
}
