package org.miralles.resume.service.infrastructure.repository.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "experience")
public class ExperienceEntity {
    private String language;
    private String title;
    private String company;
    private String url;
    private String roleDescription;
    private String startDate;
    private String endDate;
    private List<TaskEntity> tasks;

    public ExperienceEntity(final String language, final String title, final String company, final String url,
                            final String roleDescription, final String startDate, final String endDate,
                            final List<TaskEntity> tasks) {
        this.language = language;
        this.title = title;
        this.company = company;
        this.url = url;
        this.roleDescription = roleDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = new ArrayList<TaskEntity>(tasks);
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

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperienceEntity)) return false;
        ExperienceEntity that = (ExperienceEntity) o;
        return Objects.equals(getLanguage(), that.getLanguage()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getCompany(), that.getCompany()) &&
                Objects.equals(getUrl(), that.getUrl()) &&
                Objects.equals(getRoleDescription(), that.getRoleDescription()) &&
                Objects.equals(getStartDate(), that.getStartDate()) &&
                Objects.equals(getEndDate(), that.getEndDate()) &&
                Objects.equals(getTasks(), that.getTasks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLanguage(), getTitle(), getCompany(), getUrl(), getRoleDescription(), getStartDate(), getEndDate(), getTasks());
    }
}
