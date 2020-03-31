package org.miralles.resume.service.domain.entity;

import java.util.Objects;

public final class SkillKeyword {
    private final String skillKeywordDescription;

    public SkillKeyword(String skillKeywordDescription) {
        this.skillKeywordDescription = skillKeywordDescription;
    }

    public final String getSkillKeywordDescription() {
        return skillKeywordDescription;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillKeyword)) return false;
        SkillKeyword that = (SkillKeyword) o;
        return Objects.equals(getSkillKeywordDescription(), that.getSkillKeywordDescription());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getSkillKeywordDescription());
    }
}
