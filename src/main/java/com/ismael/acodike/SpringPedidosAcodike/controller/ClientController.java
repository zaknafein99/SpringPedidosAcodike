package com.ismael.acodike.SpringPedidosAcodike.controller;

import com.ismael.acodike.SpringPedidosAcodike.DTO.ClientDTO;
import com.ismael.acodike.SpringPedidosAcodike.domain.Client;
import com.ismael.acodike.SpringPedidosAcodike.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1")
@RestController
public class ClientController {

    private static ClientService service;

    public ClientController(ClientService service) {
        ClientController.service = service;
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> client = service.getAll();
        return ResponseEntity.ok(client);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClientDTO> getClienteById(@PathVariable Integer id) {
        ClientDTO client = service.getById(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/clientes/telefono/{telefono}")
    public ResponseEntity<List<ClientDTO>> getClienteByTelephone(@PathVariable String telefono) {
        List<ClientDTO> client = service.getByTelephone(telefono);
        return ResponseEntity.ok(client);
    }


}
