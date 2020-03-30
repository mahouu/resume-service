package org.miralles.resume.service.infrastructure.rest.model;

import java.util.Objects;

public final class TaskView {
    private final String description;

    public TaskView(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskView)) return false;
        TaskView task = (TaskView) o;
        return Objects.equals(getDescription(), task.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }
}
