package com.checkinn.backend.respolicy;

import com.checkinn.backend.roomunits.RoomUnits;
import com.checkinn.backend.roomunits.RoomUnitsDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Used to carry data for loading process of all contracts
public class ResPolicyDTO {

    private Long contractId;
    private String hotelName;
    private String location;
    private String contactNo;
    private Date endDate;
    private Date startDate;
    private List<RoomUnitsDTO> hotelRooms;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<RoomUnitsDTO> getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(List<RoomUnits> hotelRooms) {
        List<RoomUnitsDTO> roomSetDTOList=new ArrayList<>();
        RoomUnitsDTO roomSetDTO;
        for(RoomUnits hotelRoomSetItem: hotelRooms){
            roomSetDTO=new RoomUnitsDTO();
            roomSetDTO.setHotelRoomSetId(hotelRoomSetItem.getHotelRoomSetId());
            roomSetDTO.setRoomType(hotelRoomSetItem.getRoomType());
            roomSetDTO.setNumOfRooms(hotelRoomSetItem.getNumOfRooms());
            roomSetDTO.setMaxAdults(hotelRoomSetItem.getMaxAdults());
            roomSetDTO.setPricePerAdult(hotelRoomSetItem.getPricePerAdult());
            roomSetDTOList.add(roomSetDTO);
        }
        this.hotelRooms = roomSetDTOList;
    }
}
