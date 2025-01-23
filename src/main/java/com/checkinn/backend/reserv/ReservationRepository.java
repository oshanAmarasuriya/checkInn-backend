package com.checkinn.backend.reserv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("select r from Reservation where r.hotelId == :h_id")
    List<Reservation> findReservByHotelId(Long h_id);
}
