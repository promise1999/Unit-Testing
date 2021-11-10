package com.keyin.domain.appointment;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentSlot extends BloodDonationAppointment {
    private int id;
    private String location;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private String bloodType;

    public AppointmentSlot() {
        id = 0;
        location = " ";
        date = LocalDate.now();
        start = LocalTime.now();
        end = LocalTime.now();
        bloodType = " ";

    }
    public AppointmentSlot(int id, String location, LocalDate date, LocalTime start,
                           LocalTime end, String bloodType) {
        this.id = id;
        this.location = location;
        this.date = date;
        this.start = start;
        this.end = end;
        this.bloodType = bloodType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
