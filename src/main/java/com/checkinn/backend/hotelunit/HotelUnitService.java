package com.checkinn.backend.hotelunit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelUnitService {


    private HotelUnitRepository hotelRepo;

    @Autowired
    public HotelUnitService(HotelUnitRepository hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    //Get hotel using hotel id
    public HotelUnit getHotelById(long id){
        return hotelRepo.findById(id).orElse(null);
    }

    public String deleteHotel(long id){
        //Delete hotel referring id
        hotelRepo.deleteById(id);
        return "Deleted hotel "+id;
    }

    public List<HotelUnit> getHotels(){
        //Get all
        return hotelRepo.findAll();
    }

}
