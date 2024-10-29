package com.checkinn.backend.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ContractRepository extends JpaRepository<Contract,Long> {
    @Query("select c from Contract c where c.endDate<= :expireLimitDate ")
    List<Contract> findExpiringContracts(Date expireLimitDate);
}
