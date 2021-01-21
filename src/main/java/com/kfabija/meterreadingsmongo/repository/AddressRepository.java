package com.kfabija.meterreadingsmongo.repository;

import com.kfabija.meterreadingsmongo.domain.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends MongoRepository<Address, String> {
    Optional<Address> findByStreet(String street);
}
