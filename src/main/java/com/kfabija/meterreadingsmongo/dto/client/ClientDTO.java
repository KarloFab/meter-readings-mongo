package com.kfabija.meterreadingsmongo.dto.client;

import com.kfabija.meterreadingsmongo.dto.AddressDTO;
import com.kfabija.meterreadingsmongo.dto.meter.MeterCreateDTO;

public class ClientDTO {
    private String id;
    private String firstName;
    private String lastName;
    private AddressDTO address;
    private MeterCreateDTO meter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public MeterCreateDTO getMeter() {
        return meter;
    }

    public void setMeter(MeterCreateDTO meter) {
        this.meter = meter;
    }
}
