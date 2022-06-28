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
@Table(name = "moviles", catalog = "pedidos")
public class Truck {

    @Id
    @Basic(optional = false)
    @Column(name = "nromovil")
    private Integer truckNumber;
    @Column(name = "observaciones")
    private String observations;
//    @OneToMany(mappedBy = "idMovil")
//    private Collection<Order> pedidosCollection;
}
