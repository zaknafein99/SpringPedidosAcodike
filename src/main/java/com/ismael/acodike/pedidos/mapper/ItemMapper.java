package com.ismael.acodike.pedidos.mapper;

import com.ismael.acodike.pedidos.DTO.ItemDTO;
import com.ismael.acodike.pedidos.domain.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDTO itemToItemDTO(Item item);

    Item itemDTOToItem(ItemDTO itemDTO);

}
