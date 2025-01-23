package com.checkinn.backend.hotelunit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/hotels")
public class HotelUnitController {

    private final HotelUnitService hotelService;

    @Autowired
    public HotelUnitController(HotelUnitService hs){
        this.hotelService=hs;
    }


    @GetMapping
    public List<HotelUnit> findAllHotels(){
        return  hotelService.getHotels();
    }

    @GetMapping("/{id}")
    public HotelUnit findHotelById(@PathVariable int id){
        return hotelService.getHotelById(id);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable int id){
        return hotelService.deleteHotel(id);
    }

}
