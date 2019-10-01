package org.miralles.resume.service.domain.port.secondary;

import org.miralles.resume.service.domain.entity.ContactInfo;

public interface ResumeRepository {
    ContactInfo getContactInfo();
}
