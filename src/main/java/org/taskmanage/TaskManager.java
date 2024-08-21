package org.taskmanage;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManager {
    private static final TaskManager instance;
    private final Map<String, Task> tasks;
    private final Map<String, User> users;
    static {
        instance = new TaskManager();
    }
    private TaskManager() {
        tasks = new ConcurrentHashMap<>();
        users = new ConcurrentHashMap<>();
    }

    public static TaskManager getInstance() {
        return instance;
    }

    public Task createTask(TaskMetadata metadata, User assignedUser) throws InterruptedException {
        Task task = new Task(metadata, assignedUser);
        users.put(assignedUser.getId(), assignedUser);
        tasks.put(task.getId(), task);
        return task;
    }

    public void update(Task task, TaskMetadata taskMetadata) {
        if(taskMetadata.getDescription() != null) {
            task.getMetadata().setDescription(taskMetadata.getDescription());
        }
        if(taskMetadata.getDueDate() != null) {
            task.getMetadata().setDueDate(taskMetadata.getDueDate());
        }
        if(taskMetadata.getPriority() != null) {
            task.getMetadata().setPriority(taskMetadata.getPriority());
        }
        if(taskMetadata.getStatus() != null) {
            task.getMetadata().setStatus(taskMetadata.getStatus());
        }
        if(taskMetadata.getTitle() != null) {
            task.getMetadata().setTitle(taskMetadata.getTitle());
        }
    }

    public void assign(Task task, User user) {
        users.putIfAbsent(user.getId(), user);
        task.setAssignedUser(user);
    }

    public void delete(Task task) {
        tasks.remove(task.getId());
    }

    public List<Task> search(String query) {
        return tasks.values().stream()
                .filter(task -> task.getMetadata().getDescription().contains(query) ||
                        task.getMetadata().getTitle().contains(query)).toList();
    }

    public List<Task> filter(Integer priority, TaskStatus status, User user, Date dueDate) {
        return tasks.values().stream()
                .filter(task -> priority == null || task.getMetadata().getPriority() == priority)
                .filter(task -> status == null || task.getMetadata().getStatus() == status)
                .filter(task -> user == null || task.getAssignedUser() == user)
                .filter(task -> dueDate == null || task.getMetadata().getDueDate().compareTo(dueDate) <= 0)
                .toList();
    }

    public Map<String, Task> getTasks() {
        return new HashMap<>(tasks);
    }
}
