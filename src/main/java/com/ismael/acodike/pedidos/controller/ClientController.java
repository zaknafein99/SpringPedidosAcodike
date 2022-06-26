package com.ismael.acodike.pedidos.controller;

import com.ismael.acodike.pedidos.dto.ClientDTO;
import com.ismael.acodike.pedidos.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
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
