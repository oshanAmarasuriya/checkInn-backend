package com.checkinn.backend.hotel;


import com.checkinn.backend.contract.Contract;
import com.checkinn.backend.hotel_rooms.HotelRoomSet;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hotel")

public class Hotel {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId; //primary key
    private String name;
    private String location;
    private String contact;
    @OneToOne(mappedBy = "hotel")
    private Contract contract; //Relation to contract
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HotelRoomSet> rooms; //Relation to HotelRoomSet



    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<HotelRoomSet> getRooms() {
        return rooms;
    }

    public void setRooms(List<HotelRoomSet> rooms) {
        this.rooms = rooms;
    }
}
