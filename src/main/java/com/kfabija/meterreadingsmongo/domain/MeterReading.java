package com.kfabija.meterreadingsmongo.domain;

import com.kfabija.meterreadingsmongo.enumeration.Month;
import org.springframework.data.annotation.Id;

public class MeterReading {

    @Id
    private String id;
    private Integer year;
    private Month month;
    private Double electricityConsumption;
    private Meter meter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Double getElectricityConsumption() {
        return electricityConsumption;
    }

    public void setElectricityConsumption(Double electricityConsumption) {
        this.electricityConsumption = electricityConsumption;
    }

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }
}
