package com.ismael.acodike.pedidos.controller;

import com.ismael.acodike.pedidos.dto.TruckDTO;
import com.ismael.acodike.pedidos.service.TruckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Truck", description = "Operations about Trucks")
@RequestMapping("/api/v1")
@RestController
public class TruckController {

    private final TruckService service;

    public TruckController(TruckService service) {
        this.service = service;
    }

    @Operation(summary = "Get all trucks", description = "Get all Trucks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of trucks"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @GetMapping("/trucks")
    public ResponseEntity<List<TruckDTO>> getAllTrucks() {
        List<TruckDTO> trucks = service.getAll();
        return ResponseEntity.ok(trucks);
    }

    @Operation(summary = "Get truck by id", description = "Get truck by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved truck"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @GetMapping("/trucks/{id}")
    public ResponseEntity<TruckDTO> getTruckById(@PathVariable Integer id) {
        TruckDTO truck = service.getById(id);
        return ResponseEntity.ok(truck);
    }

    @Operation(summary = "Create truck", description = "Create truck")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created truck"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @PostMapping("/trucks")
    public ResponseEntity<TruckDTO> createTruck(@RequestBody TruckDTO truck) {
        TruckDTO createdTruck = service.create(truck);
        return ResponseEntity.ok(createdTruck);
    }

    @Operation(summary = "Delete truck", description = "Delete truck")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted truck"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @DeleteMapping("/trucks/{id}")
    public ResponseEntity<TruckDTO> deleteTruck(@PathVariable Integer id) {
        TruckDTO deletedTruck = service.delete(id);
        return ResponseEntity.ok(deletedTruck);
    }
}
