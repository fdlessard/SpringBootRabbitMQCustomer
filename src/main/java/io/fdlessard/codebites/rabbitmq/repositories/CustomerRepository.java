package io.fdlessard.codebites.rabbitmq.repositories;

import io.fdlessard.codebites.rabbitmq.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
