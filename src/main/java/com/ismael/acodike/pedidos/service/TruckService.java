package com.ismael.acodike.pedidos.service;

import com.ismael.acodike.pedidos.dto.TruckDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TruckService {

    List<TruckDTO> getAll();

    TruckDTO getById(Integer id);

    TruckDTO create(TruckDTO truck);

    TruckDTO delete(Integer id);

}
