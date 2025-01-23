package com.checkinn.backend.reserv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("SELECT r FROM Reservation r WHERE r.hotelId = :h_id")
    List<Reservation> findReservByHotelId(@Param("h_id") Long h_id);
}
