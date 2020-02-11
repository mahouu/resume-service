package org.miralles.resume.service.infrastructure.rest.model;

import java.util.Objects;

public final class EducationView {
    private final String languageView;
    private final String dateView;
    private final String titleView;
    private final String subTitleView;
    private final String descriptionView;

    public EducationView(final String languageView, final String dateView, final String titleView, final String subTitleView, final String descriptionView) {
        this.languageView = languageView;
        this.dateView = dateView;
        this.titleView = titleView;
        this.subTitleView = subTitleView;
        this.descriptionView = descriptionView;
    }

    public String getLanguageView() {
        return languageView;
    }

    public String getDateView() {
        return dateView;
    }

    public String getTitleView() {
        return titleView;
    }

    public String getSubTitleView() {
        return subTitleView;
    }

    public String getDescriptionView() {
        return descriptionView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EducationView)) return false;
        EducationView education = (EducationView) o;
        return Objects.equals(getLanguageView(), education.getLanguageView()) &&
                Objects.equals(getDateView(), education.getDateView()) &&
                Objects.equals(getTitleView(), education.getTitleView()) &&
                Objects.equals(getSubTitleView(), education.getSubTitleView()) &&
                Objects.equals(getDescriptionView(), education.getDescriptionView());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLanguageView(), getDateView(), getTitleView(), getSubTitleView(), getDescriptionView());
    }
}
