package com.ismael.acodike.SpringPedidosAcodike;

import lombok.Data;

@Data
public class ClientDTO {

        private Integer id;
        private String apellidonombre;
        private String direccion;
        private String telefono;
        private String tipocliente;
        private char estado;

}
