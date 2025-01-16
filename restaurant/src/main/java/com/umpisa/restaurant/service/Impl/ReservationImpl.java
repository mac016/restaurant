package com.umpisa.restaurant.service.Impl;

import com.umpisa.restaurant.entity.Reservation;
import com.umpisa.restaurant.repository.ReservationRepository;
import com.umpisa.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation getReservationById(int id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + id));
    }


    @Override
    public ResponseEntity<String> createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        return new ResponseEntity<>("Your table has been reserved", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> cancelReservation(int id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + id));

        reservation.setStatus(2);

        reservationRepository.save(reservation);

        return new ResponseEntity<>("Your reservation has been cancelled", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateReservation(int id, Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + id));

        if (reservation.getReservation_date() != null) {
            existingReservation.setReservation_date(reservation.getReservation_date());
        }
        if (reservation.getGuest_count() != null) {
            existingReservation.setGuest_count(reservation.getGuest_count());
        }

        reservationRepository.save(existingReservation);

        return new ResponseEntity<>("Reservation has been updated", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        if (reservations.isEmpty()) {
            return ResponseEntity.noContent().build();  // Return 204 if no reservations
        }
        return ResponseEntity.ok(reservations);  // Return 200 with the list of reservations
    }
}
