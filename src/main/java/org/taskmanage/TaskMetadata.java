package org.taskmanage;

import java.util.Date;

public class TaskMetadata {
    private String title;
    private String description;
    private Integer priority;
    private Date dueDate;
    private TaskStatus status;

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Integer getPriority() {
        return priority;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public TaskStatus getStatus() {
        return status;
    }
    public static TaskMetadataBuilder builder() {
        return new TaskMetadataBuilder();
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    public static class TaskMetadataBuilder {
        private String title;
        private String description;
        private Integer priority;
        private Date dueDate;
        private TaskStatus status;

        public TaskMetadataBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public TaskMetadataBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public TaskMetadataBuilder withPriority(Integer priority) {
            this.priority = priority;
            return this;
        }

        public TaskMetadataBuilder withDueDate(Date dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public TaskMetadataBuilder withStatus(TaskStatus status) {
            this.status = status;
            return this;
        }

        public TaskMetadata build() {
            TaskMetadata taskMetadata = new TaskMetadata();
            taskMetadata.title = this.title;
            taskMetadata.description = this.description;
            taskMetadata.priority = this.priority;
            taskMetadata.dueDate = this.dueDate;
            taskMetadata.status = this.status;
            return taskMetadata;
        }
    }
}
