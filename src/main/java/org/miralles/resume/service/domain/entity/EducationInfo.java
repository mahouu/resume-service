package org.miralles.resume.service.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class EducationInfo {
    private final List<Education> educationInfo;

    public EducationInfo(List<Education> education) {
        this.educationInfo = Collections.unmodifiableList(new ArrayList<>(education));
    }

    public List<Education> getEducationInfo() {
        return educationInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EducationInfo)) return false;
        EducationInfo that = (EducationInfo) o;
        return Objects.equals(getEducationInfo(), that.getEducationInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEducationInfo());
    }
}
