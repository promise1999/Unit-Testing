package com.keyin.manager;

import com.keyin.domain.Database;
import com.keyin.domain.appointment.AppointmentSlot;
import com.keyin.domain.appointment.BloodDonationAppointment;
import com.keyin.domain.donor.BloodDonor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.time.Period;

public class BloodDonationAppointmentManager  {
    private Database database;
    private List<AppointmentSlot> appointmentSlotList;


    public BloodDonationAppointmentManager(Database database) {
        this.database = database;
    }

    public BloodDonationAppointment bookAppointment(int bloodDonorId) throws InvalidDonationSchedulingException {
        BloodDonationAppointment bloodDonationAppointment = null;
        appointmentSlotList = database.getAppointmentSlots();
        BloodDonor bloodDonor = database.getDonor(bloodDonorId);

        LocalDate today = LocalDate.now();
        LocalDate tooYoungDate = today.minus(18, ChronoUnit.YEARS);
        LocalDate DateOfBirth = bloodDonor.getDateOfBirth();

        for (int i = 0; i < appointmentSlotList.size(); i++){
            AppointmentSlot appointment = appointmentSlotList.get(i);
            Period difference = Period.between(bloodDonor.getDateOfBirth(), appointment.getDate());
            try{
                if(difference.getYears() >= 18){
                    bloodDonationAppointment.setDateOfBirth(bloodDonor.getDateOfBirth());
                }
                else{
                    throw new InvalidDonationSchedulingException("donor too young");
                }

            }catch (InvalidDonationSchedulingException e){
                throw new InvalidDonationSchedulingException("Try when your 18 ");
            }

            try {
                if(difference.getYears() >= 80){
                    bloodDonationAppointment.setDateOfBirth(bloodDonor.getDateOfBirth());
                }
                else{
                    throw new InvalidDonationSchedulingException("donor too Old");
                }

            }catch (InvalidDonationSchedulingException e){
                throw new InvalidDonationSchedulingException("Save your blood for old age... I think you need it ");
            }
            try{
                if (appointment.getBloodType().equalsIgnoreCase(bloodDonor.getBloodType())) {

                } else{
                    throw new InvalidDonationSchedulingException("Invalid blood type");
                }
            }catch (InvalidDonationSchedulingException e){
                throw new InvalidDonationSchedulingException("Invalid blood type");
            }

            Period duration = Period.between(bloodDonor.getLastDonationDate(), appointment.getDate());
            try {
                if(duration.getDays() >= 56){
                }
                else{
                    throw new InvalidDonationSchedulingException("donor need to wait for 56 day after last donation");
                }

            }catch (InvalidDonationSchedulingException e){
                throw new InvalidDonationSchedulingException("Your appointment is more than 56 days");
            }

            Period year = Period.between(bloodDonor.getLastDonationDate(), appointment.getDate());
            try {
                if(year.getDays() <= 365){
                }
                else{
                    throw new InvalidDonationSchedulingException("donor can't schedule appointment more than one year");
                }

            }catch (InvalidDonationSchedulingException e){
                throw new InvalidDonationSchedulingException("Your appointment should not be more than 365 days");
            }

            try {
                if(bloodDonor.getLastDonationDate() == null){
                    bloodDonationAppointment.setFirstTimeDonor(true);
                    System.out.println("First time donor");
                }
                else{
                    throw new InvalidDonationSchedulingException("donor schedule an appointment");
                }

            }catch (InvalidDonationSchedulingException e){
                throw new InvalidDonationSchedulingException("Your appointment did not process.... try again");
            }
            try {
                if(bloodDonor.getNextAppointmentDate() == null){
                }
                else{
                    throw new InvalidDonationSchedulingException("donor can't schedule an appointment");
                }

            }catch (InvalidDonationSchedulingException e){
                throw new InvalidDonationSchedulingException("You already have an appointment .... try again after 56 days");
            }
        }

        return bloodDonationAppointment;
    }

}
