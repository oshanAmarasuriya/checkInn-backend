package com.checkinn.backend.hotelunit;


import com.checkinn.backend.respolicy.ResPolicy;
import com.checkinn.backend.roomunits.RoomUnits;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hotel")

public class HotelUnit {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId; //primary key
    private String name;
    private String location;
    private String contact;
    @OneToOne(mappedBy = "hotel")
    private ResPolicy contract; //Relation to contract
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomUnits> rooms; //Relation to HotelRoomSet



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

    public ResPolicy getContract() {
        return contract;
    }

    public void setContract(ResPolicy contract) {
        this.contract = contract;
    }

    public List<RoomUnits> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomUnits> rooms) {
        this.rooms = rooms;
    }
}
