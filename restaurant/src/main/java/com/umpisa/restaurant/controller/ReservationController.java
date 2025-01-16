package com.umpisa.restaurant.controller;

import com.umpisa.restaurant.entity.Reservation;
import com.umpisa.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable int id){
        return reservationService.getReservationById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReservation(@RequestBody Reservation reservation){
        return reservationService.createReservation(reservation);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancelReservation(@PathVariable int id){
        return reservationService.cancelReservation(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable int id, @RequestBody Reservation reservation){
        return reservationService.updateReservation(id, reservation);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return reservationService.getAllReservations();
    }
}
