package com.kfabija.meterreadingsmongo.service;

import com.kfabija.meterreadingsmongo.dto.client.ClientCreateDTO;
import com.kfabija.meterreadingsmongo.dto.client.ClientDTO;

public interface ClientService {

    ClientDTO save(ClientCreateDTO clientCreateDTO);
}
