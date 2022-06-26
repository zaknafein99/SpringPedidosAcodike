package com.ismael.acodike.SpringPedidosAcodike.service;

import com.ismael.acodike.SpringPedidosAcodike.DTO.ClientDTO;
import com.ismael.acodike.SpringPedidosAcodike.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ClientService {

    public List<ClientDTO> getAll();
    public ClientDTO getById(Integer id);
    public List<ClientDTO> getByTelephone(String telephone);
}
