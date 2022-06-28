package com.ismael.acodike.pedidos.service.impl;

import com.ismael.acodike.pedidos.domain.Customer;
import com.ismael.acodike.pedidos.dto.CustomerDTO;
import com.ismael.acodike.pedidos.mapper.CustomerMapper;
import com.ismael.acodike.pedidos.repository.ClientRepository;
import com.ismael.acodike.pedidos.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<CustomerDTO> clientsDTO = new ArrayList<>();
        List<Customer> customers = repository.findAll();
        for (Customer customer : customers){
            clientsDTO.add(CustomerMapper.INSTANCE.customerToCustomerDTO(customer));
        }
        return clientsDTO;
    }

    @Override
    public CustomerDTO getById(Integer id) {
        Customer customer = repository.findById(id).orElse(null);

        return CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
        }

    @Override
    public List<CustomerDTO> getByTelephone(String telephone) {
        List<CustomerDTO> clientsDTO = new ArrayList<>();
        List<Customer> customers = repository.findAllByTelefono(telephone);
        for (Customer customer : customers){
            clientsDTO.add(CustomerMapper.INSTANCE.customerToCustomerDTO(customer));
        }
        return clientsDTO;

    }

    @Override
    public CustomerDTO create(CustomerDTO client) {
        Customer customerCreated = repository.save(CustomerMapper.INSTANCE.customerDTOToCustomer(client));
        return CustomerMapper.INSTANCE.customerToCustomerDTO(customerCreated);
    }

    @Override
    public CustomerDTO delete(Integer id) {
        Customer customer = repository.findById(id).orElse(null);
        if(customer != null){
            repository.delete(customer);
            return CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
        }else {
            return null;
        }
    }
}
