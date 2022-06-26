package com.ismael.acodike.pedidos.service.impl;

import com.ismael.acodike.pedidos.dto.ItemDTO;
import com.ismael.acodike.pedidos.domain.Item;
import com.ismael.acodike.pedidos.mapper.ItemMapper;
import com.ismael.acodike.pedidos.repository.ItemRepository;
import com.ismael.acodike.pedidos.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ItemDTO> getAll() {

        List<ItemDTO> itemsDTO = new ArrayList<>();
        List<Item> items = repository.findAll();
        for (Item item:items){
            itemsDTO.add(ItemMapper.INSTANCE.itemToItemDTO(item));
        }
        return itemsDTO;

    }
}

