package com.checkinn.backend.contract;

import com.checkinn.backend.hotel.Hotel;
import jakarta.persistence.*;

import java.util.Date;


public class Contract {


    private Long contractId;
    private Hotel hotel;
    private int addedAgentId;


    private Date startDate;


    private Date endDate;

    public Contract() {
    }

    public Contract( Hotel hotel, int addedAgentId, Date startDate, Date endDate) {
        this.hotel = hotel;
        this.addedAgentId = addedAgentId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getAddedAgentId() {
        return addedAgentId;
    }

    public void setAddedAgentId(int addedAgentId) {
        this.addedAgentId = addedAgentId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
