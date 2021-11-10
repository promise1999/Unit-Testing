package com.keyin.domain.donor;

import java.time.LocalDate;
import java.time.LocalTime;

public class BloodDonor {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String bloodType;
    private LocalDate nextAppointmentDate;
    private LocalDate lastDonationDate;

    public BloodDonor() {
        id = 0;
        firstName = " ";
        lastName = " ";
        dateOfBirth = LocalDate.now();
        bloodType = " ";
        nextAppointmentDate = LocalDate.now();
        lastDonationDate = LocalDate.now();
    }

    public BloodDonor(int id, String firstName, String lastName, LocalDate dateOfBirth, String bloodType,
                      LocalDate nextAppointmentDate, LocalDate lastDonationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bloodType = bloodType;
        this.nextAppointmentDate = nextAppointmentDate;
        this.lastDonationDate = lastDonationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public LocalDate getNextAppointmentDate() {
        return nextAppointmentDate;
    }

    public void setNextAppointmentDate(LocalDate nextAppointmentDate) {
        this.nextAppointmentDate = nextAppointmentDate;
    }

    public LocalDate getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(LocalDate lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }
}
