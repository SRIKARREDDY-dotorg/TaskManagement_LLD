package org.taskmanage;

public class Task {
    private final String id;
    private TaskMetadata metadata;
    private User assignedUser;

    public Task(TaskMetadata metadata, User assignedUser) throws InterruptedException {
        this.id = generateId();
        Thread.sleep(200);
        this.metadata = metadata;
        this.assignedUser = assignedUser;
    }

    public String getId() {
        return id;
    }
    public TaskMetadata getMetadata() {
        return metadata;
    }
    public User getAssignedUser() {
        return assignedUser;
    }
    public void setMetadata(TaskMetadata metadata) {
        this.metadata = metadata;
    }
    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }
    String generateId() {
        return String.valueOf(System.currentTimeMillis());
    }
}
