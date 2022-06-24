package com.ismael.acodike.SpringPedidosAcodike.controller;

import com.ismael.acodike.SpringPedidosAcodike.domain.Client;
import com.ismael.acodike.SpringPedidosAcodike.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class ClientController {

    private static ClientService service;

    public ClientController(ClientService service) {
        ClientController.service = service;
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> client = service.getAll();
        return ResponseEntity.ok(client);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Client> getClienteById(@PathVariable Integer id) {
        Client client = service.getById(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/clientes/telefono/{telefono}")
    public ResponseEntity<List<Client>> getClienteByTelephone(@PathVariable String telefono) {
        List<Client> client = service.getByTelephone(telefono);
        return ResponseEntity.ok(client);
    }


}
