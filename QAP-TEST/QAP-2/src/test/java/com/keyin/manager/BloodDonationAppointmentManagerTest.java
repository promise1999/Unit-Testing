package com.keyin.manager;

import com.keyin.domain.Database;
import com.keyin.domain.appointment.AppointmentSlot;
import com.keyin.domain.appointment.BloodDonationAppointment;
import com.keyin.domain.donor.BloodDonor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class BloodDonationAppointmentManagerTest {
    @Mock
    private Database mockDatabase;

    @Test
    public void testBloodDonorTooYoung() {
        BloodDonor bloodDonorTooYoung = new BloodDonor();
        bloodDonorTooYoung.setFirstName("Evans");
        bloodDonorTooYoung.setLastName("Makie");
        bloodDonorTooYoung.setBloodType("A");
        bloodDonorTooYoung.setDateOfBirth(LocalDate.of(2001, Month.APRIL, 6));
        bloodDonorTooYoung.setId(1);

        Mockito.when(mockDatabase.getDonor(1)).thenReturn(
                bloodDonorTooYoung
        );

        BloodDonationAppointmentManager bloodDonationAppointmentManager =
                new BloodDonationAppointmentManager(mockDatabase);

        try {
            BloodDonationAppointment bloodDonationAppointment = bloodDonationAppointmentManager.bookAppointment(1);
        } catch (InvalidDonationSchedulingException e) {
            Assertions.assertTrue(e.getMessage().equalsIgnoreCase("donor too young"));
        }
    }

    @Test
    public void testBloodDonorTooOld() {
        BloodDonor bloodDonorTooOld = new BloodDonor();
        bloodDonorTooOld.setFirstName("Grace");
        bloodDonorTooOld.setLastName("joe");
        bloodDonorTooOld.setBloodType("A");
        bloodDonorTooOld.setDateOfBirth(LocalDate.of(1802, Month.APRIL, 9));
        bloodDonorTooOld.setId(1);

        Mockito.when(mockDatabase.getDonor(1)).thenReturn(
                bloodDonorTooOld
        );

        BloodDonationAppointmentManager bloodDonationAppointmentManager =
                new BloodDonationAppointmentManager(mockDatabase);

        try {
            BloodDonationAppointment bloodDonationAppointment = bloodDonationAppointmentManager.bookAppointment(1);
        } catch (InvalidDonationSchedulingException e) {
            Assertions.assertTrue(e.getMessage().equalsIgnoreCase("donor too Old"));
        }
    }

    //Assertions.fail("Did not hit expected Exception!");

    @Test
    public void testBloodDonorInvalidType() {
        BloodDonor InvalidType = new BloodDonor();
        InvalidType.setFirstName("John");
        InvalidType.setLastName("Emenike");
        InvalidType.setBloodType("A");
        InvalidType.setDateOfBirth(LocalDate.of(1965, Month.MARCH, 18));
        InvalidType.setId(1);

        Mockito.when(mockDatabase.getDonor(1)).thenReturn(
                InvalidType
        );

        BloodDonationAppointmentManager bloodDonationAppointmentManager = new BloodDonationAppointmentManager(mockDatabase);

        try {
            BloodDonationAppointment bloodDonationAppointment = bloodDonationAppointmentManager.bookAppointment(1);
        } catch (InvalidDonationSchedulingException e) {
            Assertions.assertTrue(e.getMessage().equalsIgnoreCase("Invalid blood type"));
        }
    }
        @Test
        public void testTooSoon() {
            BloodDonor TooSoon = new BloodDonor();
            TooSoon.setFirstName("John");
            TooSoon.setLastName("Emenike");
            TooSoon.setBloodType("A");
            TooSoon.setDateOfBirth(LocalDate.of( 1965 , Month.MARCH , 18 ));
            TooSoon.setId(1);

            Mockito.when(mockDatabase.getDonor(1)).thenReturn(
                    TooSoon
            );

            BloodDonationAppointmentManager bloodDonationAppointmentManager = new BloodDonationAppointmentManager(mockDatabase);

            try {
                BloodDonationAppointment bloodDonationAppointment = bloodDonationAppointmentManager.bookAppointment(1);
            } catch (InvalidDonationSchedulingException e) {
                Assertions.assertTrue(e.getMessage().equalsIgnoreCase("donor need to wait for 56 day after last donation"));
            }



        //Assertions.fail("Did not hit expected Exception!");
    }
        @Test
        public void testTooFar() {
            BloodDonor TooFar = new BloodDonor();
            TooFar.setFirstName("John");
            TooFar.setLastName("Emenike");
            TooFar.setBloodType("A");
            TooFar.setDateOfBirth(LocalDate.of(1965, Month.MARCH, 18));
            TooFar.setId(1);

            Mockito.when(mockDatabase.getDonor(1)).thenReturn(
                    TooFar
            );

            BloodDonationAppointmentManager bloodDonationAppointmentManager = new BloodDonationAppointmentManager(mockDatabase);

            try {
                BloodDonationAppointment bloodDonationAppointment = bloodDonationAppointmentManager.bookAppointment(1);
            } catch (InvalidDonationSchedulingException e) {
                Assertions.assertTrue(e.getMessage().equalsIgnoreCase("donor need to wait for 56 day after last donation"));
            }
        }

        @Test
        public void testDuplicate() {
            BloodDonor duplicate = new BloodDonor();
            duplicate.setFirstName("John");
            duplicate.setLastName("Emenike");
            duplicate.setBloodType("A");
            duplicate.setDateOfBirth(LocalDate.of(1965, Month.MARCH, 18));
            duplicate.setId(1);

            Mockito.when(mockDatabase.getDonor(1)).thenReturn(
                    duplicate
            );

            BloodDonationAppointmentManager bloodDonationAppointmentManager = new BloodDonationAppointmentManager(mockDatabase);

            try {
                BloodDonationAppointment bloodDonationAppointment = bloodDonationAppointmentManager.bookAppointment(1);
            } catch (InvalidDonationSchedulingException e) {
                Assertions.assertTrue(e.getMessage().equalsIgnoreCase("You already have an appointment .... try again after 56 days"));
            }
        }
}

