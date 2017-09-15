package io.fdlessard.codebites.rabbitmq.listeners;

import io.fdlessard.codebites.rabbitmq.domain.Customer;
import io.fdlessard.codebites.rabbitmq.repositories.CustomerRepository;
import io.fdlessard.codebites.rabbitmq.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class CustomerMessageListener {

    private CustomerRepository customerRepository;

    private TaskRepository taskRepository;

    public CustomerMessageListener(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void receiveMessage(Message<Customer> message) {

        LOGGER.info("CustomerMessageListener.receiveMessage() - Received message task {}", message);

        customerRepository.save(message.getPayload());

        LOGGER.info("Message processed...");
    }
}
