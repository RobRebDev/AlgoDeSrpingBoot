package com.roberto.rebolledo.ejercicio04.repository;

import com.roberto.rebolledo.ejercicio04.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
