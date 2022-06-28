package com.ismael.acodike.pedidos.service;

import com.ismael.acodike.pedidos.dto.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    List<ItemDTO> getAll();

    ItemDTO create(ItemDTO item);

    ItemDTO getById(Integer id);

    ItemDTO delete(Integer id);
}
