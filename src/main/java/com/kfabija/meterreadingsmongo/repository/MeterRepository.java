package com.kfabija.meterreadingsmongo.repository;

import com.kfabija.meterreadingsmongo.domain.Meter;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MeterRepository extends JpaRepository<Meter, Long> {
}
