package com.kfabija.meterreadingsmongo.service.impl;

import com.kfabija.meterreadingsmongo.domain.Meter;
import com.kfabija.meterreadingsmongo.dto.meter.MeterDTO;
import com.kfabija.meterreadingsmongo.repository.MeterRepository;
import com.kfabija.meterreadingsmongo.service.MeterService;
import com.kfabija.meterreadingsmongo.service.mapper.MeterMapper;
import com.kfabija.meterreadingsmongo.web.rest.errors.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeterServiceImpl implements MeterService {

    private final MeterRepository meterRepository;

    private final MeterMapper meterMapper;

    public MeterServiceImpl(MeterRepository meterRepository, MeterMapper meterMapper) {
        this.meterRepository = meterRepository;
        this.meterMapper = meterMapper;
    }

    @Override
    public List<MeterDTO> findAll() {
        return meterRepository.findAll().stream().map(meterMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public MeterDTO findById(Long id) {
        Optional<Meter> meter = meterRepository.findById(id);
        if(!meter.isPresent()) {
            throw new EntityNotFoundException("Meter doesn't exist for id: " + id);
        }

        return meterMapper.toDto(meter.get());
    }
}
