package org.miralles.resume.service.infrastructure.repository.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "skill")
public class SkillEntity {
    private String language;

    private String description;
    private String level;
    private List<String> keywords;

    public SkillEntity(final String description, final String level, final List<String> keywords, final String language) {
        this.description = description;
        this.level = level;
        this.keywords = keywords;
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillEntity)) return false;
        SkillEntity that = (SkillEntity) o;
        return Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getLevel(), that.getLevel()) &&
                Objects.equals(getKeywords(), that.getKeywords()) &&
                Objects.equals(getLanguage(), that.getLanguage());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getDescription(), getLevel(), getKeywords(), getLanguage());
    }
}
