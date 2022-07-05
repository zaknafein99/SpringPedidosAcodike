package com.ismael.acodike.pedidos.controller;

import com.ismael.acodike.pedidos.dto.CustomerDTO;
import com.ismael.acodike.pedidos.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("unused")
@Tag(name = "Customer", description = "Operations about Customers")
@RequestMapping("/api/v1")
@RestController
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @Operation(summary = "Get all customers", description = "Get all Customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of customers"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = service.getAll();
        return ResponseEntity.ok(customers);
    }

    @Operation(summary = "Get customer by id", description = "Get customer by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved customer"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer id) {
        CustomerDTO customer = service.getById(id);
        return ResponseEntity.ok(customer);
    }

    @Operation(summary = "Get customer by telephone", description = "Get customer by telephone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved customer by telephone"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @GetMapping("/customers/phone/{phone}")
    public ResponseEntity<List<CustomerDTO>> getCustomerByTelephone(@PathVariable String phone) {
        List<CustomerDTO> customer = service.getByTelephone(phone);
        return ResponseEntity.ok(customer);
    }

    @Operation(summary = "Create customer", description = "Create customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created customer"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @PostMapping(path = "/customers", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer) {
        CustomerDTO newCustomer = service.create(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @Operation(summary = "Delete customer", description = "Delete customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted customer"),
            @ApiResponse(responseCode = "403", description = "Access to the resource requested is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource requested does not exist")
    })
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable Integer id) {
        CustomerDTO deleted = service.delete(id);

        if(deleted == null) {
            return ResponseEntity.notFound().build();
        }else {
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }
    }

}
