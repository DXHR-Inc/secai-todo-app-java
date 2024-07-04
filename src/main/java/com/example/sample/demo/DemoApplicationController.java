package com.example.sample.demo;

import com.example.sample.demo.model.Task;
import com.example.sample.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}