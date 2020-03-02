package org.miralles.resume.service.domain.entity;

import java.util.Objects;

public final class Task {
    private final String description;

    public Task(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(getDescription(), task.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }
}
