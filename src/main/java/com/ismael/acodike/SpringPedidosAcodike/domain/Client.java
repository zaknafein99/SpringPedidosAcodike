/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ismael.acodike.SpringPedidosAcodike.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 *
 * @author Docente
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cliente", catalog = "pedidos", schema = "")
public class Client{


    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;
    @Column(name = "apellidonombre", length = 255)
    private String apellidonombre;
    @Column(name = "DIRECCION", length = 255)
    private String direccion;
    @Column(name = "TELEFONO", length = 255)
    private String telefono;
    @Column(name = "TIPOCLIENTE", length = 255)
    private String tipocliente;
//    @OneToMany(mappedBy = "idcliente")
//    private Collection<Pedidos> pedidosCollection;
    @Column(name = "ESTADO", length = 1)
    private char estado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
