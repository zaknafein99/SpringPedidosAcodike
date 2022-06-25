/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ismael.acodike.SpringPedidosAcodike.domain;


import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Docente
 */

@Entity
@Table(name = "cliente", catalog = "pedidos", schema = "")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID id;
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
