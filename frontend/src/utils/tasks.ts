'use server';

import { Task } from "@/app/page";

export async function fetchTasks() {
  const response = await fetch("http://localhost:8080/api/tasks");
  if (!response.ok) {
    throw new Error("Failed to fetch tasks");
  }
  return response.json();
}

export async function addTask(task: Task) {
  const response = await fetch("http://localhost:8080/api/tasks", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(task),
  });
  if (!response.ok) {
    throw new Error("Failed to add task");
  }
}

export async function updateTask(task: Task) {
  const response = await fetch(`http://localhost:8080/api/tasks`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(task),
  });
  if (!response.ok) {
    throw new Error("Failed to update task");
  }
}

export async function deleteTask(task: Task) {
  const response = await fetch(`http://localhost:8080/api/tasks/${task.id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  });
  if (!response.ok) {
    throw new Error("Failed to delete task");
  }
}