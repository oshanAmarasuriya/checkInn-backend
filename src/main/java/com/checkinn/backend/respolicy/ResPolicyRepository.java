package com.checkinn.backend.respolicy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ResPolicyRepository extends JpaRepository<ResPolicy,Long> {
    @Query("select c from Policy c where c.endDate<= :expireLimitDate ")
    List<ResPolicy> findExpiringContracts(Date expireLimitDate);
}
