/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ismael.acodike.pedidos.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pedidos", catalog = "pedidos")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime fechaPedido;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Integer fee;
    
    private String observations;

    @ManyToOne
    @JoinColumn(name = "truck_one")
    private Truck truckOne;
    @ManyToOne
    @JoinColumn(name = "truck_two")
    private Truck truckTwo;

    @ManyToOne
    @JoinColumn(name = "assigned_truck")
    private Truck assignedTruck;

    private List<OrderLine> orderLines;

    private Integer total;

    private boolean delivered;
}
