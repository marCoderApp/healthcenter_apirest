package com.marcoder.healthcenterapi.enums;

public enum AppointmentStatus {

    IN_PROGRESS("In_progress"),
    CANCELLED("Cancelled"),
    FINISHED("Finished");

    private String appointmentStatus;
   AppointmentStatus(String appointmentStatus) {
       this.appointmentStatus = appointmentStatus;
   }
   public String getAppointmentStatus() {
        return appointmentStatus;
   }


}
