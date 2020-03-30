package org.miralles.resume.service.infrastructure.rest.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ExperienceInfoView {
    private final List<ExperienceView> experienceInfoViews;

    public ExperienceInfoView(final List<ExperienceView> experienceViews) {
        this.experienceInfoViews = Collections.unmodifiableList(new ArrayList<>(experienceViews));
    }

    public List<ExperienceView> getExperienceInfoViews() {
        return experienceInfoViews;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperienceInfoView)) return false;
        ExperienceInfoView that = (ExperienceInfoView) o;
        return Objects.equals(getExperienceInfoViews(), that.getExperienceInfoViews());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getExperienceInfoViews());
    }
}
