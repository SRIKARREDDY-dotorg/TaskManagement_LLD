package org.taskmanage;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static TaskManager taskManager;
    public static void main(String[] args) throws InterruptedException {
        taskManager = TaskManager.getInstance();

        TaskMetadata taskMetadata1 = TaskMetadata.builder()
                                                .withDescription("Work on the code changes of task management system")
                                                .withTitle("Code changes")
                                                .withPriority(1)
                                                .withDueDate(Date.from(Instant.now().plus(2, ChronoUnit.DAYS)))
                                                .withStatus(TaskStatus.ASSIGNED)
                                                .build();
        TaskMetadata taskMetadata2 = TaskMetadata.builder()
                                                .withDescription("Work on the deployment of the changes")
                                                .withTitle("Deployment of TMS")
                                                .withPriority(2)
                                                .withDueDate(Date.from(Instant.now().plus(2, ChronoUnit.DAYS)))
                                                .withStatus(TaskStatus.ASSIGNED)
                                                .build();
        User user1 = new User("Srikar","pochaan@exaple.com");
        User user2 = new User("Reddy","pochaanana@exaple.com");

        TaskMetadata taskMetadata3 = TaskMetadata.builder().withStatus(TaskStatus.IN_PROGRESS).build();
        Task task1 = taskManager.createTask(taskMetadata1, user1);
        Task task2 = taskManager.createTask(taskMetadata2, user2);

        taskManager.update(task1, taskMetadata3);

        display();

        taskManager.delete(task2);
        taskManager.assign(task1, user2);

        display();
    }

    public static void display() {
        Map<String, Task> tasks = taskManager.getTasks();

        for (Map.Entry<String, Task> entry : tasks.entrySet()) {
            Task task = entry.getValue();
            System.out.println("Task ID: " + task.getId());
            System.out.println("Task Title: " + task.getMetadata().getTitle());
            System.out.println("Task Description: " + task.getMetadata().getDescription());
            System.out.println("Task Status: " + task.getMetadata().getStatus());
            System.out.println("Task Priority: " + task.getMetadata().getPriority());
            System.out.println("Task Due Date: " + task.getMetadata().getDueDate());
            System.out.println("Task Assigned User: " + task.getAssignedUser().getName());
            System.out.println();
        }
    }
}