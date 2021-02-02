package com.kfabija.meterreadingsmongo.config.dbmigrations;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import com.kfabija.meterreadingsmongo.domain.Address;
import com.kfabija.meterreadingsmongo.domain.Client;

@ChangeLog(order = "001")
public class InitialSetupMigration {

    @ChangeSet(order = "001", id = "clientInitialInsert", author = "karlo")
    public void addClient(MongockTemplate mongockTemplate) {
        Client client = new Client();
        client.setFirstName("John");
        client.setLastName("Doe");
        client.setAddress(new Address());
        mongockTemplate.save(client);
    }
}
