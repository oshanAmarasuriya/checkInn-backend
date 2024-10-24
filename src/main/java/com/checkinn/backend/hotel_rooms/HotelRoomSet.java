package com.checkinn.backend.hotel_rooms;

import com.checkinn.backend.hotel.Hotel;


public class HotelRoomSet {


    private Long hotelRoomSetId; // Primary Key field

    private Hotel hotel; //Reference to Hotel entity

    private String roomType;
    private int maxAdults;
    private int numOfRooms;

    private double pricePerAdult;

    //Getters and setters
    public Long getHotelRoomSetId() {
        return hotelRoomSetId;
    }

    public void setHotelRoomSetId(Long hotelRoomSetId) {
        this.hotelRoomSetId = hotelRoomSetId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(int maxAdults) {
        this.maxAdults = maxAdults;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public double getPricePerAdult() {
        return pricePerAdult;
    }

    public void setPricePerAdult(double pricePerAdult) {
        this.pricePerAdult = pricePerAdult;
    }
}
