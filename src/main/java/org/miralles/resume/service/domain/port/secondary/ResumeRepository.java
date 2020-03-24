package org.miralles.resume.service.domain.port.secondary;

import org.miralles.resume.service.domain.entity.ContactInfo;
import org.miralles.resume.service.domain.entity.EducationInfo;
import org.miralles.resume.service.domain.entity.ExperienceInfo;

public interface ResumeRepository {
    ContactInfo getContactInfo();

    EducationInfo getEducationInfoBy(final String language);

    ExperienceInfo getExperienceInfoBy(final String language);
}
