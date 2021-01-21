package com.kfabija.meterreadingsmongo.service.impl;

import com.kfabija.meterreadingsmongo.domain.Meter;
import com.kfabija.meterreadingsmongo.domain.MeterReading;
import com.kfabija.meterreadingsmongo.dto.meter.reading.MeterReadingAggregatedDTO;
import com.kfabija.meterreadingsmongo.dto.meter.reading.MeterReadingCreateDTO;
import com.kfabija.meterreadingsmongo.dto.meter.reading.MeterReadingDTO;
import com.kfabija.meterreadingsmongo.enumeration.Month;
import com.kfabija.meterreadingsmongo.repository.MeterReadingRepository;
import com.kfabija.meterreadingsmongo.repository.MeterRepository;
import com.kfabija.meterreadingsmongo.service.MeterReadingService;
import com.kfabija.meterreadingsmongo.service.mapper.MeterReadingMapper;
import com.kfabija.meterreadingsmongo.web.rest.errors.EntityExistsException;
import com.kfabija.meterreadingsmongo.web.rest.errors.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class MeterReadingServiceImpl implements MeterReadingService {

    private final MeterReadingRepository meterReadingRepository;

    private final MeterReadingMapper meterReadingMapper;

    private final MeterRepository meterRepository;

    public MeterReadingServiceImpl(MeterReadingRepository meterReadingRepository, MeterReadingMapper meterReadingMapper, MeterRepository meterRepository) {
        this.meterReadingRepository = meterReadingRepository;
        this.meterReadingMapper = meterReadingMapper;
        this.meterRepository = meterRepository;
    }

    @Override
    public MeterReadingDTO save(MeterReadingCreateDTO meterReadingCreateDTO) {
        checkIfMeterReadingAlreadyExists(meterReadingCreateDTO);

        Meter meter = getMeterByIdIfExists(meterReadingCreateDTO.getMeterId());

        MeterReading meterReading = meterReadingMapper.createDtoToEntity(meterReadingCreateDTO);
        meterReading.setMeter(meter);
        meterReading = meterReadingRepository.save(meterReading);

        return getMeterReadingDTO(meterReading);
    }

    private void checkIfMeterReadingAlreadyExists(MeterReadingCreateDTO meterReadingCreateDTO) {
        MeterReading existingMeterReading = meterReadingRepository.findByMonthAndYear(meterReadingCreateDTO.getMonth(),
                meterReadingCreateDTO.getYear());

        if (nonNull(existingMeterReading)) {
            throw new EntityExistsException(String.format("Meter reading exists for month: %s and year: %d", meterReadingCreateDTO.getMonth(),
                    meterReadingCreateDTO.getYear()));
        }
    }

    @Override
    public MeterReadingDTO findByYearOrMonthAndYear(Month month, Integer year) {
        if (nonNull(month)) {
            return getMeterReadingByMonthAndYearAndMapToDTO(month, year);
        }

        return getMeterReadingsByYearAndMapToDTO(year);
    }

    private MeterReadingDTO getMeterReadingsByYearAndMapToDTO(Integer year) {
        List<MeterReading> meterReadings = getMeterReadingsForYearIfExist(year);

        Map<Month, Double> monthElectricityConsumptionMap = new HashMap<>();
        meterReadings.forEach(meterReading -> monthElectricityConsumptionMap.put(meterReading.getMonth(),
                meterReading.getElectricityConsumption()));

        MeterReadingDTO meterReadingDTO = new MeterReadingDTO();
        meterReadingDTO.setYear(year);
        meterReadingDTO.setMeterReadings(monthElectricityConsumptionMap);

        return meterReadingDTO;
    }

    private MeterReadingDTO getMeterReadingByMonthAndYearAndMapToDTO(Month month, Integer year) {
        MeterReading meterReading = meterReadingRepository.findByMonthAndYear(month, year);

        if (isNull(meterReading)) {
            throw new EntityNotFoundException(String.format("There is no meter reading for month: %s and year: %d", month,
                    year));
        }

        return getMeterReadingDTO(meterReading);
    }

    private MeterReadingDTO getMeterReadingDTO(MeterReading meterReading) {
        Map<Month, Double> monthElectricityConsumptionMap = new HashMap<>();
        monthElectricityConsumptionMap.put(meterReading.getMonth(), meterReading.getElectricityConsumption());

        MeterReadingDTO meterReadingDTO = new MeterReadingDTO();
        meterReadingDTO.setYear(meterReading.getYear());
        meterReadingDTO.setMeterReadings(monthElectricityConsumptionMap);
        return meterReadingDTO;
    }

    @Override
    public MeterReadingAggregatedDTO findAllByYearAggregated(Integer year) {
        List<MeterReading> meterReadings = getMeterReadingsForYearIfExist(year);

        Double electricityConsumptionAggregated = meterReadings.stream().mapToDouble(MeterReading::getElectricityConsumption).sum();

        MeterReadingAggregatedDTO meterReadingAggregatedDTO = new MeterReadingAggregatedDTO();
        meterReadingAggregatedDTO.setYear(year);
        meterReadingAggregatedDTO.setElectricityConsumptionAggregated(electricityConsumptionAggregated);

        return meterReadingAggregatedDTO;

    }

    private List<MeterReading> getMeterReadingsForYearIfExist(Integer year) {
        List<MeterReading> meterReadings = meterReadingRepository.findAllByYear(year);
        if (isNull(meterReadings) || meterReadings.isEmpty()) {
            throw new EntityNotFoundException(String.format("There are no meter readings for year: %d", year));
        }
        return meterReadings;
    }

    private Meter getMeterByIdIfExists(String meterId) {
        Optional<Meter> meter = meterRepository.findById(meterId);
        if (!meter.isPresent()) {
            throw new EntityNotFoundException("Meter doesn't exists for id: " + meterId);
        }
        return meter.get();
    }
}
