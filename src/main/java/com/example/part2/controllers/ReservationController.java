package com.example.part2.controllers;

import com.example.part2.model.Reservation;
import com.example.part2.services.ReservationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")

public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping
    public List<Reservation> addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }


    @GetMapping("/{page}") //http://localhost:8080/reservations/2
    public List<Reservation> getReservationsByPage(@PathVariable int page) {
        return reservationService.getAllReservations(page);
    }

    @GetMapping("/upcoming")
    public List<Reservation> getUpcomingReservations() {
        return reservationService.getUpcomingReservations();
    }

    // M
    @GetMapping("/date")
    public List<Reservation> getReservationsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        return reservationService.getReservationsByDate(localDate);

    }

    @GetMapping("/today")
    public List<Reservation> getReservationsForToday() {
        return reservationService.getReservationsByDate(LocalDate.now());
    }

    // http://localhost:8080/reservations/doctor?doctorId=1&date=2024-10-25
    @GetMapping("/doctor")
    public List<Reservation> getDoctorReservationsByDate(@RequestParam int doctorId,
                                                           @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        return reservationService.getDoctorReservationsByDate(doctorId, localDate);
    }

    @GetMapping("/doctor/pdf") // http://localhost:8080/reservations/doctor/pdf?doctorId=1&date=2024-10-25
    public void createPdf(@RequestParam int doctorId,
                          @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        reservationService.exportAllReservationsToPdf(response, doctorId, localDate);
    }

}
