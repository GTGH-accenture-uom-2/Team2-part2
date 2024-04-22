package com.accenture.part2.controllers;

import com.accenture.part2.models.*;
import com.accenture.part2.services.InsuredService;
import com.accenture.part2.services.ReservationService;
import com.accenture.part2.services.TimeslotService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/insured")
public class InsuredController {
    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";
    @Autowired
    TimeslotService timeslotService;
    @Autowired
    InsuredService insuredService;
    @Autowired
    ReservationService reservationService;

    @GetMapping("/available/date")
    public Timeslot getAvailableTimeslotByDate(@RequestParam String date) {
        return timeslotService.getAvailableTimeslotByDate(date);
    }

    @GetMapping("/available/month")
    public List<Timeslot> getAvailableTimeslotByMonth(@RequestParam int month) {
        return timeslotService.getAvailableTimeslotByMonth(month);
    }

    @PostMapping()
    public List<Insured> addInsured(@RequestBody Insured insured) {
        return insuredService.addInsured(insured);
    }

    @PostMapping("/makeReservation")
    public Reservation makeReservation(@RequestParam String insuredAmka,
                                       @RequestParam String timeslotDate,
                                       @RequestParam String doctorAmka) {
        return insuredService.makeAReservation(insuredAmka, timeslotDate, doctorAmka);
    }

    @DeleteMapping("/unselectReservation")
    public String unselectReservation(@RequestParam String insuredAmka) {
        return insuredService.unselectReservation(insuredAmka);
    }


    @GetMapping("/vaccinationCoverage")
    public Vaccination getInfoOfInsured(@RequestParam String insuredAmka) {
        return insuredService.getInfoOfInsured(insuredAmka);
    }
}
