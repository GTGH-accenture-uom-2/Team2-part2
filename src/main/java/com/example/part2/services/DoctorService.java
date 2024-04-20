package com.example.part2.services;

import com.example.part2.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    List<Doctor> doctors = new ArrayList<>();

    public List<Doctor> addDoctor(Doctor doctor) {
        doctors.add(doctor);
        return doctors;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}
