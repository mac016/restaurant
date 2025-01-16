package com.umpisa.restaurant.entity.enums;

public enum ReservationStatus {
    ACTIVE(1),
    CANCELLED(2);

    private final int value;

    ReservationStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // This method is used to convert the integer value to the enum
    public static ReservationStatus fromValue(int value) {
        for (ReservationStatus reservationStatus : values()) {
            if (reservationStatus.getValue() == value) {
                return reservationStatus;
            }
        }
        throw new IllegalArgumentException("Invalid reservationStatus value: " + value);
    }
}
