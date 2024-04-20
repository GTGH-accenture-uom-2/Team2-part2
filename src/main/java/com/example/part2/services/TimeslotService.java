package com.example.part2.services;

import com.example.part2.model.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeslotService {
    List<Timeslot> timeslots = new ArrayList<>();
    @Autowired
    DoctorService doctorService;

    public List<Timeslot> addTimeslot(Timeslot timeslot) {
        timeslots.add(timeslot);
        return timeslots;
    }


    public List<Timeslot> getAllTimeslots() {
        return timeslots;
    }

}
