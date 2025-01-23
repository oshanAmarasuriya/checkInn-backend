package com.checkinn.backend.reserv;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    public Reservation createReservation(Reservation reservation) {
        // Business logic to handle reservation placement
        reservation.setId(1L); // Saving by setting an ID
        return reservation;
    }
}
