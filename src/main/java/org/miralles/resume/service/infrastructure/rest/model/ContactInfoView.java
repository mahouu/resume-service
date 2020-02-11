package org.miralles.resume.service.infrastructure.rest.model;

import java.util.Objects;

public final class ContactInfoView {
    private final String emailView;
    private final String nameView;
    private final String surnameView;
    private final String gitUrlView;
    private final String sonarUrlView;
    private final String phoneNumberView;
    private final String resumeOnlineUrlView;

    public ContactInfoView(final String emailView, final String nameView, final String surnameView, final String gitUrlView,
                           final String sonarUrlView, final String phoneNumberView, final String resumeOnlineUrlView) {
        this.emailView = emailView;
        this.nameView = nameView;
        this.surnameView = surnameView;
        this.gitUrlView = gitUrlView;
        this.sonarUrlView = sonarUrlView;
        this.phoneNumberView = phoneNumberView;
        this.resumeOnlineUrlView = resumeOnlineUrlView;
    }

    public String getEmailView() {
        return emailView;
    }

    public String getNameView() {
        return nameView;
    }

    public String getSurnameView() {
        return surnameView;
    }

    public String getGitUrlView() {
        return gitUrlView;
    }

    public String getSonarUrlView() {
        return sonarUrlView;
    }

    public String getPhoneNumberView() {
        return phoneNumberView;
    }

    public String getResumeOnlineUrlView() {
        return resumeOnlineUrlView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactInfoView)) return false;
        ContactInfoView that = (ContactInfoView) o;
        return Objects.equals(getEmailView(), that.getEmailView()) &&
                Objects.equals(getNameView(), that.getNameView()) &&
                Objects.equals(getSurnameView(), that.getSurnameView()) &&
                Objects.equals(getGitUrlView(), that.getGitUrlView()) &&
                Objects.equals(getSonarUrlView(), that.getSonarUrlView()) &&
                Objects.equals(getPhoneNumberView(), that.getPhoneNumberView()) &&
                Objects.equals(getResumeOnlineUrlView(), that.getResumeOnlineUrlView());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmailView(), getNameView(), getSurnameView(), getGitUrlView(), getSonarUrlView(), getPhoneNumberView(), getResumeOnlineUrlView());
    }
}
