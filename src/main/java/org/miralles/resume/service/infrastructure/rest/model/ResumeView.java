package org.miralles.resume.service.infrastructure.rest.model;

import java.util.Objects;

public final class ResumeView {
    private final ContactInfoView contactInfoView;

    public ResumeView(ContactInfoView contactInfoView) {
        this.contactInfoView = contactInfoView;
    }

    public ContactInfoView getContactInfoView() {
        return contactInfoView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResumeView)) return false;
        ResumeView that = (ResumeView) o;
        return getContactInfoView().equals(that.getContactInfoView());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContactInfoView());
    }
}
