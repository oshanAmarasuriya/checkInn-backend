package com.checkinn.backend.roomunits;

public class RoomUnitsDTO {
    private long hotelRoomSetId;
    private String roomType;
    private int maxAdults;
    private int numOfRooms;
    private double pricePerAdult;

    public long getHotelRoomSetId() {
        return hotelRoomSetId;
    }

    public void setHotelRoomSetId(long hotelRoomSetId) {
        this.hotelRoomSetId = hotelRoomSetId;
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
