package org.miralles.resume.service.infrastructure.rest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public class ExperienceView {
    private final String titleView;
    private final String companyView;
    private final String urlView;
    private final String roleDescriptionView;
    private final String startDateView;
    private final String endDateView;
    private final List<TaskView> tasksView;


    public ExperienceView(final String titleView, final String companyView, final String urlView, final String roleDescriptionView,
                          final String startDateView, final String endDateView, final List<TaskView> tasksView) {
        this.titleView = titleView;
        this.companyView = companyView;
        this.urlView = urlView;
        this.roleDescriptionView = roleDescriptionView;
        this.startDateView = startDateView;
        this.endDateView = endDateView;
        this.tasksView = unmodifiableList(new ArrayList<>(tasksView));
    }

    public String getTitleView() {
        return titleView;
    }

    public String getCompanyView() {
        return companyView;
    }

    public String getUrlView() {
        return urlView;
    }

    public String getRoleDescriptionView() {
        return roleDescriptionView;
    }

    public String getStartDateView() {
        return startDateView;
    }

    public String getEndDateView() {
        return endDateView;
    }

    public List<TaskView> getTasksView() {
        return tasksView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperienceView)) return false;
        ExperienceView that = (ExperienceView) o;
        return Objects.equals(getTitleView(), that.getTitleView()) &&
                Objects.equals(getCompanyView(), that.getCompanyView()) &&
                Objects.equals(getUrlView(), that.getUrlView()) &&
                Objects.equals(getRoleDescriptionView(), that.getRoleDescriptionView()) &&
                Objects.equals(getStartDateView(), that.getStartDateView()) &&
                Objects.equals(getEndDateView(), that.getEndDateView()) &&
                Objects.equals(getTasksView(), that.getTasksView());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitleView(), getCompanyView(), getUrlView(), getRoleDescriptionView(), getStartDateView(), getEndDateView(), getTasksView());
    }
}
