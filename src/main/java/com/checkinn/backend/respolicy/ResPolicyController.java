package com.checkinn.backend.respolicy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contracts")
//@CrossOrigin(origins = "http://localhost:4200")
public class ResPolicyController {

    private final ResPolicyService contractService;

    @Autowired
    public ResPolicyController(ResPolicyService cs){
        this.contractService=cs;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContract(@RequestBody ResPolicy contract){
        return contractService.saveContract(contract);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResPolicyDTO>> findAllContracts(){return contractService.getContracts();}

    @GetMapping("/expiring")
    public ResponseEntity<List<ResPolicyDTO>> findExpiringContracts(){return contractService.getExpiringContracts();}

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<String> deleteSelected(@PathVariable long id){
        return contractService.deleteContract(id);
    }

}

