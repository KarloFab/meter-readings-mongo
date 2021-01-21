package com.kfabija.meterreadingsmongo.repository;

import com.kfabija.meterreadingsmongo.domain.Meter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterRepository extends MongoRepository<Meter, String> {
}
