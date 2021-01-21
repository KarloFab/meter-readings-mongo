package com.kfabija.meterreadingsmongo.service.mapper;

import com.kfabija.meterreadingsmongo.domain.MeterReading;
import com.kfabija.meterreadingsmongo.dto.meter.reading.MeterReadingCreateDTO;
import com.kfabija.meterreadingsmongo.dto.meter.reading.MeterReadingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface MeterReadingMapper extends EntityMapper<MeterReadingDTO, MeterReading> {

    MeterReadingDTO toDto(MeterReading meterReading);

    MeterReading createDtoToEntity(MeterReadingCreateDTO meterReading);

    @Mapping(source = "meter.id", target = "meterId")
    MeterReadingCreateDTO entityToCreateDto(MeterReading meterReading);
}
