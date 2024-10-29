package com.checkinn.backend.contract;


import com.checkinn.backend.hotel.Hotel;
import com.checkinn.backend.hotel_rooms.HotelRoomSet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ContractService {
    @PersistenceContext
    private EntityManager entityManager;


    private final ContractRepository contractRepo;

    @Autowired
    public ContractService(ContractRepository c) {
        this.contractRepo = c;
    }

    @Transactional
    public ResponseEntity<String> saveContract(Contract contract) {
        /* Save contracts along with related hotels and hotel rooms */
        Hotel hotel = contract.getHotel();
        List<HotelRoomSet> rooms = hotel.getRooms();
        // Ensuring bidirectional association setup between entities - Contract, Hotel and HotelRoomSet
        if (hotel != null) {
            hotel.setContract(contract);
            if (rooms != null) {
                hotel.setRooms(rooms);
                for (HotelRoomSet room : rooms) {
                    room.setHotel(hotel);
                }
            }
        }
        //Save data to db table
        Contract savedContract = contractRepo.save(contract);
        //Generating response
        //If saving process is success...
        if (savedContract != null && savedContract.getContractId() > 0) {
            String message = "Operation completed successfully";
            return new ResponseEntity<>("{\"message\": \"" + message + "\"}", HttpStatus.OK);
        }
        //otherwise...
        String message = "Operation failed due to some reason";
        return new ResponseEntity<>("{\"message\": \"" + message + "\"}", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<ContractsDTO>> getContracts() {
        //Returns a list of all existing contracts
        ContractsDTO result;
        List<ContractsDTO> resultList = new ArrayList<>();
        //Retrieve all contracts from db
        List<Contract> contracts = contractRepo.findAll();


        for (Contract c : contracts) {
            result = new ContractsDTO();
            //Inserting data to DTO
            result.setContractId(c.getContractId());
            result.setHotelName(c.getHotel().getName());
            result.setLocation(c.getHotel().getLocation());
            result.setContactNo(c.getHotel().getContact());
            result.setStartDate(c.getStartDate());
            result.setEndDate(c.getEndDate());
            result.setHotelRooms(c.getHotel().getRooms());
            resultList.add(result);
        }
        if(!resultList.isEmpty()){
            return new ResponseEntity<>(resultList,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<ContractsDTO>> getExpiringContracts(){
        final int period=7;
        Date today=new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, period);
        Date expireLimitDate = calendar.getTime();


        @SuppressWarnings("unchecked")
        List<Contract> contractList=contractRepo.findExpiringContracts(expireLimitDate);

        ContractsDTO result;
        List<ContractsDTO> resultList = new ArrayList<>();


        for (Contract c : contractList) {
            result = new ContractsDTO();
            //Inserting data to DTO
            result.setContractId(c.getContractId());
            result.setHotelName(c.getHotel().getName());
            result.setEndDate(c.getEndDate());

            resultList.add(result);
        }
        if(!resultList.isEmpty()){
            return new ResponseEntity<>(resultList,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    public ResponseEntity<String> deleteContract(long id){
        Contract delContract=entityManager.find(Contract.class,id);
        if (delContract != null) {
            contractRepo.delete(delContract);
            String message = "Operation completed successfully";
            return new ResponseEntity<>("{\"message\": \"" + message + "\"}", HttpStatus.OK);
        }
        String message = "Operation failed due to some reason";
        return new ResponseEntity<>("{\"message\": \"" + message + "\"}", HttpStatus.NOT_MODIFIED);
    }


}
