package com.ismael.acodike.pedidos.controller;

import com.ismael.acodike.pedidos.dto.ItemDTO;
import com.ismael.acodike.pedidos.service.ItemService;
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

@Tag(name = "Item", description = "Operations about items")
@RequestMapping("/api/v1")
@RestController
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @Operation(summary = "Get all items", description = "Get all items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of items"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> items = service.getAll();
        return ResponseEntity.ok(items);
    }

    @Operation(summary = "Get item by id", description = "Get item by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved items"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @GetMapping("/items/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Integer id) {
        ItemDTO item = service.getById(id);
        return ResponseEntity.ok(item);
    }

    @Operation(summary = "Create item", description = "Create item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created item"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @PostMapping(path = "/items", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO item) {
        ItemDTO newItem = service.create(item);
        return ResponseEntity.ok(newItem);
    }

    @Operation(summary = "Delete item by id", description = "Delete item by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted item"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @DeleteMapping("/items/{id}")
    public ResponseEntity<ItemDTO> deleteItem(@PathVariable Integer id) {

        ItemDTO deleted = service.delete(id);

        if(deleted == null) {
            return ResponseEntity.notFound().build();
        }else {
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }
    }

}
