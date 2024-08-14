package com.task.management;

public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // Adding tasks
        taskList.addTask(new Task("T001", "Design Homepage", "Pending"));
        taskList.addTask(new Task("T002", "Develop Login Module", "In Progress"));
        taskList.addTask(new Task("T003", "Test Payment Gateway", "Completed"));

        // Traverse tasks
        System.out.println("Task list:");
        taskList.traverseTasks();

        // Search for a task
        Task task = taskList.searchTask("T002");
        if (task != null) {
            System.out.println("\nFound task: " + task.getTaskName() + ", " + task.getStatus());
        } else {
            System.out.println("\nTask not found.");
        }

        // Delete a task
        taskList.deleteTask("T002");

        // Traverse tasks after deletion
        System.out.println("\nTask list after deletion:");
        taskList.traverseTasks();
    }
}
