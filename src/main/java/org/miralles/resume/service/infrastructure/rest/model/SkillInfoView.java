package org.miralles.resume.service.infrastructure.rest.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class SkillInfoView {
    private final List<SkillView> skillViews;

    public SkillInfoView(final List<SkillView> skill) {
        this.skillViews = Collections.unmodifiableList(new ArrayList<>(skill));
    }

    public List<SkillView> getSkillViews() {
        return skillViews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillInfoView)) return false;
        SkillInfoView that = (SkillInfoView) o;
        return Objects.equals(getSkillViews(), that.getSkillViews());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkillViews());
    }
}
