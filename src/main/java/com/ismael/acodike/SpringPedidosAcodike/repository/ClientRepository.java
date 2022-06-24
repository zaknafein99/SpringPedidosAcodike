package com.ismael.acodike.SpringPedidosAcodike.repository;

import com.ismael.acodike.SpringPedidosAcodike.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findAllByTelefono(String telephone);
}
