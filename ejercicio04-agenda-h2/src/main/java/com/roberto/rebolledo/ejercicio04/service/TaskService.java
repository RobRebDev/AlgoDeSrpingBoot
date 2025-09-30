package com.roberto.rebolledo.ejercicio04.service;

import com.roberto.rebolledo.ejercicio04.models.Task;
import com.roberto.rebolledo.ejercicio04.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    private final UsuarioService usuarioService;

    public TaskService(TaskRepository taskRepository, UsuarioService usuarioService) {
        this.taskRepository = taskRepository;
        this.usuarioService = usuarioService;
    }

    public Task createTask(Task task, Long usuarioId) {
        task.setUsuario(usuarioService.findUsuarioById(usuarioId));
        return taskRepository.save(task);
    }

    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }


}
