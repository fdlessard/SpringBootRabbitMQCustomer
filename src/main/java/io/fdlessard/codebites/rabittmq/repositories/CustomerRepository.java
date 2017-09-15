package io.fdlessard.codebites.rabittmq.repositories;

import io.fdlessard.codebites.rabittmq.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
