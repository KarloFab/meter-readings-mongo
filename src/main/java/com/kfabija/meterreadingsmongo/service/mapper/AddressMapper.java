package com.kfabija.meterreadingsmongo.service.mapper;

import com.kfabija.meterreadingsmongo.domain.Address;
import com.kfabija.meterreadingsmongo.dto.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address>{
}
