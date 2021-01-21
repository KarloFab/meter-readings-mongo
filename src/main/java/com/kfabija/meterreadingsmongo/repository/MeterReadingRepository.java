package com.kfabija.meterreadingsmongo.repository;

import com.kfabija.meterreadingsmongo.domain.MeterReading;
import com.kfabija.meterreadingsmongo.enumeration.Month;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {

    MeterReading findByMonthAndYear(Month month, Integer year);

    List<MeterReading> findAllByYear(Integer year);
}
