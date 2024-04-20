package com.example.part2;

import com.example.part2.model.Doctor;
import com.example.part2.model.Insured;
import com.example.part2.model.Reservation;
import com.example.part2.model.Timeslot;
import com.example.part2.services.DoctorService;
import com.example.part2.services.InsuredService;
import com.example.part2.services.ReservationService;
import com.example.part2.services.TimeslotService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Config {

    @Bean
    public CommandLineRunner commandLineRunner(InsuredService insuredService, TimeslotService timeslotService, ReservationService reservationService, DoctorService doctorService) {
        return args -> {
            generateMockData(insuredService, timeslotService, reservationService, doctorService);
        };
    }


    private void generateMockData(InsuredService insuredService, TimeslotService timeslotService, ReservationService reservationService, DoctorService doctorService) {
        Insured insured1 = new Insured("133569710", "13356971098", "Nikos", "1223", "Anagnostou", "nikos@gmail");
        Insured insured2 = new Insured("185411269", "18541126934", "Petros", "1223", "Papadakhs", "petros@gmail");
        Insured insured3 = new Insured("145286903", "14528690389", "Maria", "1223", "Sofou", "maria@gmail");
        Insured insured4 = new Insured("123457891", "32434232234", "Marialena", "1223", "Arvaniti", "marialena@gmail");

        insuredService.addInsured(insured1);
        insuredService.addInsured(insured2);
        insuredService.addInsured(insured3);
        insuredService.addInsured(insured4);


        Doctor doctor1 = new Doctor(1, "32434232456", "Nikos", "Georgiou", "nikos@gmail");
        Doctor doctor2 = new Doctor(2, "32434232980", "Petros", "Theodorou", "petros@gmail");

        doctorService.addDoctor(doctor1);
        doctorService.addDoctor(doctor2);

        Timeslot timeslot1 = new Timeslot(1, LocalDate.of(2024, 10, 25), doctor1);
        Timeslot timeslot2 = new Timeslot(2, LocalDate.of(2024, 10, 25), doctor1);
        Timeslot timeslot3 = new Timeslot(3, LocalDate.of(2024, 4, 20), doctor1);
        Timeslot timeslot4 = new Timeslot(4, LocalDate.of(2024, 4, 20), doctor2);
        Timeslot timeslot5 = new Timeslot(5, LocalDate.of(2024, 4, 19), doctor2);
        timeslotService.addTimeslot(timeslot1);
        timeslotService.addTimeslot(timeslot2);
        timeslotService.addTimeslot(timeslot3);

        Reservation reservation1 = new Reservation(insured1, timeslot1);
        Reservation reservation2 = new Reservation(insured2, timeslot2);
        Reservation reservation3 = new Reservation(insured3, timeslot3);
        Reservation reservation4 = new Reservation(insured4, timeslot4);
        Reservation reservation5 = new Reservation(insured4, timeslot5);
        reservationService.addReservation(reservation1);
        reservationService.addReservation(reservation2);
        reservationService.addReservation(reservation3);
        reservationService.addReservation(reservation4);
        reservationService.addReservation(reservation5);

    }
}