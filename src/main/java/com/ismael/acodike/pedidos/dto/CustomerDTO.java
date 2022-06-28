package com.ismael.acodike.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

        private Integer id;
        private String apellidonombre;
        private String direccion;
        private String telefono;
        private String tipocliente;
        private char estado;

}
