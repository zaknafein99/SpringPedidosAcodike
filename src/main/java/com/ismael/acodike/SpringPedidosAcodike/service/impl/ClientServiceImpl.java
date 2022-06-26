package com.ismael.acodike.SpringPedidosAcodike.service.impl;

import com.ismael.acodike.SpringPedidosAcodike.DTO.ClientDTO;
import com.ismael.acodike.SpringPedidosAcodike.domain.Client;
import com.ismael.acodike.SpringPedidosAcodike.repository.ClientRepository;
import com.ismael.acodike.SpringPedidosAcodike.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClientDTO> getAll() {
        List<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
        List<Client> clients = new ArrayList<Client>();
        clients = repository.findAll();
        for (Client client:clients){
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setApellidonombre(client.getApellidonombre());
            clientDTO.setDireccion(client.getDireccion());
            clientDTO.setEstado(client.getEstado());
            clientDTO.setTelefono(client.getTelefono());
            clientDTO.setTipocliente(client.getTipocliente());

            clientsDTO.add(clientDTO);
        }
        return clientsDTO;
    }

    @Override
    public ClientDTO getById(Integer id) {
        Client client = repository.findById(id).orElse(null);
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setApellidonombre(client.getApellidonombre());
        clientDTO.setDireccion(client.getDireccion());
        clientDTO.setEstado(client.getEstado());
        clientDTO.setTelefono(client.getTelefono());
        clientDTO.setTipocliente(client.getTipocliente());

        return clientDTO;
    }

    @Override
    public List<ClientDTO> getByTelephone(String telephone) {
        List<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
        List<Client> clients = new ArrayList<Client>();
        clients = repository.findAllByTelefono(telephone);
        for (Client client:clients){
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setApellidonombre(client.getApellidonombre());
            clientDTO.setDireccion(client.getDireccion());
            clientDTO.setEstado(client.getEstado());
            clientDTO.setTelefono(client.getTelefono());
            clientDTO.setTipocliente(client.getTipocliente());

            clientsDTO.add(clientDTO);
        }
        return clientsDTO;

    }
}
