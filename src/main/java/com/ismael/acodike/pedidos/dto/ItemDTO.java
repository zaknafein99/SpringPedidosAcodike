package com.ismael.acodike.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Integer codigo;
    private String nombre;
    private Integer precio;
    private Integer kgs;
//    @OneToMany(mappedBy = "idArticulo")
//    private Collection<Pedidos> pedidosCollection;

}
