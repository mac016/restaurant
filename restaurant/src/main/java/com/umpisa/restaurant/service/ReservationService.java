package com.umpisa.restaurant.service;

import com.umpisa.restaurant.entity.Reservation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {

    public Reservation getReservationById(int id);

    ResponseEntity<String> createReservation(Reservation reservation);

    ResponseEntity<String> cancelReservation(int id);

    ResponseEntity<String> updateReservation(int id, Reservation reservation);

    public ResponseEntity<List<Reservation>> getAllReservations();
}
