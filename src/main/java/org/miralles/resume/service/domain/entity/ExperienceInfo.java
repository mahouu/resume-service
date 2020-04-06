package org.miralles.resume.service.domain.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public final class ExperienceInfo {
    private final List<Experience> experiences;

    public ExperienceInfo(List<Experience> experiences) {
        this.experiences = unmodifiableList(new LinkedList<>(experiences));
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperienceInfo)) return false;
        ExperienceInfo that = (ExperienceInfo) o;
        return Objects.equals(getExperiences(), that.getExperiences());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExperiences());
    }

    @Override
    public String toString() {
        return "ExperienceInfo{" +
                "experiences=" + experiences +
                '}';
    }
}
