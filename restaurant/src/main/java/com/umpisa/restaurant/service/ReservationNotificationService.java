package com.umpisa.restaurant.service.Impl;

import com.umpisa.restaurant.entity.Reservation;
import com.umpisa.restaurant.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationNotificationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // This method will run every 60 minutes
    @Scheduled(fixedRate = 3600000)
    public void checkUpcomingReservations() {
        Date now = new Date();

        List<Reservation> reservations = reservationRepository.findAll();

        // Loop through all reservations and check if any are 4 hours away
        for (Reservation reservation : reservations) {
            Date reservationDate = reservation.getReservation_date();

            long diffInMillis = reservationDate.getTime() - now.getTime();

            if (diffInMillis <= 4 * 60 * 60 * 1000 && diffInMillis > 0) {
                // Print or perform any action 4 hours before the reservation
                System.out.println("Reminder: Reservation for " + reservation.getName() + " is in 4 hours at " + reservationDate);
            }
        }
    }
}
