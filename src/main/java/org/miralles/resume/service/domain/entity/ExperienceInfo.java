package org.miralles.resume.service.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public final class ExperienceInfo {
    private final String title;
    private final String company;
    private final String url;
    private final String roleDescription;
    private final String startDate;
    private final String endDate;
    private final List<Task> tasks;


    public ExperienceInfo(final String title, final String company, final String url, final String roleDescription,
                          final String startDate, final String endDate, final List<Task> tasks) {
        this.title = title;
        this.company = company;
        this.url = url;
        this.roleDescription = roleDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = unmodifiableList(new ArrayList<>(tasks));
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getUrl() {
        return url;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperienceInfo)) return false;
        ExperienceInfo that = (ExperienceInfo) o;
        return Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getCompany(), that.getCompany()) &&
                Objects.equals(getUrl(), that.getUrl()) &&
                Objects.equals(getRoleDescription(), that.getRoleDescription()) &&
                Objects.equals(getStartDate(), that.getStartDate()) &&
                Objects.equals(getEndDate(), that.getEndDate()) &&
                Objects.equals(getTasks(), that.getTasks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCompany(), getUrl(), getRoleDescription(), getStartDate(), getEndDate(), getTasks());
    }
}
