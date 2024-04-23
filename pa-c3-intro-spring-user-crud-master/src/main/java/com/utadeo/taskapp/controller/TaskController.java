package com.utadeo.taskapp.controller;

import com.utadeo.taskapp.dto.ApiReponse;
import com.utadeo.taskapp.dto.TaskDto;
import com.utadeo.taskapp.model.Task;
import com.utadeo.taskapp.service.ITaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    private ITaskService taskService;

    TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    Task store(@RequestBody TaskDto taskDto) {

        return this.taskService.createTask(taskDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
       this.taskService.deleteTask(id);

    }
}