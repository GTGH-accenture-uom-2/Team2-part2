package com.example.part2.model;

import java.time.LocalDate;

public class Timeslot {
    private Integer id;
    private LocalDate date;
    private Doctor doctor;

    public Timeslot() {
    }

    public Timeslot(Integer id, LocalDate date, Doctor doctor) {
        this.id = id;
        this.date = date;
        this.doctor = doctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Timeslot(LocalDate date, Doctor doctor) {
        this.date = date;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Timeslot{" +
                "date=" + date +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String toPdfFormat() {
        return "id: " + id + ", date:" + date;
    }

}
