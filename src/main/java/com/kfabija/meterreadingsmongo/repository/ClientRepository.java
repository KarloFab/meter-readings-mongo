package com.kfabija.meterreadingsmongo.repository;

import com.kfabija.meterreadingsmongo.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
