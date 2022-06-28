package com.ismael.acodike.pedidos.service.impl;

import com.ismael.acodike.pedidos.domain.Truck;
import com.ismael.acodike.pedidos.dto.TruckDTO;
import com.ismael.acodike.pedidos.mapper.TruckMapper;
import com.ismael.acodike.pedidos.repository.TruckRepository;
import com.ismael.acodike.pedidos.service.TruckService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TruckServiceImpl implements TruckService {

    private final TruckRepository repository;

    public TruckServiceImpl(TruckRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TruckDTO> getAll() {

        List<TruckDTO> truckDTOs = new ArrayList<>();
        List<Truck> trucks = repository.findAll();
        for (Truck truck:trucks){
            truckDTOs.add(TruckMapper.INSTANCE.truckToTruckDTO(truck));
        }
        return truckDTOs;

    }

    @Override
    public TruckDTO getById(Integer id) {

            Truck truck = repository.findById(id).orElse(null);
            return TruckMapper.INSTANCE.truckToTruckDTO(truck);

    }

    @Override
    public TruckDTO create(TruckDTO truck) {
        Truck truckCreated = repository.save(TruckMapper.INSTANCE.truckDTOToTruck(truck));
        return TruckMapper.INSTANCE.truckToTruckDTO(truckCreated);
    }

    @Override
    public TruckDTO delete(Integer id) {
        Truck truck = repository.findById(id).orElse(null);
        if(truck != null){
            repository.delete(truck);
            return TruckMapper.INSTANCE.truckToTruckDTO(truck);
        }else {
            return null;
        }
    }
}
