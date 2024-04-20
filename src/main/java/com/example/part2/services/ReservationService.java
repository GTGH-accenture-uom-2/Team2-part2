package com.example.part2.services;

import com.example.part2.model.Reservation;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> addReservation(Reservation reservation) {
        reservations.add(reservation);
        return reservations;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Reservation> getAllReservations(int page) {
        int pageSize = 3;
        int totalPages = (int) Math.ceil((double) reservations.size() / pageSize);

        if (page < 1 || page > totalPages) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No reservations found for this page");

        }

        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, reservations.size());

        return reservations.subList(startIndex, endIndex);
    }

    public List<Reservation> getUpcomingReservations() {
        List<Reservation> upcomingReservations = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (Reservation reservation : reservations) {
            if (reservation.getTimeslot().getDate().isAfter(now)) {
                upcomingReservations.add(reservation);
            }
        }
        if (upcomingReservations.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No upcoming reservations ");
        }
        return upcomingReservations;

    }

    public List<Reservation> getReservationsByDate(LocalDate localDate) {
        List<Reservation> reservationsByDate = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getTimeslot().getDate().isEqual(localDate)) {
                reservationsByDate.add(reservation);
            }
        }
        if (reservationsByDate.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No reservations found for date: " + localDate);
        }
        return reservationsByDate;

    }

    private List<Reservation> getDoctorReservations(int doctorId, LocalDate localDate) {
        List<Reservation> doctorReservationsByDate = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getTimeslot().getDate().isEqual(localDate) && (reservation.getTimeslot().getDoctor().getId() == doctorId)) {
                doctorReservationsByDate.add(reservation);
            }
        }
        return doctorReservationsByDate;
    }

    public List<Reservation> getDoctorReservationsByDate(int doctorId, LocalDate localDate) {
        List<Reservation> doctorReservationsByDate = getDoctorReservations(doctorId, localDate);

        if (doctorReservationsByDate.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No reservations found for doctor with id " + doctorId + " and date " + localDate);
        }

        return doctorReservationsByDate;
    }

    public void exportAllReservationsToPdf(HttpServletResponse response, int doctorId, LocalDate localDate) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        List<Reservation> doctorReservationsByDate = getDoctorReservations(doctorId, localDate);
        document.open();
        document.add(new Paragraph("Doctor ID: " + doctorId));
        document.add(new Paragraph("Number of Reservations: " + doctorReservationsByDate.size()));
        if (!doctorReservationsByDate.isEmpty()) {
            document.add(new Paragraph("------------ Timeslots ------------"));
            for (int i = 0; i < doctorReservationsByDate.size(); i++) {
                document.add(new Paragraph(i + ") " + doctorReservationsByDate.get(i).getTimeslot().toPdfFormat()));
            }
        }
        document.close();
    }

}
