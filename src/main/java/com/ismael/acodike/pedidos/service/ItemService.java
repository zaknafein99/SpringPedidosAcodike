package com.ismael.acodike.pedidos.service;

import com.ismael.acodike.pedidos.DTO.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    List<ItemDTO> getAll();

}
