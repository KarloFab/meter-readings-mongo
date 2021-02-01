package com.kfabija.meterreadingsmongo.config.dbmigrations;

import com.kfabija.meterreadingsmongo.domain.Address;
import com.kfabija.meterreadingsmongo.domain.Client;
import org.springframework.data.mongodb.core.MongoTemplate;

public class InitialSetupMigration {

    public void addClient(MongoTemplate mongoTemplate) {
        Client client = new Client();
        client.setFirstName("John");
        client.setLastName("Doe");
        client.setAddress(new Address());
    }
}
