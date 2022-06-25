package com.ismael.acodike.SpringPedidosAcodike.service.impl;

import com.ismael.acodike.SpringPedidosAcodike.domain.Client;
import com.ismael.acodike.SpringPedidosAcodike.repository.ClientRepository;
import com.ismael.acodike.SpringPedidosAcodike.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> getAll() {
        return (List<Client>)
                repository.findAll();
    }

    @Override
    public Client getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getByTelephone(String telephone) {
        return repository.findAllByTelefono(telephone);
    }
}
