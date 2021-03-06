package org.miralles.resume.service.domain.entity;

import java.util.Objects;

public final class Education {
    private final String language;
    private final String date;
    private final String title;
    private final String subTitle;
    private final String description;

    public Education(final String language, final String date, final String title, final String subTitle, final String description) {
        this.language = language;
        this.date = date;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Education)) return false;
        Education education = (Education) o;
        return Objects.equals(getLanguage(), education.getLanguage()) &&
                Objects.equals(getDate(), education.getDate()) &&
                Objects.equals(getTitle(), education.getTitle()) &&
                Objects.equals(getSubTitle(), education.getSubTitle()) &&
                Objects.equals(getDescription(), education.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLanguage(), getDate(), getTitle(), getSubTitle(), getDescription());
    }

    @Override
    public String toString() {
        return "Education{" +
                "language='" + language + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
