package org.miralles.resume.service.infrastructure.rest.adapter;

import org.miralles.resume.service.domain.entity.ResumeResponse;
import org.miralles.resume.service.infrastructure.rest.model.ContactInfoView;

public class ContactInfoViewAdapter {
    public ContactInfoView adaptContactInfoViewFromDomain(ResumeResponse resumeResponse) {
        return new ContactInfoView(
                resumeResponse.getContactInfo().getEmail(),
                resumeResponse.getContactInfo().getName(),
                resumeResponse.getContactInfo().getSurname(),
                resumeResponse.getContactInfo().getGitUrl(),
                resumeResponse.getContactInfo().getSonarUrl(),
                resumeResponse.getContactInfo().getPhoneNumber(),
                resumeResponse.getContactInfo().getResumeOnlineUrl());
    }
}
