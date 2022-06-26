package com.ismael.acodike.pedidos.service.impl;

import com.ismael.acodike.pedidos.DTO.ClientDTO;
import com.ismael.acodike.pedidos.domain.Client;
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
        List<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
        List<Client> clients = repository.findAll();
        for (Client client:clients){
            ClientDTO clientDTO = ClientDTO.builder()
                    .id(client.getId())
                    .apellidonombre(client.getApellidonombre())
                    .direccion(client.getDireccion())
                    .estado(client.getEstado())
                    .telefono(client.getTelefono())
                    .tipocliente(client.getTipocliente())
                    .build();

            clientsDTO.add(clientDTO);
        }
        return clientsDTO;
    }

    @Override
    public ClientDTO getById(Integer id) {
        Client client = repository.findById(id).orElse(null);

        return ClientDTO.builder()
                .id(client.getId())
                .apellidonombre(client.getApellidonombre())
                .direccion(client.getDireccion())
                .estado(client.getEstado())
                .telefono(client.getTelefono())
                .tipocliente(client.getTipocliente())
                .build();
    }

    @Override
    public List<ClientDTO> getByTelephone(String telephone) {
        List<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
        List<Client> clients = repository.findAllByTelefono(telephone);
        for (Client client:clients){
            ClientDTO clientDTO = ClientDTO.builder()
                    .id(client.getId())
                    .apellidonombre(client.getApellidonombre())
                    .direccion(client.getDireccion())
                    .estado(client.getEstado())
                    .telefono(client.getTelefono())
                    .tipocliente(client.getTipocliente())
                            .build();

            clientsDTO.add(clientDTO);
        }
        return clientsDTO;

    }
}
