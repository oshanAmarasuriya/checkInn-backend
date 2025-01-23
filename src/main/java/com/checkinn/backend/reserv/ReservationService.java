package com.checkinn.backend.reserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private ReservationRepository repo;

    @Autowired
    public ReservationService(ReservationRepository repo){this.repo = repo;}

    public Reservation createReservation(Reservation reservation) {
        // Business logic to handle reservation placement
        repo.save(reservation);
        return reservation;
    }

    public List<Reservation> getReservationsByHotelId(Long h_id){
        return repo.findReservByHotelId(h_id);
    }
}
