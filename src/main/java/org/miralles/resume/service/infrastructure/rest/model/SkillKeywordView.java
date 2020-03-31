package org.miralles.resume.service.infrastructure.rest.model;

import java.util.Objects;

public final class SkillKeywordView {
    private final String skillKeywordDescription;

    public SkillKeywordView(String skillKeywordDescription) {
        this.skillKeywordDescription = skillKeywordDescription;
    }

    public final String getSkillKeywordDescription() {
        return skillKeywordDescription;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillKeywordView)) return false;
        SkillKeywordView that = (SkillKeywordView) o;
        return Objects.equals(getSkillKeywordDescription(), that.getSkillKeywordDescription());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getSkillKeywordDescription());
    }
}
