package com.keyin.domain.appointment;

import com.keyin.domain.donor.BloodDonor;

import java.time.LocalDate;
import java.time.LocalTime;

public class BloodDonationAppointment extends BloodDonor {
    private int appointmentId;
    private LocalDate date;
    private LocalTime time;
    private LocalTime duration;
    private String location;
    private String bloodType;
    private boolean firstTimeDonor;
    private int donorId;

    public BloodDonationAppointment() {
        appointmentId = 0;
        date = LocalDate.now();
        time = LocalTime.now();
        duration = LocalTime.now();
        location = " ";
        bloodType = " ";
        firstTimeDonor = false;
        donorId = 0;
    }

    public BloodDonationAppointment(int appointmentId, LocalDate date, LocalTime time, LocalTime duration,
                                    String location, String bloodType, boolean firstTimeDonor, int donorId) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.location = location;
        this.bloodType = bloodType;
        this.firstTimeDonor = firstTimeDonor;
        this.donorId = donorId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public boolean isFirstTimeDonor() {
        return firstTimeDonor;
    }

    public void setFirstTimeDonor(boolean firstTimeDonor) {
        this.firstTimeDonor = firstTimeDonor;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }
}
