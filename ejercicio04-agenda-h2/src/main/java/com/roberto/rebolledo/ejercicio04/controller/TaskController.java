package com.roberto.rebolledo.ejercicio04.controller;

import com.roberto.rebolledo.ejercicio04.models.Task;
import com.roberto.rebolledo.ejercicio04.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public List<Task> getAllTasks()  {
        return taskService.findAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }

    @PostMapping("/{id}")
    public Task createTask(@PathVariable("id") Long usuarioId, @RequestBody Task task) {
        return taskService.createTask(task, usuarioId);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
