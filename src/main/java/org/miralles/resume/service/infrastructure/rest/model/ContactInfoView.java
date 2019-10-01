package org.miralles.resume.service.infrastructure.rest.model;

public final class ContactInfoView {
    private final String email;
    private final String name;
    private final String surname;
    private final String gitUrl;
    private final String sonarUrl;
    private final String phoneNumber;
    private final String resumeOnlineUrl;

    public ContactInfoView(final String email, final String name, final String surname, final String gitUrl,
                           final String sonarUrl, final String phoneNumber, final String resumeOnlineUrl) {
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
}
