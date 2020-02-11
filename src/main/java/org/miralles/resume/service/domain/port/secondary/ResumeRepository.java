package org.miralles.resume.service.domain.port.secondary;

import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.EducationInfo;

public interface ResumeRepository {
    ContactInfo getContactInfo();
    EducationInfo getEducationInfoBy(final String language);
}
