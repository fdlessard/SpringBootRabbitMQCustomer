package io.fdlessard.codebites.rabittmq.controllers;


import io.fdlessard.codebites.rabittmq.domain.Customer;
import io.fdlessard.codebites.rabittmq.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/isAlive", produces = "application/json")
    public String isAlive() {
        LOGGER.info("CustomerController.isAlive()");
        return "Hello World from Customer Service";
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public Customer getCustomerById(@PathVariable long id) {
        LOGGER.info("CustomerController.getById({})", id);
        return customerService.getCustomerById(id);
    }

    @GetMapping(value = "/", produces = "application/json")
    @ResponseBody
    public List<Customer> getAllCustomers() {
        LOGGER.info("CustomerController.getAllCustomers()");
        return customerService.getAllCustomers();
    }

    @PostMapping(value = "/", produces = "application/json")
    public void createCustomer(@RequestBody Customer customer) {
        LOGGER.info("CustomerController.createCustomer({})", customer);
        customerService.createCustomer(customer);
    }
}
