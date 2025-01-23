package com.checkinn.backend.hotelunit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelUnitRepository extends JpaRepository<HotelUnit,Long> {
    HotelUnit findByName(String name);


}