package org.miralles.resume.service.domain.entity;

import java.util.Objects;

public final class ContactInfo {
    private final String email;
    private final String name;
    private final String surname;
    private final String gitUrl;
    private final String sonarUrl;
    private final String phoneNumber;
    private final String resumeOnlineUrl;
    private final LocationInfo locationInfo;

    public ContactInfo(final String email, final String name, final String surname, final String gitUrl,
                       final String sonarUrl, final String phoneNumber, final String resumeOnlineUrl,
                       final LocationInfo locationInfo) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.gitUrl = gitUrl;
        this.sonarUrl = sonarUrl;
        this.phoneNumber = phoneNumber;
        this.resumeOnlineUrl = resumeOnlineUrl;
        this.locationInfo = locationInfo;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getSonarUrl() {
        return sonarUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getResumeOnlineUrl() {
        return resumeOnlineUrl;
    }

    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInfo that = (ContactInfo) o;
        return email.equals(that.email) &&
                name.equals(that.name) &&
                surname.equals(that.surname) &&
                gitUrl.equals(that.gitUrl) &&
                sonarUrl.equals(that.sonarUrl) &&
                phoneNumber.equals(that.phoneNumber) &&
                resumeOnlineUrl.equals(that.resumeOnlineUrl) &&
                locationInfo.equals(that.locationInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, surname, gitUrl, sonarUrl, phoneNumber, resumeOnlineUrl, locationInfo);
    }
}
