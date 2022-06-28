package com.ismael.acodike.pedidos.mapper;

import com.ismael.acodike.pedidos.domain.Truck;
import com.ismael.acodike.pedidos.dto.TruckDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckMapper {

    TruckMapper INSTANCE = Mappers.getMapper(TruckMapper.class);

    TruckDTO truckToTruckDTO(Truck truck);

    Truck truckDTOToTruck(TruckDTO truckDTO);

}
