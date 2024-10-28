package com.checkinn.backend.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hs){
        this.hotelService=hs;
    }


    @GetMapping
    public List<Hotel> findAllHotels(){
        return  hotelService.getHotels();
    }

    @GetMapping("/{id}")
    public Hotel findHotelById(@PathVariable int id){
        return hotelService.getHotelById(id);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable int id){
        return hotelService.deleteHotel(id);
    }

}
