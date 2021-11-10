package com.keyin.domain;

import com.keyin.domain.appointment.AppointmentSlot;
import com.keyin.domain.donor.BloodDonor;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Database extends AppointmentSlot {

    public List<AppointmentSlot> getAppointmentSlots() {
        ArrayList<AppointmentSlot> appointmentSlots = new ArrayList<AppointmentSlot>();

        AppointmentSlot appointmentSlot = new AppointmentSlot();
        appointmentSlot.setId(1);
        appointmentSlot.setLocation("123 Water St. st. John's NL");
        appointmentSlot.setBloodType("A");
        appointmentSlots.add(appointmentSlot);

        AppointmentSlot appointmentSlot2 = new AppointmentSlot();
        appointmentSlot2.setId(2);
        appointmentSlot2.setLocation("2 Jame St. st. John's NL");
        appointmentSlot2.setBloodType("B");
        appointmentSlots.add(appointmentSlot2);

        AppointmentSlot appointmentSlot3 = new AppointmentSlot();
        appointmentSlot3.setId(3);
        appointmentSlot3.setLocation("7 Jame Lane st. John's NL");
        appointmentSlot3.setBloodType("AB");
        appointmentSlots.add(appointmentSlot3);

        AppointmentSlot appointmentSlot4 = new AppointmentSlot();
        appointmentSlot4.setId(4);
        appointmentSlot4.setLocation("34 Brad St. st. John's NL");
        appointmentSlot4.setBloodType("O");
        appointmentSlots.add(appointmentSlot4);

        AppointmentSlot appointmentSlot5 = new AppointmentSlot();
        appointmentSlot5.setId(5);
        appointmentSlot5.setLocation("6 Field St. st. John's NL");
        appointmentSlot5.setBloodType("AS");
        appointmentSlots.add(appointmentSlot5);

        return appointmentSlots;

    }

    public BloodDonor getDonor(int id) {
        BloodDonor bloodDonor = new BloodDonor();

        bloodDonor.setDateOfBirth(LocalDate.of( 1980 , Month.FEBRUARY , 11 ));

        return bloodDonor;
    }

}
