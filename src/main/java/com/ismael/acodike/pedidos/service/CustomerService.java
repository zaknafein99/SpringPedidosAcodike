package com.ismael.acodike.pedidos.service;

import com.ismael.acodike.pedidos.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<CustomerDTO> getAll();
    CustomerDTO getById(Integer id);
    List<CustomerDTO> getByTelephone(String telephone);

    CustomerDTO create(CustomerDTO client);

    CustomerDTO delete(Integer id);
}
