package io.fdlessard.codebites.rabittmq.repositories;

import io.fdlessard.codebites.rabittmq.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends CrudRepository<Task, UUID> {

}
