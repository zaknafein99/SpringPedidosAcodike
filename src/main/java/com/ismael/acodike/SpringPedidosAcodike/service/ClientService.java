package com.ismael.acodike.SpringPedidosAcodike.service;

import com.ismael.acodike.SpringPedidosAcodike.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ClientService {

    public List<Client> getAll();
    public Client getById(UUID id);
    public List<Client> getByTelephone(String telephone);
}
