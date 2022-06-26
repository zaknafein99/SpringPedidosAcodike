package com.ismael.acodike.pedidos.mapper;

import com.ismael.acodike.pedidos.dto.ClientDTO;
import com.ismael.acodike.pedidos.domain.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO clientToClientDTO(Client client);

    Client clientDTOToClient(ClientDTO clientDTO);

}
