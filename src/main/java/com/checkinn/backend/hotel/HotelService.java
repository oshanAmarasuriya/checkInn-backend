package com.checkinn.backend.hotel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelService {


    private HotelRepository hotelRepo;

    @Autowired
    public HotelService(HotelRepository hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    //Get hotel using hotel id
    public Hotel getHotelById(long id){
        return hotelRepo.findById(id).orElse(null);
    }

    public String deleteHotel(long id){
        //Delete hotel referring id
        hotelRepo.deleteById(id);
        return "Deleted hotel "+id;
    }

    public List<Hotel> getHotels(){
        //Get all
        return hotelRepo.findAll();
    }

}
