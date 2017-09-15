package io.fdlessard.codebites.rabbitmq.controllers;


import io.fdlessard.codebites.rabbitmq.domain.Task;
import io.fdlessard.codebites.rabbitmq.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/isAlive", produces = "application/json")
    public String isAlive() {
        LOGGER.info("TaskController.isAlive()");
        return "Hello World from Customer Service - task";
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public Task getTaskById(@PathVariable UUID id) {
        LOGGER.info("TaskController.getTaskById({})", id);
        return taskService.getTaskById(id);
    }

    @GetMapping(value = "/", produces = "application/json")
    @ResponseBody
    public List<Task> getAllTasks() {
        LOGGER.info("TaskController.getAllTasks()");
        return taskService.getAllTasks();
    }
}
