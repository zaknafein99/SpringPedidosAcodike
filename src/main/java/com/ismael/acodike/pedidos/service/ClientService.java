package com.ismael.acodike.pedidos.service;

import com.ismael.acodike.pedidos.dto.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    List<ClientDTO> getAll();
    ClientDTO getById(Integer id);
    List<ClientDTO> getByTelephone(String telephone);

    ClientDTO create(ClientDTO client);

    ClientDTO delete(Integer id);
}
