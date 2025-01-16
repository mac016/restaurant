package com.umpisa.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = " Reservation")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String name;

    @Column(name = "phone_number")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String phone_number;

    @Column(name = "email")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String email;

    @Column(name = "reservation_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date reservation_date;

    @Column(name = "communication")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Integer communication;

    @Column(name = "status")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Integer status;

    @Column(name = "guest_count")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Integer guest_count;

    //My IDE can't detect lombok. Been stuck for many hours
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public Integer getGuest_count() {
        return guest_count;
    }

    public void setGuest_count(Integer guest_count) {
        this.guest_count = guest_count;
    }
}
