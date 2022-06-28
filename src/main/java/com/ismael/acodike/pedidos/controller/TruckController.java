package com.ismael.acodike.pedidos.controller;

import com.ismael.acodike.pedidos.dto.TruckDTO;
import com.ismael.acodike.pedidos.service.TruckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
