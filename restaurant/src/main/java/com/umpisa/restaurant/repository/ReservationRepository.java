package com.umpisa.restaurant.repository;

import com.umpisa.restaurant.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
