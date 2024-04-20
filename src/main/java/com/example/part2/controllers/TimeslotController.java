package com.example.part2.controllers;

import com.example.part2.model.Timeslot;
import com.example.part2.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeslot")
public class TimeslotController {
    @Autowired
    TimeslotService timeslotService;

    @PostMapping
    public List<Timeslot> addTimeslot(@RequestBody Timeslot timeslot) {
        return timeslotService.addTimeslot(timeslot);
    }

    @GetMapping
    public List<Timeslot> getAllTimeslots() {
        return timeslotService.getAllTimeslots();
    }

}



