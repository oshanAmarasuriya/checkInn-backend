package com.checkinn.backend.reserv;

import com.checkinn.backend.respolicy.ResPolicyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/place")
    public ResponseEntity<Reservation> placeReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(reservation);
        return ResponseEntity.ok(createdReservation);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> findAll() {return new ResponseEntity<>(reservationService.getAll(), HttpStatus.OK);}


    @GetMapping("/byhotel/{id}")
    public ResponseEntity<List<Reservation>> findReservByHotelId(@PathVariable long id) {return new ResponseEntity<>(reservationService.getReservationsByHotelId(id), HttpStatus.OK);}
}
