package com.kfabija.meterreadingsmongo.service.mapper;

import com.kfabija.meterreadingsmongo.domain.Client;
import com.kfabija.meterreadingsmongo.dto.client.ClientCreateDTO;
import com.kfabija.meterreadingsmongo.dto.client.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {

    @Mapping(target = "address", ignore = true)
    @Mapping(target = "meter", ignore = true)
    Client createDtoToEntity(ClientCreateDTO clientCreateDTO);

}
