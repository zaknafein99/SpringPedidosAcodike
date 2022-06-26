package com.ismael.acodike.pedidos.controller;

import com.ismael.acodike.pedidos.dto.ItemDTO;
import com.ismael.acodike.pedidos.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> items = service.getAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Integer id) {
        ItemDTO item = service.getById(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping(path = "/items", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO item) {
        ItemDTO newItem = service.create(item);
        return ResponseEntity.ok(newItem);
    }

}
