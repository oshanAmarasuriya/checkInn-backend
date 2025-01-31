package com.checkinn.backend.respolicy;

import com.checkinn.backend.hotelunit.HotelUnit;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "Policy")
@Table(name = "policy")
public class ResPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="hotelId",unique = true)
    private HotelUnit hotel;
    private int addedAgentId;


    @Column(name="start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;


    @Column(name="end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public ResPolicy() {
    }

    public ResPolicy(HotelUnit hotel, int addedAgentId, Date startDate, Date endDate) {
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

    public HotelUnit getHotel() {
        return hotel;
    }

    public void setHotel(HotelUnit hotel) {
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
