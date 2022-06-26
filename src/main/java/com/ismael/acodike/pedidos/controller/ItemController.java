package com.ismael.acodike.pedidos.controller;

import com.ismael.acodike.pedidos.DTO.ItemDTO;
import com.ismael.acodike.pedidos.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class ItemController {

    private static ItemService service;

    public ItemController(ItemService service) {
        ItemController.service = service;
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> items = service.getAll();
        return ResponseEntity.ok(items);
    }

}
