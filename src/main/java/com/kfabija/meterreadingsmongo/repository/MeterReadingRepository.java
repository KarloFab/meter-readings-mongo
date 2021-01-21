package com.kfabija.meterreadingsmongo.repository;

import com.kfabija.meterreadingsmongo.domain.MeterReading;
import com.kfabija.meterreadingsmongo.enumeration.Month;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MeterReadingRepository extends MongoRepository<MeterReading, String> {

    MeterReading findByMonthAndYear(Month month, Integer year);

    List<MeterReading> findAllByYear(Integer year);
}
