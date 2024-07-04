package com.example.sample.demo.service;

import com.example.sample.demo.model.Task;
import com.example.sample.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
  @Autowired
  private TaskRepository taskRepository;

  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }
}