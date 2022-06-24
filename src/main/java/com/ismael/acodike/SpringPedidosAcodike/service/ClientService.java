package com.ismael.acodike.SpringPedidosAcodike.service;

import com.ismael.acodike.SpringPedidosAcodike.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    public List<Client> getAll();
    public Client getById(Integer id);
    public List<Client> getByTelephone(String telephone);
}
