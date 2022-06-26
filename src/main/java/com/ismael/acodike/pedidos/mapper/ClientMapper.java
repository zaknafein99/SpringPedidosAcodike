package com.ismael.acodike.pedidos.mapper;

import com.ismael.acodike.pedidos.DTO.ClientDTO;
import com.ismael.acodike.pedidos.domain.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "apellidonombre", target = "apellidonombre")
    ClientDTO clientToClientDTO(Client client);
}
