package com.kfabija.meterreadingsmongo.service;

import com.kfabija.meterreadingsmongo.dto.meter.reading.*;
import com.kfabija.meterreadingsmongo.enumeration.Month;

public interface MeterReadingService {

    MeterReadingDTO save(MeterReadingCreateDTO meterReadingCreateDTO);

    MeterReadingDTO findByYearOrMonthAndYear(Month month, Integer year);

    MeterReadingAggregatedDTO findAllByYearAggregated(Integer year);

}
