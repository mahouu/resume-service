package org.miralles.resume.service.infrastructure.rest.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class SkillView {
    private final String description;
    private final String level;
    private final List<SkillKeywordView> keywords;

    public SkillView(final String description, final String level, final List<SkillKeywordView> keywords) {
        this.description = description;
        this.level = level;
        this.keywords = Collections.unmodifiableList(new ArrayList<>(keywords));
    }

    public final String getDescription() {
        return description;
    }

    public final String getLevel() {
        return level;
    }

    public final List<SkillKeywordView> getKeywords() {
        return keywords;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillView)) return false;
        SkillView skill = (SkillView) o;
        return Objects.equals(getDescription(), skill.getDescription()) &&
                Objects.equals(getLevel(), skill.getLevel()) &&
                Objects.equals(getKeywords(), skill.getKeywords());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getDescription(), getLevel(), getKeywords());
    }
}
