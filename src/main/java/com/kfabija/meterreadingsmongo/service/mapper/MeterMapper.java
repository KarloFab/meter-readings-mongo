package com.kfabija.meterreadingsmongo.service.mapper;

import com.kfabija.meterreadingsmongo.domain.Meter;
import com.kfabija.meterreadingsmongo.dto.meter.MeterCreateDTO;
import com.kfabija.meterreadingsmongo.dto.meter.MeterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeterMapper extends EntityMapper<MeterDTO, Meter>  {

    @Mapping(source = "client.id", target = "clientId")
    MeterDTO toDto(Meter meter);

    Meter createDtoToEntity(MeterCreateDTO meterCreateDTO);
}
