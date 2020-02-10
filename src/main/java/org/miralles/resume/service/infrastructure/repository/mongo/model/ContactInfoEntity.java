package org.miralles.resume.service.infrastructure.repository.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "resumedb")
public class ContactInfoEntity {
    private String email;
    private String name;
    private String surname;
    private String gitUrl;
    private String sonarUrl;
    private String phoneNumber;
    private String resumeOnlineUrl;

    public ContactInfoEntity(final String email, final String name, final String surname, final String gitUrl, final String sonarUrl, final String phoneNumber, final String resumeOnlineUrl) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.gitUrl = gitUrl;
        this.sonarUrl = sonarUrl;
        this.phoneNumber = phoneNumber;
        this.resumeOnlineUrl = resumeOnlineUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getSonarUrl() {
        return sonarUrl;
    }

    public void setSonarUrl(String sonarUrl) {
        this.sonarUrl = sonarUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResumeOnlineUrl() {
        return resumeOnlineUrl;
    }

    public void setResumeOnlineUrl(String resumeOnlineUrl) {
        this.resumeOnlineUrl = resumeOnlineUrl;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactInfoEntity)) return false;
        ContactInfoEntity that = (ContactInfoEntity) o;
        return Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getSurname(), that.getSurname()) &&
                Objects.equals(getGitUrl(), that.getGitUrl()) &&
                Objects.equals(getSonarUrl(), that.getSonarUrl()) &&
                Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
                Objects.equals(getResumeOnlineUrl(), that.getResumeOnlineUrl());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(email, name, surname, gitUrl, sonarUrl, phoneNumber, resumeOnlineUrl);
    }

    @Override
    public String toString() {
        return "ContactInfoEntity{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", sonarUrl='" + sonarUrl + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", resumeOnlineUrl='" + resumeOnlineUrl + '\'' +
                '}';
    }
}
