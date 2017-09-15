package io.fdlessard.codebites.rabbitmq.services;

import io.fdlessard.codebites.rabbitmq.SpringBootRabbitMqApplication;
import io.fdlessard.codebites.rabbitmq.domain.Customer;
import io.fdlessard.codebites.rabbitmq.listeners.Message;
import io.fdlessard.codebites.rabbitmq.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    private TaskService taskService;

    private RabbitTemplate rabbitTemplate;

    public CustomerService(CustomerRepository customerRepository, TaskService taskService, RabbitTemplate rabbitTemplate) {
        this.customerRepository = customerRepository;
        this.taskService = taskService;
        this.rabbitTemplate = rabbitTemplate;
    }

    public Customer getCustomerById(long id) {

        LOGGER.info("CustomerService.getById({})", id);
        return customerRepository.findOne(id);
    }

    public List<Customer> getAllCustomers() {

        LOGGER.info("CustomerService.getAllCustomers()");
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public void createCustomer(Customer customer) {

        LOGGER.info("CustomerService.createCustomer() - {}", customer);
        UUID taskId = taskService.createTask();
        Message<Customer> customerMessage = new Message<>(taskId, customer);
        rabbitTemplate.convertAndSend(SpringBootRabbitMqApplication.SFG_MESSAGE_QUEUE, customerMessage);
        customerRepository.save(customer);
    }

}
