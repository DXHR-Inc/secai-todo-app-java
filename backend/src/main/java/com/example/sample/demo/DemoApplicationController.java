package com.example.sample.demo;

import com.example.sample.demo.model.Task;
import com.example.sample.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class DemoApplicationController {

  @Autowired
  private TaskService taskService;

  @GetMapping("/hello")
  public String test() {
    return "Hello World!";
  }

  @GetMapping("/tasks")
  public List<Task> getTasks() {
    return taskService.getAllTasks();
  }

  @PostMapping("/tasks")
  public Task createTask(@RequestBody Task task) {
    return taskService.createTask(task);
  }

  @PutMapping("/tasks")
  public Task updateTask(@RequestBody Task task) {
    return taskService.updateTask(task);
  }

  @DeleteMapping("/tasks/{id}")
  public void deleteTask(@PathVariable String id) {
    Long taskId = Long.parseLong(id);
    taskService.deleteTask(taskId);
  }
}