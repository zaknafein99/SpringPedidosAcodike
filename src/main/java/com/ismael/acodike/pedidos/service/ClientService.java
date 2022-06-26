package com.ismael.acodike.pedidos.service;

import com.ismael.acodike.pedidos.DTO.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    public List<ClientDTO> getAll();
    public ClientDTO getById(Integer id);
    public List<ClientDTO> getByTelephone(String telephone);
}
