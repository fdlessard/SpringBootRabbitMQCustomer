package io.fdlessard.codebites.rabbitmq.repositories;

import io.fdlessard.codebites.rabbitmq.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends CrudRepository<Task, UUID> {

}
