package org.miralles.resume.service.infrastructure.rest.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class EducationInfoView {
    private final List<EducationView> educationInfo;

    public EducationInfoView(final List<EducationView> education) {
        this.educationInfo = Collections.unmodifiableList(new ArrayList<>(education));
    }

    public List<EducationView> getEducationInfo() {
        return educationInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EducationInfoView)) return false;
        EducationInfoView that = (EducationInfoView) o;
        return Objects.equals(getEducationInfo(), that.getEducationInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEducationInfo());
    }
}
