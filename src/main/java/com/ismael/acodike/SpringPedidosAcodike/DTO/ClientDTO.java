package com.ismael.acodike.SpringPedidosAcodike.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

        private Integer id;
        private String apellidonombre;
        private String direccion;
        private String telefono;
        private String tipocliente;
        private char estado;

}
