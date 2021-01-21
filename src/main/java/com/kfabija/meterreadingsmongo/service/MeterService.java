package com.kfabija.meterreadingsmongo.service;

import com.kfabija.meterreadingsmongo.dto.meter.MeterDTO;

import java.util.List;

public interface MeterService {

    List<MeterDTO> findAll();

    MeterDTO findById(String id);
}
