package com.example.part2.model;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;

    public Reservation(Insured insured, Timeslot timeslot) {
        this.insured = insured;
        this.timeslot = timeslot;
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    @Override
    public String toString() {
        return "Reservation:" +
                "insured=" + insured +
                ", timeslot=" + timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

}
