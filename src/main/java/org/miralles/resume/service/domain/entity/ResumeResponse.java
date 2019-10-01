package org.miralles.resume.service.domain.entity;

import java.util.Objects;

public final class ResumeResponse {
    private final ContactInfo contactInfo;

    public ResumeResponse(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumeResponse that = (ResumeResponse) o;
        return contactInfo.equals(that.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactInfo);
    }
}
