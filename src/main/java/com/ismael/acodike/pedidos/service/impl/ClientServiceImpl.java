package com.ismael.acodike.pedidos.service.impl;

import com.ismael.acodike.pedidos.dto.ClientDTO;
import com.ismael.acodike.pedidos.domain.Client;
import com.ismael.acodike.pedidos.mapper.ClientMapper;
import com.ismael.acodike.pedidos.repository.ClientRepository;
import com.ismael.acodike.pedidos.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClientDTO> getAll() {
        List<ClientDTO> clientsDTO = new ArrayList<>();
        List<Client> clients = repository.findAll();
        for (Client client:clients){
            clientsDTO.add(ClientMapper.INSTANCE.clientToClientDTO(client));
        }
        return clientsDTO;
    }

    @Override
    public ClientDTO getById(Integer id) {
        Client client = repository.findById(id).orElse(null);

        return ClientMapper.INSTANCE.clientToClientDTO(client);
        }

    @Override
    public List<ClientDTO> getByTelephone(String telephone) {
        List<ClientDTO> clientsDTO = new ArrayList<>();
        List<Client> clients = repository.findAllByTelefono(telephone);
        for (Client client:clients){
            clientsDTO.add(ClientMapper.INSTANCE.clientToClientDTO(client));
        }
        return clientsDTO;

    }

    @Override
    public ClientDTO create(ClientDTO client) {
        Client clientCreated = repository.save(ClientMapper.INSTANCE.clientDTOToClient(client));
        return ClientMapper.INSTANCE.clientToClientDTO(clientCreated);
    }
}
