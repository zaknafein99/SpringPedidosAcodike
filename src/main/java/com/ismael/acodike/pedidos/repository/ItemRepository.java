package com.ismael.acodike.pedidos.repository;

import com.ismael.acodike.pedidos.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
