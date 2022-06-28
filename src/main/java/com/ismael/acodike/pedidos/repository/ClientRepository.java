package com.ismael.acodike.pedidos.repository;

import com.ismael.acodike.pedidos.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByTelefono(String telephone);
}
