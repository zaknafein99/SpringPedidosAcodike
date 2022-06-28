package com.ismael.acodike.pedidos.controller;

import com.ismael.acodike.pedidos.dto.ClientDTO;
import com.ismael.acodike.pedidos.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Client", description = "Operations about clients")
@RequestMapping("/api/v1")
@RestController
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @Operation(summary = "Get all clients", description = "Get all clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of clients"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @GetMapping("/clientes")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> client = service.getAll();
        return ResponseEntity.ok(client);
    }

    @Operation(summary = "Get client by id", description = "Get client by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved client"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClientDTO> getClienteById(@PathVariable Integer id) {
        ClientDTO client = service.getById(id);
        return ResponseEntity.ok(client);
    }

    @Operation(summary = "Get client by telephone", description = "Get client by telephone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved client by telephone"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @GetMapping("/clientes/telefono/{telefono}")
    public ResponseEntity<List<ClientDTO>> getClienteByTelephone(@PathVariable String telefono) {
        List<ClientDTO> client = service.getByTelephone(telefono);
        return ResponseEntity.ok(client);
    }

    @Operation(summary = "Create client", description = "Create client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created client"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @PostMapping(path = "/clientes", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO client) {
        ClientDTO newClient = service.create(client);
        return ResponseEntity.ok(newClient);
    }

    @Operation(summary = "Delete client", description = "Delete client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted client"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable Integer id) {
        ClientDTO deleted = service.delete(id);

        if(deleted == null) {
            return ResponseEntity.notFound().build();
        }else {
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }
    }

}
