/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ismael.acodike.pedidos.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "articulos", catalog = "pedidos")
public class Item {

    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    @Id
    private Integer codigo;

    @Column(name = "nombre", length = 65535)
    private String nombre;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "kgs")
    private Integer kgs;
//    @OneToMany(mappedBy = "idArticulo")
//    private Collection<Pedidos> pedidosCollection;



}
