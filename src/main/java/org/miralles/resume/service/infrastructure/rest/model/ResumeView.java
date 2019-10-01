package org.miralles.resume.service.infrastructure.rest.model;

public final class ResumeView {
    private final ContactInfoView contactInfoView;

    public ResumeView(ContactInfoView contactInfoView) {
        this.contactInfoView = contactInfoView;
    }

    public ContactInfoView getContactInfoView() {
        return contactInfoView;
    }
}
