package org.miralles.resume.service.infrastructure.repository.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "education")
public class EducationEntity {
    private String language;
    private String startDate;
    private String endDate;
    private String title;
    private String subTitle;
    private String description;

    public EducationEntity(String language, String startDate, String endDate, String title, String subTitle, String description) {
        this.language = language;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EducationEntity)) return false;
        EducationEntity that = (EducationEntity) o;
        return Objects.equals(getLanguage(), that.getLanguage()) &&
                Objects.equals(getStartDate(), that.getStartDate()) &&
                Objects.equals(getEndDate(), that.getEndDate()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getSubTitle(), that.getSubTitle()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getLanguage(), getStartDate(), getEndDate(), getTitle(), getSubTitle(), getDescription());
    }

    @Override
    public final String toString() {
        return "EducationEntity{" +
                "language='" + language + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
