package com.kfabija.meterreadingsmongo.repository;

import com.kfabija.meterreadingsmongo.domain.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
}
