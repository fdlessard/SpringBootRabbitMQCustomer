package io.fdlessard.codebites.rabittmq.services;

import io.fdlessard.codebites.rabittmq.domain.Task;
import io.fdlessard.codebites.rabittmq.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTaskById(UUID id) {

        LOGGER.info("TaskService.getTaskById({})", id);
        return taskRepository.findOne(id);
    }

    public List<Task> getAllTasks() {

        LOGGER.info("TaskService.getAllTasks()");

        List<Task> task = new ArrayList<>();
        taskRepository.findAll().forEach(task::add);

        return task;
    }

    public UUID createTask() {

        LOGGER.info("TaskService.createTask()");

        UUID taskId = UUID.randomUUID();
        Task task = Task.builder().taskId(taskId).status("IN-PROCESS").build();
        taskRepository.save(task);

        return taskId;

    }

    public void updateTaskStatus(UUID taskId, String newStatus) {

        LOGGER.info("TaskService.updateTaskStatus({}, {})", taskId, newStatus);

        Task task = taskRepository.findOne(taskId);
        task.setStatus(newStatus);

        taskRepository.save(task);
    }

}
