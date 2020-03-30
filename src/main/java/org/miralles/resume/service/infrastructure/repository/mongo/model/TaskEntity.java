package org.miralles.resume.service.infrastructure.repository.mongo.model;

import java.util.Objects;

public class TaskEntity {
    private String taskDescription;

    public TaskEntity(final String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskEntity)) return false;
        TaskEntity that = (TaskEntity) o;
        return Objects.equals(getTaskDescription(), that.getTaskDescription());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getTaskDescription());
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
