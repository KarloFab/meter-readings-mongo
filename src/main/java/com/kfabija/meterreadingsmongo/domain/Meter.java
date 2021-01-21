package com.kfabija.meterreadingsmongo.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Meter {

    @Id
    private String id;
    private String model;
    private Client client;
    private List<MeterReading> meterReadings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<MeterReading> getMeterReadings() {
        return meterReadings;
    }

    public void setMeterReadings(List<MeterReading> meterReadings) {
        this.meterReadings = meterReadings;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
